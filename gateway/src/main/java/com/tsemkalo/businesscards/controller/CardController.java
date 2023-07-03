package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.DeleteCardProto;
import com.tsemkalo.businesscards.EditAddressProto;
import com.tsemkalo.businesscards.EditAppearanceProto;
import com.tsemkalo.businesscards.EditCardProto;
import com.tsemkalo.businesscards.EditContactProto;
import com.tsemkalo.businesscards.EditGalleryPhotoProto;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.IdValue;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.AddressDTO;
import com.tsemkalo.businesscards.dto.cards.AppearanceDTO;
import com.tsemkalo.businesscards.dto.cards.CardDTO;
import com.tsemkalo.businesscards.dto.cards.ContactDTO;
import com.tsemkalo.businesscards.dto.cards.GalleryPhotoDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.mapper.cards.AddressMapper;
import com.tsemkalo.businesscards.mapper.cards.AppearanceMapper;
import com.tsemkalo.businesscards.mapper.cards.CardMapper;
import com.tsemkalo.businesscards.mapper.cards.ContactMapper;
import com.tsemkalo.businesscards.mapper.cards.FollowMapper;
import com.tsemkalo.businesscards.mapper.cards.GalleryPhotoMapper;
import com.tsemkalo.businesscards.mapper.cards.LikeMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import io.grpc.Status;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.EDIT;

@RestController
@RequestMapping("/")
public class CardController {
    @GrpcClient(GRPCServiceNames.CardService)
    private CardServiceGrpc.CardServiceBlockingStub cardService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private AppearanceMapper appearanceMapper;

    @GetMapping("/card/{cardId}/view")
    public CardDTO getCardById(@PathVariable Long cardId) {
        try {
            return cardMapper.protoToDTO(cardService.getCardInfoById(IdValue.newBuilder().setId(cardId).build()));
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (Status.NOT_FOUND.equals(status.getCode().toStatus())) {
                throw new NotFoundException(status.getDescription());
            }
            throw new IncorrectDataException(status.getDescription());
        }
    }

    @GetMapping("/user/{userId}/cards")
    public List<CardDTO> getCardsByUserId(@PathVariable Long userId) {
        try {
            List<CardProto> cardProtos = cardService.getAllCardsInfoByUser(IdValue.newBuilder().setId(userId).build()).getCardsList();
            return cardProtos.stream().map(cardMapper::protoToDTO).collect(Collectors.toList());
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (Status.NOT_FOUND.equals(status.getCode().toStatus())) {
                throw new NotFoundException(status.getDescription());
            }
            throw new IncorrectDataException(status.getDescription());
        }
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/new")
    public ResponseEntity<Object> addCard(@RequestBody CardDTO cardDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        long newCardId;
        try {
            User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            EditCardProto editCardProto = EditCardProto.newBuilder()
                    .setCardProto(cardMapper.dtoToProto(cardDTO))
                    .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                    .setCurrentUserId(user.getId())
                    .build();
            newCardId = cardService.addCard(editCardProto).getId();
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (status.getDescription() == null) {
                body.put("message", status.getCode() + ": " + status.getCause().getMessage());
            } else {
                body.put("message", status.getCode() + ": " + status.getDescription());
            }
            return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
        }
        body.put("message", "Your new card id is " + newCardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/edit")
    public ResponseEntity<Object> editCard(@PathVariable Long cardId, @RequestBody CardDTO cardDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        try {
            cardDTO.setId(cardId);
            User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            EditCardProto editCardProto = EditCardProto.newBuilder()
                    .setCardProto(cardMapper.dtoToProto(cardDTO))
                    .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                    .setCurrentUserId(user.getId())
                    .build();
            cardService.editCard(editCardProto);
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (status.getDescription() == null) {
                body.put("message", status.getCode() + ": " + status.getCause().getMessage());
            } else {
                body.put("message", status.getCode() + ": " + status.getDescription());
            }
            return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
        }
        body.put("message", "Card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/delete")
    public ResponseEntity<Object> deleteCard(@PathVariable Long cardId) {
        Map<String, Object> body = new LinkedHashMap<>();
        Long userId;
        try {
            User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            DeleteCardProto deleteCardProto = DeleteCardProto.newBuilder()
                    .setCardId(cardId)
                    .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                    .setCurrentUserId(user.getId())
                    .build();
            cardService.deleteCard(deleteCardProto);
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (Status.NOT_FOUND.equals(status.getCode().toStatus())) {
                throw new NotFoundException(status.getDescription());
            }
            throw new IncorrectDataException(status.getDescription());
        }
        body.put("message", "Card " + cardId + " is deleted");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    //getFollowedCards

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/edit/appearance")
    public ResponseEntity<Object> editAppearance(@PathVariable Long cardId, @RequestBody AppearanceDTO appearanceDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        try {
            User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            EditAppearanceProto editAppearanceProto = EditAppearanceProto.newBuilder()
                    .setAppearanceProto(appearanceMapper.dtoToProto(appearanceDTO))
                    .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                    .setCurrentUserId(user.getId())
                    .setCardId(cardId)
                    .build();
            cardService.editAppearance(editAppearanceProto);
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (status.getDescription() == null) {
                body.put("message", status.getCode() + ": " + status.getCause().getMessage());
            } else {
                body.put("message", status.getCode() + ": " + status.getDescription());
            }
            return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
        }
        body.put("message", "Appearance of card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
