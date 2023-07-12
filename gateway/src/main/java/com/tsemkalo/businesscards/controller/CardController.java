package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.DeleteCardProto;
import com.tsemkalo.businesscards.EditAppearanceProto;
import com.tsemkalo.businesscards.EditCardProto;
import com.tsemkalo.businesscards.configuration.constants.GRPCServiceNames;
import com.tsemkalo.businesscards.IdValue;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.AppearanceDTO;
import com.tsemkalo.businesscards.dto.cards.CardDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.cards.AppearanceMapper;
import com.tsemkalo.businesscards.mapper.cards.CardMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private AppearanceMapper appearanceMapper;

    @GetMapping("/card/{cardId}/view")
    public CardDTO getCardById(@PathVariable Long cardId) {
        return cardMapper.protoToDTO(cardService.getCardInfoById(IdValue.newBuilder().setId(cardId).build()));
    }

    @GetMapping("/user/{userId}/cards")
    public List<CardDTO> getCardsByUserId(@PathVariable Long userId) {
        List<CardProto> cardProtos = cardService.getAllCardsInfoByUser(IdValue.newBuilder().setId(userId).build()).getCardsList();
        return cardProtos.stream().map(cardMapper::protoToDTO).collect(Collectors.toList());
    }

    @GetMapping("/cards")
    public List<CardDTO> getCurrentUserCards() {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<CardProto> cardProtos = cardService.getAllCardsInfoByUser(IdValue.newBuilder().setId(user.getId()).build()).getCardsList();
        return cardProtos.stream().map(cardMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/new")
    public ResponseEntity<Object> addCard(@RequestBody CardDTO cardDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        long newCardId;
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditCardProto editCardProto = EditCardProto.newBuilder()
                .setCardProto(cardMapper.dtoToProto(cardDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .build();
        newCardId = cardService.addCard(editCardProto).getId();
        body.put("message", "Your new card id is " + newCardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/edit")
    public ResponseEntity<Object> editCard(@PathVariable Long cardId, @RequestBody CardDTO cardDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        cardDTO.setId(cardId);
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditCardProto editCardProto = EditCardProto.newBuilder()
                .setCardProto(cardMapper.dtoToProto(cardDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .build();
        cardService.editCard(editCardProto);
        body.put("message", "Card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/delete")
    public ResponseEntity<Object> deleteCard(@PathVariable Long cardId) {
        Map<String, Object> body = new LinkedHashMap<>();
        Long userId;
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        DeleteCardProto deleteCardProto = DeleteCardProto.newBuilder()
                .setCardId(cardId)
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .build();
        cardService.deleteCard(deleteCardProto);
        body.put("message", "Card " + cardId + " is deleted");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/card/{cardId}/edit/appearance")
    public ResponseEntity<Object> editAppearance(@PathVariable Long cardId, @RequestBody AppearanceDTO appearanceDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditAppearanceProto editAppearanceProto = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceMapper.dtoToProto(appearanceDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.editAppearance(editAppearanceProto);
        body.put("message", "Appearance of card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
