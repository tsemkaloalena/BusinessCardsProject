package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.DeleteGalleryPhotoProto;
import com.tsemkalo.businesscards.EditGalleryPhotoProto;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.GalleryPhotoDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.cards.GalleryPhotoMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.EDIT;

@RestController
@RequestMapping("/card")
public class GalleryPhotoCardController {
    @GrpcClient(GRPCServiceNames.CardService)
    private CardServiceGrpc.CardServiceBlockingStub cardService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private GalleryPhotoMapper galleryPhotoMapper;

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/add/photo")
    public ResponseEntity<Object> addGalleryPhoto(@PathVariable Long cardId, @RequestBody GalleryPhotoDTO galleryPhotoDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        galleryPhotoDTO.setCardId(cardId);
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditGalleryPhotoProto editGalleryPhotoProto = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoMapper.dtoToProto(galleryPhotoDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.addGalleryPhoto(editGalleryPhotoProto);
        body.put("message", "Gallery photo is added to card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/edit/photo")
    public ResponseEntity<Object> editGalleryPhoto(@PathVariable Long cardId, @RequestBody GalleryPhotoDTO galleryPhotoDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditGalleryPhotoProto editGalleryPhotoProto = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoMapper.dtoToProto(galleryPhotoDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.editGalleryPhoto(editGalleryPhotoProto);
        body.put("message", "Photo of card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/delete/photo/{galleryPhotoId}")
    public ResponseEntity<Object> deleteGalleryPhoto(@PathVariable Long cardId, @PathVariable Long galleryPhotoId) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        DeleteGalleryPhotoProto deleteGalleryPhotoProto = DeleteGalleryPhotoProto.newBuilder()
                .setGalleryPhotoId(galleryPhotoId)
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.deleteGalleryPhoto(deleteGalleryPhotoProto);
        body.put("message", "Gallery photo of card " + cardId + " is deleted");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
