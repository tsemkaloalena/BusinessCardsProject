package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.AssignSupportChatRequest;
import com.tsemkalo.businesscards.ChangeNameRequest;
import com.tsemkalo.businesscards.ChangeSendingNotificationsRequest;
import com.tsemkalo.businesscards.ChatProto;
import com.tsemkalo.businesscards.ChatUserProto;
import com.tsemkalo.businesscards.CloseQuestionRequest;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.IdMessageServiceValue;
import com.tsemkalo.businesscards.InviteMemberRequest;
import com.tsemkalo.businesscards.MessageProto;
import com.tsemkalo.businesscards.MessageServiceGrpc;
import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.SendMessageToChatRequest;
import com.tsemkalo.businesscards.SendMessageToSupportRequest;
import com.tsemkalo.businesscards.SendMessageToUserRequest;
import com.tsemkalo.businesscards.UserIdProtoList;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.dto.messages.ChatDTO;
import com.tsemkalo.businesscards.dto.messages.MailNotificationDTO;
import com.tsemkalo.businesscards.dto.messages.MessageDTO;
import com.tsemkalo.businesscards.dto.messages.UserChatIdDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.messages.ChatMapper;
import com.tsemkalo.businesscards.mapper.messages.ChatMemberMapper;
import com.tsemkalo.businesscards.mapper.messages.MessageMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.CHAT;
import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.CONTROL_SUPPORT;
import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.RESOLVE_QUESTIONS;

@RestController
@EnableRabbit
@RequestMapping("")
public class MessageController {
    @GrpcClient(GRPCServiceNames.MessageService)
    private MessageServiceGrpc.MessageServiceBlockingStub messageService;

    @GrpcClient(GRPCServiceNames.UserService)
    private UserServiceGrpc.UserServiceBlockingStub userService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private ChatMemberMapper chatMemberMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SafeUserMapper safeUserMapper;

    @PreAuthorize(CHAT)
    @GetMapping("/chats")
    public List<ChatDTO> getUserChats() {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<ChatProto> protos = messageService.getUserChats(IdMessageServiceValue.newBuilder().setId(user.getId()).build()).getChatList();
        return protos.stream().map(chatMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CHAT)
    @GetMapping("/chat/{chatId}")
    public List<MessageDTO> getChatMessages(@PathVariable Long chatId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ChatUserProto chatUserProto = ChatUserProto.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .build();
        List<MessageProto> messageProtos = messageService.getChatMessages(chatUserProto).getMessageList();
        return messageProtos.stream().map(messageMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CHAT)
    @GetMapping("/chat/{chatId}/users")
    public List<SafeUserDTO> getChatMembers(@PathVariable Long chatId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ChatUserProto chatUserProto = ChatUserProto.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .build();
        List<Long> userIds = messageService.getChatUsersIds(chatUserProto).getUserIdList();
        UserIdProtoList userIdProtoList = UserIdProtoList.newBuilder()
                .addAllUserIds(userIds).build();
        List<SafeUserProto> safeUserProtos = userService.getUsersByTheirId(userIdProtoList).getUsersList();
        return safeUserProtos.stream().map(safeUserMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chatId}/member_name")
    public ResponseEntity<Object> changeNameInChat(@PathVariable Long chatId, @RequestParam String newName) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ChangeNameRequest changeNameRequest = ChangeNameRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setNewName(newName)
                .build();
        messageService.changeMemberName(changeNameRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Your name for chat " + chatId + " is changed to " + newName);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chatId}/title")
    public ResponseEntity<Object> changeChatName(@PathVariable Long chatId, @RequestParam String newName) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ChangeNameRequest changeNameRequest = ChangeNameRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setNewName(newName)
                .build();
        messageService.changeChatName(changeNameRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Your chat title " + chatId + " is changed to " + newName);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chatId}/send_message")
    public ResponseEntity<Object> sendMessageToChat(@PathVariable Long chatId, @RequestBody String text) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        SendMessageToChatRequest sendMessageToChatRequest = SendMessageToChatRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setText(text)
                .build();
        List<Long> userIdsToNotify = messageService.sendMessageToChat(sendMessageToChatRequest).getUserIdList();
        notifyUsers(userIdsToNotify, "You have new messages from " + user.getName(), text);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Your message is sent to chat " + chatId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/user/{userId}/send_message")
    public ResponseEntity<Object> sendMessageToUser(@PathVariable Long userId, @RequestBody String text) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserIdProtoList userIdProtoList = UserIdProtoList.newBuilder()
                .addUserIds(userId)
                .build();
        SafeUserProto recipient = userService.getUsersByTheirId(userIdProtoList).getUsersList().get(0);
        SendMessageToUserRequest sendMessageToUserRequest = SendMessageToUserRequest.newBuilder()
                .setText(text)
                .setSenderId(user.getId())
                .setRecipientId(userId)
                .setSenderName(user.getName())
                .setRecipientName(recipient.getName())
                .build();
        Long userIdToNotify = messageService.sendMessageToUser(sendMessageToUserRequest).getId();
        if (userIdToNotify != 0) {
            notifyUsers(new ArrayList<Long>(Collections.singleton(userIdToNotify)), "You have new message from " + user.getName(), text);
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Your message is sent to " + recipient.getName());
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chatId}/invite")
    public ResponseEntity<Object> inviteMemberToChat(@PathVariable Long chatId, @RequestParam Long userId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserIdProtoList userIdProtoList = UserIdProtoList.newBuilder()
                .addUserIds(userId)
                .build();
        SafeUserProto newMember = userService.getUsersByTheirId(userIdProtoList).getUsersList().get(0);

        InviteMemberRequest inviteMemberRequest = InviteMemberRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setNewMemberId(userId)
                .setNewMemberName(newMember.getName())
                .build();
        messageService.inviteMemberToChat(inviteMemberRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "You invited user " + newMember.getName());
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/support/new_question")
    public ResponseEntity<Object> sendToSupport(@PathVariable Long chatId, @RequestParam String theme, @RequestBody String text) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        SendMessageToSupportRequest sendMessageToSupportRequest = SendMessageToSupportRequest.newBuilder()
                .setText(text)
                .setUserId(user.getId())
                .setUsername(user.getUsername())
                .setTheme(theme)
                .build();
        messageService.sendToSupport(sendMessageToSupportRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "You sent a question to technical support");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(RESOLVE_QUESTIONS)
    @PostMapping("/support/chats/unassigned")
    public List<ChatDTO> getUnassignedSupportChats() {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<ChatProto> chatProtos = messageService.getUnassignedSupportChats(Empty.newBuilder().build()).getChatList();
        return chatProtos.stream().map(chatMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(RESOLVE_QUESTIONS)
    @PostMapping("/support/chat/{chatId}/assign")
    public ResponseEntity<Object> assignSupportChat(@PathVariable Long chatId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        AssignSupportChatRequest assignSupportChatRequest = AssignSupportChatRequest.newBuilder()
                .setSupporterId(user.getId())
                .setSupporterName(user.getName())
                .setChatId(chatId)
                .build();
        messageService.assignSupportChat(assignSupportChatRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Now you support question " + chatId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CONTROL_SUPPORT)
    @PostMapping("/admin/support/chat/{chatId}/assign")
    public ResponseEntity<Object> assignSupportChatByAdmin(@PathVariable Long chatId, @RequestParam Long supporterId, @RequestParam Long oldSupporterId) {
        UserIdProtoList userIdProtoList = UserIdProtoList.newBuilder()
                .addUserIds(supporterId)
                .build();
        SafeUserProto supporter = userService.getUsersByTheirId(userIdProtoList).getUsersList().get(0);

        AssignSupportChatRequest assignSupportChatRequest = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporter.getName())
                .setChatId(chatId)
                .setOldSupporterId(oldSupporterId)
                .build();
        messageService.assignSupportChat(assignSupportChatRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Now supporter" + supporterId + " handles question " + chatId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/support/chat/{chatId}/close")
    public ResponseEntity<Object> closeQuestion(@PathVariable Long chatId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        CloseQuestionRequest closeQuestionRequest = CloseQuestionRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setIsAdmin(false)
                .build();
        List<Long> userIdsToNotify = messageService.closeQuestion(closeQuestionRequest).getUserIdList();
        notifyUsers(userIdsToNotify, "Question " + chatId + " has been closed", "If you have some more questions, please open another question");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "You closed question " + chatId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CONTROL_SUPPORT)
    @PostMapping("/admin/support/chat/{chatId}/close")
    public ResponseEntity<Object> closeQuestionByAdmin(@PathVariable Long chatId) {
        CloseQuestionRequest closeQuestionRequest = CloseQuestionRequest.newBuilder()
                .setUserId(0)
                .setChatId(chatId)
                .setIsAdmin(true)
                .build();
        List<Long> userIdsToNotify = messageService.closeQuestion(closeQuestionRequest).getUserIdList();
        notifyUsers(userIdsToNotify, "Question " + chatId + " has been closed", "If you have some more questions, please open another question");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "You closed question " + chatId);
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/support/chats")
    public List<ChatDTO> getSupportChats() {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        IdMessageServiceValue userIdProto = IdMessageServiceValue.newBuilder()
                .setId(user.getId())
                .build();
        List<ChatProto> chatProtos = messageService.getSupportChats(userIdProto).getChatList();
        return chatProtos.stream().map(chatMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chatId}/notifications")
    public ResponseEntity<Object> changeSendingNotifications(@PathVariable Long chatId, @RequestParam Boolean send) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ChangeSendingNotificationsRequest changeSendingNotificationsRequest = ChangeSendingNotificationsRequest.newBuilder()
                .setUserId(user.getId())
                .setChatId(chatId)
                .setSend(send)
                .build();
        messageService.changeSendingNotifications(changeSendingNotificationsRequest);
        Map<String, Object> body = new LinkedHashMap<>();
        if (send) {
            body.put("message", "You turned on email notifications for chat " + chatId);
        } else {
            body.put("message", "You turned off email notifications for chat " + chatId);
        }
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chaId}/message/{messageId}/read")
    public void markMessageAsRead(@PathVariable Long chatId, @PathVariable Long messageId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserChatIdDTO dto = new UserChatIdDTO(user.getId(), messageId);
        template.convertAndSend(QueueConstants.MARK_MESSAGE_AS_READ, dto);
    }

    @PreAuthorize(CHAT)
    @PostMapping("/chat/{chaId}/messages/read")
    public void markChatMessagesAsRead(@PathVariable Long chatId) {
        User user = (User) authorizationService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserChatIdDTO dto = new UserChatIdDTO(user.getId(), chatId);
        template.convertAndSend(QueueConstants.MARK_CHAT_MESSAGES_AS_READ, dto);
    }
    //TODO dlq

    private void notifyUsers(List<Long> userIdsToNotify, String theme, String text) {
        UserIdProtoList userIdProtoList = UserIdProtoList.newBuilder()
                .addAllUserIds(userIdsToNotify).build();
        List<SafeUserProto> usersToNotify = userService.getUsersByTheirId(userIdProtoList).getUsersList();
        for (SafeUserProto userProto : usersToNotify) {
            MailNotificationDTO mailNotificationDTO = new MailNotificationDTO(userProto.getName(), userProto.getSurname(), userProto.getEmail(), theme, text);
            template.convertAndSend(QueueConstants.SEND_NOTIFICATION, mailNotificationDTO);
        }
    }
}
