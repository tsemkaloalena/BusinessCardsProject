package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.DeleteAddressProto;
import com.tsemkalo.businesscards.EditAddressProto;
import com.tsemkalo.businesscards.configuration.constants.GRPCServiceNames;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.AddressDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.cards.AddressMapper;
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
public class AddressCardController {
    @GrpcClient(GRPCServiceNames.CardService)
    private CardServiceGrpc.CardServiceBlockingStub cardService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AddressMapper addressMapper;

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/add/address")
    public ResponseEntity<Object> addAddress(@PathVariable Long cardId, @RequestBody AddressDTO addressDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        addressDTO.setCardId(cardId);
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditAddressProto editAddressProto = EditAddressProto.newBuilder()
                .setAddressProto(addressMapper.dtoToProto(addressDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.addAddress(editAddressProto);
        body.put("message", "Address is added to card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/edit/address")
    public ResponseEntity<Object> editAddress(@PathVariable Long cardId, @RequestBody AddressDTO addressDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        EditAddressProto editAddressProto = EditAddressProto.newBuilder()
                .setAddressProto(addressMapper.dtoToProto(addressDTO))
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.editAddress(editAddressProto);
        body.put("message", "Address of card " + cardId + " is edited");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(EDIT)
    @PostMapping("/{cardId}/delete/address/{addressId}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Long cardId, @PathVariable Long addressId) {
        Map<String, Object> body = new LinkedHashMap<>();
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        DeleteAddressProto deleteAddressProto = DeleteAddressProto.newBuilder()
                .setAddressId(addressId)
                .setAdmin(RoleType.ADMIN.equals(user.getRole().getName()))
                .setCurrentUserId(user.getId())
                .setCardId(cardId)
                .build();
        cardService.deleteAddress(deleteAddressProto);
        body.put("message", "Address of card " + cardId + " is deleted");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
