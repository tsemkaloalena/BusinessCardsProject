package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.AssignSupportChatRequest;
import com.tsemkalo.businesscards.ChangeNameRequest;
import com.tsemkalo.businesscards.ChangeSendingNotificationsRequest;
import com.tsemkalo.businesscards.ChatMemberIdList;
import com.tsemkalo.businesscards.ChatProto;
import com.tsemkalo.businesscards.ChatProtoList;
import com.tsemkalo.businesscards.ChatUserProto;
import com.tsemkalo.businesscards.CloseQuestionRequest;
import com.tsemkalo.businesscards.IdMessageServiceValue;
import com.tsemkalo.businesscards.InviteMemberRequest;
import com.tsemkalo.businesscards.MessageProto;
import com.tsemkalo.businesscards.MessageProtoList;
import com.tsemkalo.businesscards.MessageServiceGrpc;
import com.tsemkalo.businesscards.SendMessageToChatRequest;
import com.tsemkalo.businesscards.SendMessageToSupportRequest;
import com.tsemkalo.businesscards.SendMessageToUserRequest;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;
import com.tsemkalo.businesscards.mappers.ChatMapper;
import com.tsemkalo.businesscards.mappers.ChatMemberMapper;
import com.tsemkalo.businesscards.mappers.MessageMapper;
import com.tsemkalo.businesscards.service.ChatService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@GrpcService
public class RequestController extends MessageServiceGrpc.MessageServiceImplBase {
    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private ChatMemberMapper chatMemberMapper;

    @Override
    public void getUserChats(IdMessageServiceValue request, StreamObserver<ChatProtoList> responseObserver) {
        List<Chat> chats = chatService.getUserChats(request.getId());
        List<ChatProto> protos = chats.stream().map(chatMapper::entityToProto).collect(Collectors.toList());
        ChatProtoList chatProtoList = ChatProtoList.newBuilder()
                .addAllChat(protos)
                .build();
        responseObserver.onNext(chatProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void getChatMessages(ChatUserProto request, StreamObserver<MessageProtoList> responseObserver) {
        List<Message> messages = chatService.getChatMessages(request.getChatId(), request.getUserId());
        List<MessageProto> protos = messages.stream().map(messageMapper::entityToProto).collect(Collectors.toList());
        MessageProtoList messageProtoList = MessageProtoList.newBuilder()
                .addAllMessage(protos)
                .build();
        responseObserver.onNext(messageProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void getChatMemberIds(ChatUserProto request, StreamObserver<ChatMemberIdList> responseObserver) {
        List<ChatMember> chatMembers = chatService.getChatMembersByChatId(request.getChatId(), request.getUserId());
        ChatMemberIdList chatMemberIdList = ChatMemberIdList.newBuilder()
                .addAllUserId(chatMembers.stream().map(ChatMember::getUserId).collect(Collectors.toList()))
                .build();
        responseObserver.onNext(chatMemberIdList);
        responseObserver.onCompleted();
    }

    @Override
    public void changeMemberName(ChangeNameRequest request, StreamObserver<Empty> responseObserver) {
        chatService.changeMemberName(request.getUserId(), request.getChatId(), request.getNewName());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void changeChatName(ChangeNameRequest request, StreamObserver<Empty> responseObserver) {
        chatService.changeChatName(request.getUserId(), request.getChatId(), request.getNewName());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void sendMessageToChat(SendMessageToChatRequest request, StreamObserver<MessageProtoList> responseObserver) {
        chatService.sendMessageToChat(request.getText(), request.getUserId(), request.getChatId());
        List<Message> messages = chatService.getChatMessages(request.getChatId(), request.getUserId());
        List<MessageProto> protos = messages.stream().map(messageMapper::entityToProto).collect(Collectors.toList());
        MessageProtoList messageProtoList = MessageProtoList.newBuilder()
                .addAllMessage(protos)
                .build();
        responseObserver.onNext(messageProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void sendMessageToUser(SendMessageToUserRequest request, StreamObserver<MessageProtoList> responseObserver) {
        Long chatId = chatService.sendMessageToUser(request.getText(), request.getSenderId(), request.getRecipientId(), request.getSenderName(), request.getRecipientName());
        List<Message> messages = chatService.getChatMessages(chatId, request.getSenderId());
        List<MessageProto> protos = messages.stream().map(messageMapper::entityToProto).collect(Collectors.toList());
        MessageProtoList messageProtoList = MessageProtoList.newBuilder()
                .addAllMessage(protos)
                .build();
        responseObserver.onNext(messageProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void inviteMemberToChat(InviteMemberRequest request, StreamObserver<Empty> responseObserver) {
        chatService.inviteMemberToChat(request.getUserId(), request.getChatId(), request.getNewMemberId(), request.getNewMemberName());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void sendToSupport(SendMessageToSupportRequest request, StreamObserver<Empty> responseObserver) {
        chatService.sendToSupport(request.getUserId(), request.getUsername(), request.getTheme(), request.getText());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUnassignedSupportChats(Empty request, StreamObserver<ChatProtoList> responseObserver) {
        List<Chat> chats = chatService.getUnassignedSupportChats();
        ChatProtoList chatProtoList = ChatProtoList.newBuilder()
                .addAllChat(chats.stream().map(chatMapper::entityToProto).collect(Collectors.toList()))
                .build();
        responseObserver.onNext(chatProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void assignSupportChat(AssignSupportChatRequest request, StreamObserver<Empty> responseObserver) {
        Long oldSupporterId = null;
        if (request.getOldSupporterId() != 0) {
            oldSupporterId = request.getOldSupporterId();
        }
        chatService.assignSupportChat(request.getSupporterId(), request.getSupporterName(), request.getChatId(), oldSupporterId);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void closeQuestion(CloseQuestionRequest request, StreamObserver<Empty> responseObserver) {
        chatService.closeQuestion(request.getUserId(), request.getChatId(), request.getIsAdmin());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getSupportChats(IdMessageServiceValue request, StreamObserver<ChatProtoList> responseObserver) {
        List<Chat> chats = chatService.getSupportChats(request.getId());
        ChatProtoList chatProtoList = ChatProtoList.newBuilder()
                .addAllChat(chats.stream().map(chatMapper::entityToProto).collect(Collectors.toList()))
                .build();
        responseObserver.onNext(chatProtoList);
        responseObserver.onCompleted();
    }

    @Override
    public void changeSendingNotifications(ChangeSendingNotificationsRequest request, StreamObserver<Empty> responseObserver) {
        chatService.changeSendingNotifications(request.getUserId(), request.getChatId(), request.getSend());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
