package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.generatedProtos.DeleteContactProto;
import com.tsemkalo.businesscards.generatedProtos.EditContactProto;
import com.tsemkalo.businesscards.constants.GRPCServiceNames;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.ContactDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.cards.ContactMapper;
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
public class ContactCardController {
    @GrpcClient(GRPCServiceNames.CardService)
    private CardServiceGrpc.CardServiceBlockingStub cardService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private ContactMapper contactMapper;

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/add/contact")
    public ResponseEntity<Object> addContact(@PathVariable Long cardId, @RequestBody ContactDTO contactDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        contactDTO.setCardId(cardId);
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditContactProto editContactProto = EditContactProto.newBuilder()
                .setContactProto(contactMapper.dtoToProto(contactDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.addContact(editContactProto);
        body.put("message", "Contact is added to card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/edit/contact")
    public ResponseEntity<Object> editContact(@PathVariable Long cardId, @RequestBody ContactDTO contactDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditContactProto editContactProto = EditContactProto.newBuilder()
                .setContactProto(contactMapper.dtoToProto(contactDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.editContact(editContactProto);
        body.put("message", "Contact of card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/delete/contact/{contactId}")
    public ResponseEntity<Object> deleteContact(@PathVariable Long cardId, @PathVariable Long contactId) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        DeleteContactProto deleteContactProto = DeleteContactProto.newBuilder()
                .setContactId(contactId)
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.deleteContact(deleteContactProto);
        body.put("message", "Contact of card " + cardId + " is deleted");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
