package com.tsemkalo.businesscards;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.configuration.enums.ChatType;
import com.tsemkalo.businesscards.controller.RequestController;
import com.tsemkalo.businesscards.dao.ChatDao;
import com.tsemkalo.businesscards.dao.ChatMemberDao;
import com.tsemkalo.businesscards.dao.MessageDao;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;
import com.tsemkalo.businesscards.exceptions.AccessDeniedException;
import com.tsemkalo.businesscards.exceptions.AlreadyExistsException;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.mappers.ChatMapper;
import com.tsemkalo.businesscards.mappers.ChatMemberMapper;
import com.tsemkalo.businesscards.mappers.MessageMapper;
import com.tsemkalo.businesscards.service.impl.ChatServiceImpl;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@Sql("/createMessageDB.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntegrationMessageServiceTest {
    @SpyBean
    private ChatDao chatDao;
    @SpyBean
    private ChatMemberDao chatMemberDao;
    @SpyBean
    private MessageDao messageDao;

    @Spy
    @InjectMocks
    private ChatMapper chatMapper;
    @Spy
    @InjectMocks
    private ChatMemberMapper chatMemberMapper;
    @Spy
    @InjectMocks
    private MessageMapper messageMapper;

    @Spy
    @InjectMocks
    private ChatServiceImpl chatService;

    @InjectMocks
    private RequestController requestController;

    @Test
    public void getUserChats_whenUserHasChats_thenReturnChats() throws Exception {
        Long currentUserId = 4L;
        IdMessageServiceValue request = IdMessageServiceValue.newBuilder()
                .setId(currentUserId)
                .build();

        StreamRecorder<ChatProtoList> responseObserver = StreamRecorder.create();
        requestController.getUserChats(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<ChatProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<ChatProto> chatProtos = results.get(0).getChatList();
        assertFalse(chatProtos.isEmpty());

        Map<Long, Chat> chatTable = getChatTable();
        for (ChatProto chatProto : chatProtos) {
            boolean chatContainsUser = false;
            for (ChatMember chatMember : chatTable.get(chatProto.getId()).getChatMembers()) {
                if (currentUserId.equals(chatMember.getUserId())) {
                    chatContainsUser = true;
                    break;
                }
            }
            assertTrue(chatContainsUser);
        }
    }

    @Test
    public void getUserChats_whenUserHasNoChats_thenReturnEmptyList() throws Exception {
        long currentUserId = 11L;
        IdMessageServiceValue request = IdMessageServiceValue.newBuilder()
                .setId(currentUserId)
                .build();

        StreamRecorder<ChatProtoList> responseObserver = StreamRecorder.create();
        requestController.getUserChats(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<ChatProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<ChatProto> chatProtos = results.get(0).getChatList();
        assertTrue(chatProtos.isEmpty());
    }

    @Test
    public void getChatMessages_whenChatExists_thenReturnMessages() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<MessageProtoList> responseObserver = StreamRecorder.create();
        requestController.getChatMessages(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<MessageProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<MessageProto> messageProtos = results.get(0).getMessageList();
        assertFalse(messageProtos.isEmpty());

        Chat chat = getChatTable().get(chatId);
        for (int i = 0; i < messageProtos.size(); i++) {
            assertEquals(messageProtos.get(i).getId(), chat.getMessages().get(i).getId());
        }
    }

    @Test
    public void getChatMessages_whenChatExistsAndUserIsNotMemberOfChat_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 1L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<MessageProtoList> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.getChatMessages(request, responseObserver));
    }

    @Test
    public void getChatMessages_whenChatIsEmpty_thenReturnEmptyList() throws Exception {
        long currentUserId = 10L;
        long chatId = 5L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<MessageProtoList> responseObserver = StreamRecorder.create();
        requestController.getChatMessages(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<MessageProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<MessageProto> messageProtos = results.get(0).getMessageList();
        assertTrue(messageProtos.isEmpty());
    }

    @Test
    public void getChatMessages_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 8L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<MessageProtoList> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.getChatMessages(request, responseObserver));
    }

    @Test
    public void getChatUserIds_whenChatExists_thenReturnMembers() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.getChatUsersIds(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIdList = results.get(0).getUserIdList();
        assertFalse(userIdList.isEmpty());
        Chat chat = getChatTable().get(chatId);
        for (int i = 0; i < userIdList.size(); i++) {
            assertEquals(chat.getChatMembers().get(i).getUserId(), userIdList.get(i));
        }
    }

    @Test
    public void getChatUserIds_whenChatExistsAndUserIsNotMemberOfChat_thenAccessDeniedExceptionThrown() throws Exception {
        long currentUserId = 10L;
        long chatId = 1L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.getChatUsersIds(request, responseObserver));
    }

    @Test
    public void getChatUserIds_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 8L;
        ChatUserProto request = ChatUserProto.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.getChatUsersIds(request, responseObserver));
    }

    @Test
    public void changeMemberName_whenDataIsCorrect_thenSuccess() throws Exception {
        Long currentUserId = 4L;
        Long chatId = 1L;
        String newName = "Meow";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();
        Map<Long, ChatMember> chatMemberTable = getChatMemberTable();
        int originalChatMembersAmount = chatMemberTable.size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.changeMemberName(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        chatMemberTable = getChatMemberTable();
        for (ChatMember chatMember : chatMemberTable.values()) {
            if (currentUserId.equals(chatMember.getUserId()) && chatId.equals(chatMember.getChat().getId())) {
                assertEquals(newName, chatMember.getMemberName());
                break;
            }
        }
        assertEquals(originalChatMembersAmount, chatMemberTable.size());
    }

    @Test
    public void changeMemberName_whenNewNameIsBlank_thenIncorrectDataExceptionThrown() throws Exception {
        Long currentUserId = 4L;
        Long chatId = 1L;
        String newName = "";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.changeMemberName(request, responseObserver));

        for (ChatMember chatMember : getChatMemberTable().values()) {
            if (currentUserId.equals(chatMember.getUserId()) && chatId.equals(chatMember.getChat().getId())) {
                assertNotEquals(newName, chatMember.getMemberName());
                break;
            }
        }
    }

    @Test
    public void changeMemberName_whenUserIsNotMemberOfChat_thenAccessDeniedExceptionThrown() {
        long currentUserId = 12L;
        long chatId = 1L;
        String newName = "Meow";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.changeMemberName(request, responseObserver));
    }

    @Test
    public void changeMemberName_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 12L;
        long chatId = 19L;
        String newName = "Meow";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.changeMemberName(request, responseObserver));
    }

    @Test
    public void changeChatName_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        String newName = "Meow chat";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.changeChatName(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        Chat chat = chatTable.get(chatId);
        assertEquals(newName, chat.getName());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void changeChatName_whenNewNameIsBlank_thenIncorrectDataExceptionThrown() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        String newName = "";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.changeChatName(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        Chat chat = chatTable.get(chatId);
        assertNotEquals(newName, chat.getName());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void changeChatName_whenUserIsNotMemberOfChat_thenAccessDeniedExceptionThrown() {
        long currentUserId = 12L;
        long chatId = 1L;
        String newName = "Meow chat";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.changeChatName(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        Chat chat = chatTable.get(chatId);
        assertNotEquals(newName, chat.getName());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void changeChatName_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 12L;
        long chatId = 19L;
        String newName = "Meow chat";
        ChangeNameRequest request = ChangeNameRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewName(newName)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.changeChatName(request, responseObserver));
    }

    @Test
    public void sendMessageToChat_whenMessageIsSent_thenUsersIdsForNotificationsAreReturned() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        String text = "Meoooow";
        SendMessageToChatRequest request = SendMessageToChatRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.sendMessageToChat(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIds = results.get(0).getUserIdList();

        int usersToNotifyAmount = 0;
        Chat chat = getChatTable().get(chatId);
        for (int i = 0; i < chat.getChatMembers().size(); i++) {
            if (chat.getChatMembers().get(i).getNotify()) {
                usersToNotifyAmount++;
                assertEquals(userIds.get(i), chat.getChatMembers().get(i).getUserId());
            }
        }
        assertEquals(usersToNotifyAmount, userIds.size());
        assertEquals(originalMessagesAmount + 1, getMessageTable().size());
    }

    @Test
    public void sendMessageToChat_whenUserIsNotMemberOfChat_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 1L;
        String text = "Meoooow";
        SendMessageToChatRequest request = SendMessageToChatRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.sendMessageToChat(request, responseObserver));
        assertEquals(originalMessagesAmount, getMessageTable().size());
    }

    @Test
    public void sendMessageToChat_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 8L;
        String text = "Meoooow";
        SendMessageToChatRequest request = SendMessageToChatRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.sendMessageToChat(request, responseObserver));
        assertEquals(originalMessagesAmount, getMessageTable().size());
    }

    @Test
    public void sendMessageToUser_whenNoMessagesWereBetweenUsers_thenCreatePrivateChat() throws Exception {
        Long currentUserId = 4L;
        String text = "Meoooow";
        String senderName = "Oleg";
        Long recipientId = 10L;
        String recipientName = "Vasiliy";
        SendMessageToUserRequest request = SendMessageToUserRequest.newBuilder()
                .setSenderId(currentUserId)
                .setSenderName(senderName)
                .setRecipientId(recipientId)
                .setRecipientName(recipientName)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        requestController.sendMessageToUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdMessageServiceValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        Long userIdToNotify = results.get(0).getId();
        assertEquals(recipientId, userIdToNotify);
        assertEquals(originalMessagesAmount + 1, getMessageTable().size());
        assertEquals(originalChatMembersAmount + 2, getChatMemberTable().size());
        assertEquals(originalChatsAmount + 1, getChatTable().size());
        Chat privateChat = null;
        for (Chat chat : getChatTable().values()) {
            if (ChatType.PRIVATE.equals(chat.getChatType())) {
                if (chat.getChatMembers().size() == 2) {
                    if (currentUserId.equals(chat.getChatMembers().get(0).getUserId()) && recipientId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                    if (recipientId.equals(chat.getChatMembers().get(0).getUserId()) && currentUserId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                }
            }
        }
        assertNotNull(privateChat);
        assertEquals(ChatType.PRIVATE, privateChat.getChatType());
        assertEquals(2, privateChat.getChatMembers().size());
    }

    @Test
    public void sendMessageToUser_whenPrivatChatBetweenUsersExistsAndRecipientNotifyIsTrue_thenSendNotify() throws Exception {
        Long currentUserId = 4L;
        String text = "Meoooow";
        String senderName = "Tomas";
        Long recipientId = 5L;
        String recipientName = "Petos";
        SendMessageToUserRequest request = SendMessageToUserRequest.newBuilder()
                .setSenderId(currentUserId)
                .setSenderName(senderName)
                .setRecipientId(recipientId)
                .setRecipientName(recipientName)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        requestController.sendMessageToUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdMessageServiceValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        Long userIdToNotify = results.get(0).getId();
        assertEquals(recipientId, userIdToNotify);
        assertEquals(originalMessagesAmount + 1, getMessageTable().size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
        Chat privateChat = null;
        for (Chat chat : getChatTable().values()) {
            if (ChatType.PRIVATE.equals(chat.getChatType())) {
                if (chat.getChatMembers().size() == 2) {
                    if (currentUserId.equals(chat.getChatMembers().get(0).getUserId()) && recipientId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                    if (recipientId.equals(chat.getChatMembers().get(0).getUserId()) && currentUserId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                }
            }
        }
        assertNotNull(privateChat);
        assertEquals(ChatType.PRIVATE, privateChat.getChatType());
        assertEquals(2, privateChat.getChatMembers().size());
    }

    @Test
    public void sendMessageToUser_whenPrivatChatBetweenUsersExistsAndRecipientNotifyIsFalse_thenDoNotSendNotify() throws Exception {
        Long currentUserId = 5L;
        String text = "Meoooow";
        String senderName = "Petos";
        Long recipientId = 4L;
        String recipientName = "Tomas";
        SendMessageToUserRequest request = SendMessageToUserRequest.newBuilder()
                .setSenderId(currentUserId)
                .setSenderName(senderName)
                .setRecipientId(recipientId)
                .setRecipientName(recipientName)
                .setText(text)
                .build();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        requestController.sendMessageToUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdMessageServiceValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        Long userIdToNotify = results.get(0).getId();
        assertEquals(0L, userIdToNotify);
        assertEquals(originalMessagesAmount + 1, getMessageTable().size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
        Chat privateChat = null;
        for (Chat chat : getChatTable().values()) {
            if (ChatType.PRIVATE.equals(chat.getChatType())) {
                if (chat.getChatMembers().size() == 2) {
                    if (currentUserId.equals(chat.getChatMembers().get(0).getUserId()) && recipientId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                    if (recipientId.equals(chat.getChatMembers().get(0).getUserId()) && currentUserId.equals(chat.getChatMembers().get(1).getUserId())) {
                        privateChat = chat;
                        break;
                    }
                }
            }
        }
        assertNotNull(privateChat);
        assertEquals(ChatType.PRIVATE, privateChat.getChatType());
        assertEquals(2, privateChat.getChatMembers().size());
    }

    @Test
    public void inviteMemberToChat_whenChatExists_thenAddMember() throws Exception {
        long currentUserId = 4L;
        long chatId = 1L;
        long newMemberId = 10L;
        String newMemberName = "Valera";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = getChatTable().get(chatId).getChatMembers().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        requestController.inviteMemberToChat(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdMessageServiceValue> results = responseObserver.getValues();
        assertEquals(1, results.size());

        assertEquals(ChatType.GROUP, getChatTable().get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount + 1, getChatMemberTable().size());
        assertEquals(originalMembersAmount + 1, getChatTable().get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, getChatTable().size());
    }

    @Test
    public void inviteMemberToChat_whenUserAlreadyInChat_thenAlreadyExistsExceptionThrown() {
        long currentUserId = 4L;
        long chatId = 1L;
        long newMemberId = 5L;
        String newMemberName = "Petos";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        Map<Long, Chat> chatTable = getChatTable();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = chatTable.get(chatId).getChatMembers().size();
        int originalChatsAmount = chatTable.size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        assertThrows(AlreadyExistsException.class, () -> requestController.inviteMemberToChat(request, responseObserver));
        chatTable = getChatTable();
        assertEquals(ChatType.GROUP, chatTable.get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount, getChatMemberTable().size());
        assertEquals(originalMembersAmount, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void inviteMemberToChat_whenUserAlreadyInPrivateChat_thenAlreadyExistsExceptionThrown() {
        long currentUserId = 4L;
        long chatId = 2L;
        long newMemberId = 5L;
        String newMemberName = "Petos";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        Map<Long, Chat> chatTable = getChatTable();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = chatTable.get(chatId).getChatMembers().size();
        int originalChatsAmount = chatTable.size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        assertThrows(AlreadyExistsException.class, () -> requestController.inviteMemberToChat(request, responseObserver));
        chatTable = getChatTable();
        assertEquals(ChatType.PRIVATE, chatTable.get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount, getChatMemberTable().size());
        assertEquals(originalMembersAmount, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void inviteMemberToChat_whenChatIsForTechSupport_thenAccessDeniedExceptionThrown() {
        long currentUserId = 5L;
        long chatId = 3L;
        long newMemberId = 10L;
        String newMemberName = "Nadya";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        Map<Long, Chat> chatTable = getChatTable();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = chatTable.get(chatId).getChatMembers().size();
        int originalChatsAmount = chatTable.size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.inviteMemberToChat(request, responseObserver));

        chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_QUESTION, chatTable.get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount, getChatMemberTable().size());
        assertEquals(originalMembersAmount, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void inviteMemberToChat_whenCurrentUserIsNotChatMember_thenAccessDeniedExceptionThrown() {
        long currentUserId = 12L;
        long chatId = 1L;
        long newMemberId = 10L;
        String newMemberName = "Nadya";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        Map<Long, Chat> chatTable = getChatTable();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = chatTable.get(chatId).getChatMembers().size();
        int originalChatsAmount = chatTable.size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.inviteMemberToChat(request, responseObserver));

        chatTable = getChatTable();
        assertEquals(ChatType.GROUP, chatTable.get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount, getChatMemberTable().size());
        assertEquals(originalMembersAmount, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void inviteMemberToChat_whenChatIsPrivate_thenChangeTypeToGroupChat() throws Exception {
        long currentUserId = 4L;
        long chatId = 2L;
        long newMemberId = 10L;
        String newMemberName = "Valera";
        InviteMemberRequest request = InviteMemberRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setNewMemberId(newMemberId)
                .setNewMemberName(newMemberName)
                .build();
        Map<Long, Chat> chatTable = getChatTable();
        int originalCommonMembersAmount = getChatMemberTable().size();
        int originalMembersAmount = chatTable.get(chatId).getChatMembers().size();
        int originalChatsAmount = chatTable.size();

        StreamRecorder<IdMessageServiceValue> responseObserver = StreamRecorder.create();
        requestController.inviteMemberToChat(request, responseObserver);

        chatTable = getChatTable();
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdMessageServiceValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        assertEquals(ChatType.GROUP, chatTable.get(chatId).getChatType());
        assertEquals(originalCommonMembersAmount + 1, getChatMemberTable().size());
        assertEquals(originalMembersAmount + 1, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
    }

    @Test
    public void sendToSupport_whenDataIsCorrect_thenAddMessageAndCreateChat() throws Exception {
        long currentUserId = 4L;
        String username = "qustionman";
        String theme = "I have a question";
        String text = "How is your chair?";
        long lastChatId = 0L;
        for (long id : getChatTable().keySet()) {
            if (lastChatId < id) {
                lastChatId = id;
            }
        }
        SendMessageToSupportRequest request = SendMessageToSupportRequest.newBuilder()
                .setUserId(currentUserId)
                .setUsername(username)
                .setTheme(theme)
                .setText(text)
                .build();
        int originalMembersAmount = getChatMemberTable().size();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.sendToSupport(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(originalMembersAmount + 1, getChatMemberTable().size());
        assertEquals(originalMessagesAmount + 1, getMessageTable().size());
        assertEquals(originalChatsAmount + 1, chatTable.size());
        assertNotNull(chatTable.get(lastChatId + 1));
        assertEquals(ChatType.SUPPORT_UNASSIGNED, chatTable.get(lastChatId + 1).getChatType());
    }

    @Test
    public void sendToSupport_whenThemeIsNotSpecified_thenIncorrectDataExceptionThrown() {
        long currentUserId = 4L;
        String username = "qustionman";
        String text = "How is your chair?";
        SendMessageToSupportRequest request = SendMessageToSupportRequest.newBuilder()
                .setUserId(currentUserId)
                .setUsername(username)
                .setText(text)
                .build();
        int originalMembersAmount = getChatMemberTable().size();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.sendToSupport(request, responseObserver));

        assertEquals(originalMembersAmount, getChatMemberTable().size());
        assertEquals(originalMessagesAmount, getMessageTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
    }

    @Test
    public void sendToSupport_whenTextIsNotSpecified_thenIncorrectDataExceptionThrown() {
        long currentUserId = 4L;
        String username = "qustionman";
        String theme = "I have a question";
        SendMessageToSupportRequest request = SendMessageToSupportRequest.newBuilder()
                .setUserId(currentUserId)
                .setUsername(username)
                .setTheme(theme)
                .build();
        int originalMembersAmount = getChatMemberTable().size();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.sendToSupport(request, responseObserver));

        assertEquals(originalMembersAmount, getChatMemberTable().size());
        assertEquals(originalMessagesAmount, getMessageTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
    }

    @Test
    public void sendToSupport_whenUsernameIsNotSpecified_thenAccessDeniedExceptionThrown() {
        long currentUserId = 4L;
        String theme = "I have a question";
        String text = "How is your chair?";
        SendMessageToSupportRequest request = SendMessageToSupportRequest.newBuilder()
                .setUserId(currentUserId)
                .setTheme(theme)
                .setText(text)
                .build();
        int originalMembersAmount = getChatMemberTable().size();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.sendToSupport(request, responseObserver));

        assertEquals(originalMembersAmount, getChatMemberTable().size());
        assertEquals(originalMessagesAmount, getMessageTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
    }

    @Test
    public void sendToSupport_whenUserIdIsNotSpecified_thenAccessDeniedExceptionThrown() {
        String username = "qustionman";
        String theme = "I have a question";
        String text = "How is your chair?";
        SendMessageToSupportRequest request = SendMessageToSupportRequest.newBuilder()
                .setUsername(username)
                .setTheme(theme)
                .setText(text)
                .build();
        int originalMembersAmount = getChatMemberTable().size();
        int originalMessagesAmount = getMessageTable().size();
        int originalChatsAmount = getChatTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.sendToSupport(request, responseObserver));

        assertEquals(originalMembersAmount, getChatMemberTable().size());
        assertEquals(originalMessagesAmount, getMessageTable().size());
        assertEquals(originalChatsAmount, getChatTable().size());
    }

    @Test
    public void getUnassignedSupportChats() throws Exception {
        Empty request = Empty.newBuilder().build();
        StreamRecorder<ChatProtoList> responseObserver = StreamRecorder.create();

        requestController.getUnassignedSupportChats(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<ChatProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<ChatProto> chatProtos = results.get(0).getChatList();
        assertFalse(chatProtos.isEmpty());
        Map<Long, Chat> chatTable = getChatTable();
        for (ChatProto chatProto : chatProtos) {
            assertEquals(ChatTypeProto.SUPPORT_UNASSIGNED, chatProto.getChatType());
            assertEquals(1, chatTable.get(chatProto.getId()).getChatMembers().size());
        }
    }

    @Test
    public void assignSupportChat_whenChatWasUnassigned_thenChangeType() throws Exception {
        long supporterId = 2L;
        String supporterName = "Helper";
        long chatId = 4L;
        AssignSupportChatRequest request = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporterName)
                .setChatId(chatId)
                .build();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        int originalChatsAmount = getChatTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();

        requestController.assignSupportChat(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_QUESTION, chatTable.get(chatId).getChatType());
        assertEquals(2, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
        assertEquals(originalChatMembersAmount + 1, getChatMemberTable().size());
    }

    @Test
    public void assignSupportChat_whenChatWasAssigned_thenChangeSupporterId() throws Exception {
        long supporterId = 3L;
        long oldSupporterId = 2L;
        String supporterName = "Helper";
        long chatId = 3L;
        AssignSupportChatRequest request = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporterName)
                .setChatId(chatId)
                .setOldSupporterId(oldSupporterId)
                .build();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        int originalChatsAmount = getChatTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();

        requestController.assignSupportChat(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_QUESTION, chatTable.get(chatId).getChatType());
        assertEquals(2, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        for (ChatMember chatMember : chatTable.get(chatId).getChatMembers()) {
            assertNotEquals(oldSupporterId, chatMember.getUserId());
        }
    }

    @Test
    public void assignSupportChat_whenChatWasAssignedAndOldSupporterIdIsNotCorrect_thenNotFoundExceptionThrown() {
        long supporterId = 3L;
        long oldSupporterId = 6L;
        String supporterName = "Helper";
        long chatId = 3L;
        AssignSupportChatRequest request = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporterName)
                .setChatId(chatId)
                .setOldSupporterId(oldSupporterId)
                .build();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        int originalChatsAmount = getChatTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();

        assertThrows(NotFoundException.class, () -> requestController.assignSupportChat(request, responseObserver));
        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_QUESTION, chatTable.get(chatId).getChatType());
        assertEquals(2, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        for (ChatMember chatMember : chatTable.get(chatId).getChatMembers()) {
            assertNotEquals(supporterId, chatMember.getUserId());
        }
    }

    @Test
    public void assignSupportChat_whenChatWasClosedAndOldSupporterIdIsSet_thenAccessDeniedExceptionThrown() {
        long supporterId = 3L;
        long oldSupporterId = 2L;
        String supporterName = "Helper";
        long chatId = 6L;
        AssignSupportChatRequest request = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporterName)
                .setChatId(chatId)
                .setOldSupporterId(oldSupporterId)
                .build();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        int originalChatsAmount = getChatTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();

        assertThrows(AccessDeniedException.class, () -> requestController.assignSupportChat(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
        assertEquals(2, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        for (ChatMember chatMember : chatTable.get(chatId).getChatMembers()) {
            assertNotEquals(supporterId, chatMember.getUserId());
        }
    }

    @Test
    public void assignSupportChat_whenChatWasClosed_thenAccessDeniedExceptionThrown() {
        long supporterId = 3L;
        String supporterName = "Helper";
        long chatId = 6L;
        AssignSupportChatRequest request = AssignSupportChatRequest.newBuilder()
                .setSupporterId(supporterId)
                .setSupporterName(supporterName)
                .setChatId(chatId)
                .build();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        int originalChatsAmount = getChatTable().size();
        int originalChatMembersAmount = getChatMemberTable().size();

        assertThrows(AccessDeniedException.class, () -> requestController.assignSupportChat(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
        assertEquals(2, chatTable.get(chatId).getChatMembers().size());
        assertEquals(originalChatsAmount, chatTable.size());
        assertEquals(originalChatMembersAmount, getChatMemberTable().size());
        for (ChatMember chatMember : chatTable.get(chatId).getChatMembers()) {
            assertNotEquals(supporterId, chatMember.getUserId());
        }
    }

    @Test
    public void closeQuestion_whenAdminClosesAndChatIsUnassigned_thenChangeCHatTypeAndSendNotifications() throws Exception {
        long currentUserId = 1L;
        long chatId = 3L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(true)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.closeQuestion(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIds = results.get(0).getUserIdList();
        assertEquals(2, userIds.size());
        assertEquals(userIds.get(0), chatTable.get(chatId).getChatMembers().get(0).getUserId());
        assertEquals(userIds.get(1), chatTable.get(chatId).getChatMembers().get(1).getUserId());
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenAdminClosesAndChatIsAssigned_thenChangeCHatTypeAndSendNotifications() throws Exception {
        long currentUserId = 1L;
        long chatId = 4L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(true)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.closeQuestion(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIds = results.get(0).getUserIdList();
        assertEquals(1, userIds.size());
        assertEquals(userIds.get(0), chatTable.get(chatId).getChatMembers().get(0).getUserId());
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenSupporterCloses_thenChangeCHatTypeAndSendNotifications() throws Exception {
        long currentUserId = 2L;
        long chatId = 3L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.closeQuestion(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIds = results.get(0).getUserIdList();
        assertEquals(2, userIds.size());
        assertEquals(userIds.get(0), chatTable.get(chatId).getChatMembers().get(0).getUserId());
        assertEquals(userIds.get(1), chatTable.get(chatId).getChatMembers().get(1).getUserId());
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenUserCloses_thenChangeCHatTypeAndSendNotifications() throws Exception {
        long currentUserId = 5L;
        long chatId = 3L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        requestController.closeQuestion(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        List<ChatUserIdList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<Long> userIds = results.get(0).getUserIdList();
        assertEquals(2, userIds.size());
        assertEquals(userIds.get(0), chatTable.get(chatId).getChatMembers().get(0).getUserId());
        assertEquals(userIds.get(1), chatTable.get(chatId).getChatMembers().get(1).getUserId());
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenUnknownUserCloses_thenAccessDeniedExceptionThrown() {
        long currentUserId = 7L;
        long chatId = 3L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.closeQuestion(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_QUESTION, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 7L;
        long chatId = 20L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.closeQuestion(request, responseObserver));
    }

    @Test
    public void closeQuestion_whenChatIsNotForTechnicalSupport_thenIncorrectDataExceptionThrown() {
        long currentUserId = 10L;
        long chatId = 5L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.closeQuestion(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.GROUP, chatTable.get(chatId).getChatType());
    }

    @Test
    public void closeQuestion_whenChatIsAlreadyClosed_thenIncorrectDataExceptionThrown() {
        long currentUserId = 2L;
        long chatId = 6L;
        CloseQuestionRequest request = CloseQuestionRequest.newBuilder()
                .setChatId(chatId)
                .setUserId(currentUserId)
                .setIsAdmin(false)
                .build();

        StreamRecorder<ChatUserIdList> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.closeQuestion(request, responseObserver));

        Map<Long, Chat> chatTable = getChatTable();
        assertEquals(ChatType.SUPPORT_CLOSED, chatTable.get(chatId).getChatType());
    }

    @Test
    public void getSupportChats() throws Exception {
        Long currentUserId = 5L;
        IdMessageServiceValue request = IdMessageServiceValue.newBuilder()
                .setId(currentUserId)
                .build();
        StreamRecorder<ChatProtoList> responseObserver = StreamRecorder.create();
        requestController.getSupportChats(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, ChatMember> chatMemberTable = getChatMemberTable();
        List<ChatProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<ChatProto> chatProtos = results.get(0).getChatList();
        List<Long> correctChatIds = new ArrayList<>();
        for (ChatMember chatMember : chatMemberTable.values()) {
            if (currentUserId.equals(chatMember.getUserId())) {
                if (ChatType.SUPPORT_QUESTION.equals(chatMember.getChat().getChatType()) || ChatType.SUPPORT_UNASSIGNED.equals(chatMember.getChat().getChatType())) {
                    correctChatIds.add(chatMember.getChat().getId());
                }
            }
        }
        assertEquals(correctChatIds.size(), chatProtos.size());
        for (ChatProto chatProto : chatProtos) {
            assertTrue(correctChatIds.contains(chatProto.getId()));
        }
    }

    @Test
    public void changeSendingNotifications_whenAllDataIsCorrect_thenChangeSendingNotification() throws Exception {
        Long currentUserId = 8L;
        Long chatId = 5L;
        ChangeSendingNotificationsRequest request = ChangeSendingNotificationsRequest.newBuilder()
                .setUserId(currentUserId)
                .setChatId(chatId)
                .setSend(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.changeSendingNotifications(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        Map<Long, Chat> chatTable = getChatTable();
        for (ChatMember chatMember : chatTable.get(chatId).getChatMembers()) {
            if (currentUserId.equals(chatMember.getUserId())) {
                assertFalse(chatMember.getNotify());
            } else {
                assertTrue(chatMember.getNotify());
            }
        }
    }

    @Test
    public void changeSendingNotifications_whenChatDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 8L;
        long chatId = 20L;
        ChangeSendingNotificationsRequest request = ChangeSendingNotificationsRequest.newBuilder()
                .setUserId(currentUserId)
                .setChatId(chatId)
                .setSend(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.changeSendingNotifications(request, responseObserver));
    }

    @Test
    public void changeSendingNotifications_whenUserIsNotMemberOfChat_thenIncorrectDataExceptionThrown() {
        long currentUserId = 4L;
        long chatId = 5L;
        ChangeSendingNotificationsRequest request = ChangeSendingNotificationsRequest.newBuilder()
                .setUserId(currentUserId)
                .setChatId(chatId)
                .setSend(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.changeSendingNotifications(request, responseObserver));
    }

    private Map<Long, Chat> getChatTable() {
        Map<Long, Chat> chatTable = new HashMap<>();
        for (Chat chat : chatDao.findAll()) {
            chatTable.put(chat.getId(), chat);
        }
        return chatTable;
    }

    private Map<Long, ChatMember> getChatMemberTable() {
        Map<Long, ChatMember> chatMemberTable = new HashMap<>();
        for (ChatMember chatMember : chatMemberDao.findAll()) {
            chatMemberTable.put(chatMember.getId(), chatMember);
        }
        return chatMemberTable;
    }

    private Map<Long, Message> getMessageTable() {
        Map<Long, Message> messageTable = new HashMap<>();
        for (Message message : messageDao.findAll()) {
            messageTable.put(message.getId(), message);
        }
        return messageTable;
    }
}
