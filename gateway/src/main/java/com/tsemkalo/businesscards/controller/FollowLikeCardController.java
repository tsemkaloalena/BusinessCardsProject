package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.CardServiceGrpc;
import com.tsemkalo.businesscards.FollowProto;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.IdValue;
import com.tsemkalo.businesscards.LikeProto;
import com.tsemkalo.businesscards.dto.cards.CardDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.cards.CardMapper;
import com.tsemkalo.businesscards.mapper.cards.FollowMapper;
import com.tsemkalo.businesscards.mapper.cards.LikeMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.FOLLOW_LIKE;

@RestController
@RequestMapping("/card")
public class FollowLikeCardController {
    @GrpcClient(GRPCServiceNames.CardService)
    private CardServiceGrpc.CardServiceBlockingStub cardService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private LikeMapper likeMapper;

    @PreAuthorize(FOLLOW_LIKE)
    @PostMapping("/{cardId}/follow")
    public ResponseEntity<Object> follow(@PathVariable Long cardId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        FollowProto followProto = FollowProto.newBuilder()
                .setCardId(cardId)
                .setUserId(user.getId())
                .build();
        cardService.addFollow(followProto);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "User " + user.getId() + " now follows card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(FOLLOW_LIKE)
    @PostMapping("/{cardId}/unfollow")
    public ResponseEntity<Object> unfollow(@PathVariable Long cardId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        FollowProto followProto = FollowProto.newBuilder()
                .setCardId(cardId)
                .setUserId(user.getId())
                .build();
        cardService.deleteFollow(followProto);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "User " + user.getId() + " unfollowed card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(FOLLOW_LIKE)
    @GetMapping("/followings")
    public List<CardDTO> getUserFollowings() {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<CardProto> cardProtos = cardService.getUserFollowings(IdValue.newBuilder().setId(user.getId()).build()).getCardsList();
        return cardProtos.stream().map(cardMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(FOLLOW_LIKE)
    @PostMapping("/{cardId}/like")
    public ResponseEntity<Object> like(@PathVariable Long cardId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        LikeProto likeProto = LikeProto.newBuilder()
                .setCardId(cardId)
                .setUserId(user.getId())
                .build();
        cardService.addLike(likeProto);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "User " + user.getId() + " liked the card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(FOLLOW_LIKE)
    @PostMapping("/{cardId}/unlike")
    public ResponseEntity<Object> unlike(@PathVariable Long cardId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        LikeProto likeProto = LikeProto.newBuilder()
                .setCardId(cardId)
                .setUserId(user.getId())
                .build();
        cardService.deleteLike(likeProto);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "User " + user.getId() + " unliked the card " + cardId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
