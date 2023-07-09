package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.configuration.enums.ChatType;
import com.tsemkalo.businesscards.dao.ChatDao;
import com.tsemkalo.businesscards.dao.ChatMemberDao;
import com.tsemkalo.businesscards.dao.MessageDao;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.mappers.ChatMapper;
import com.tsemkalo.businesscards.mappers.ChatMemberMapper;
import com.tsemkalo.businesscards.mappers.MessageMapper;
import com.tsemkalo.businesscards.service.impl.ChatServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@Setter
@Getter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public abstract class AbstractTest {
    @Mock
    private ChatDao chatDao;
    @Mock
    private ChatMemberDao chatMemberDao;
    @Mock
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
    private ChatServiceImpl chatService;

    private Map<Long, Chat> chatTable = new HashMap<>();
    private Map<Long, ChatMember> chatMemberTable = new HashMap<>();
    private Map<Long, Message> messageTable = new HashMap<>();

    private CommonMethodsSetUpper<Chat> chatCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<ChatMember> chatMemberCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Message> messageCommonMethodsSetUpper = new CommonMethodsSetUpper<>();

    @BeforeEach
    public void fillDB() {
        chatTable = new HashMap<>();
        chatMemberTable = new HashMap<>();
        messageTable = new HashMap<>();
        fillChatTable();
        fillChatMemberTable();
        fillMessageTable();
    }

    @BeforeEach
    public void setup() {
        chatDaoSetup();
        chatMemberDaoSetup();
        messageDaoSetup();
    }

    @BeforeEach
    public void setupServices() {
        try {
            Field chatDaoField = ChatServiceImpl.class.getDeclaredField("chatDao");
            chatDaoField.setAccessible(true);
            chatDaoField.set(chatService, chatDao);
            chatDaoField.setAccessible(false);

            Field chatMemberDaoField = ChatServiceImpl.class.getDeclaredField("chatMemberDao");
            chatMemberDaoField.setAccessible(true);
            chatMemberDaoField.set(chatService, chatMemberDao);
            chatMemberDaoField.setAccessible(false);

            Field messageDaoField = ChatServiceImpl.class.getDeclaredField("messageDao");
            messageDaoField.setAccessible(true);
            messageDaoField.set(chatService, messageDao);
            messageDaoField.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void fillChatTable() {
        addChat(1L, "chat1", ChatType.GROUP);
        addChat(2L, "chat2", ChatType.PRIVATE);
        addChat(3L, "help1", ChatType.SUPPORT_QUESTION);
        addChat(4L, "help2", ChatType.SUPPORT_UNASSIGNED);
        addChat(5L, "chat3", ChatType.GROUP);
        addChat(6L, "help3", ChatType.SUPPORT_CLOSED);
        addChat(7L, "help4", ChatType.SUPPORT_UNASSIGNED);
    }

    public void addChat(Long id, String name, ChatType chatType) {
        Chat chat = new Chat();
        chat.setId(id);
        chat.setName(name);
        chat.setChatType(chatType);
        chat.setMessages(new ArrayList<>());
        chat.setChatMembers(new ArrayList<>());
        chatTable.put(id, chat);
    }

    private void fillChatMemberTable() {
        addChatMember(1L, 4L, "m1", getChatTable().get(1L), true);
        addChatMember(2L, 5L, "m2", getChatTable().get(1L), true);
        addChatMember(3L, 6L, "m3", getChatTable().get(1L), false);
        addChatMember(4L, 4L, "Tomas", getChatTable().get(2L), false);
        addChatMember(5L, 5L, "Petos", getChatTable().get(2L), true);
        addChatMember(6L, 5L, "m6", getChatTable().get(3L), true);
        addChatMember(7L, 2L, "m7", getChatTable().get(3L), true);
        addChatMember(8L, 7L, "m8", getChatTable().get(4L), true);
        addChatMember(9L, 8L, "m10", getChatTable().get(5L), true);
        addChatMember(10L, 9L, "m11", getChatTable().get(5L), true);
        addChatMember(11L, 10L, "m12", getChatTable().get(5L), true);
        addChatMember(12L, 10L, "m13", getChatTable().get(6L), true);
        addChatMember(13L, 2L, "m14", getChatTable().get(6L), true);
        addChatMember(14L, 5L, "m14", getChatTable().get(7L), true);
    }

    public void addChatMember(Long id, Long userId, String memberName, Chat chat, Boolean notify) {
        ChatMember chatMember = new ChatMember(userId, memberName, chat, notify);
        chatMember.setId(id);
        chat.getChatMembers().add(chatMember);
        chatMemberTable.put(id, chatMember);
    }

    private void fillMessageTable() {
        addMessage(1L, getChatMemberTable().get(1L), getChatTable().get(1L), LocalDateTime.of(2023, 7, 4, 8, 41, 20), "text1", true);
        addMessage(2L, getChatMemberTable().get(1L), getChatTable().get(1L), LocalDateTime.of(2023, 7, 4, 8, 42, 20), "text2", true);
        addMessage(3L, getChatMemberTable().get(2L), getChatTable().get(1L), LocalDateTime.of(2023, 7, 4, 8, 43, 20), "text3", true);
        addMessage(4L, getChatMemberTable().get(3L), getChatTable().get(1L), LocalDateTime.of(2023, 7, 4, 8, 44, 20), "text4", true);
        addMessage(5L, getChatMemberTable().get(4L), getChatTable().get(2L), LocalDateTime.of(2023, 7, 4, 8, 45, 20), "text5", false);
        addMessage(6L, getChatMemberTable().get(6L), getChatTable().get(3L), LocalDateTime.of(2023, 7, 4, 8, 45, 20), "text6", false);
        addMessage(7L, getChatMemberTable().get(7L), getChatTable().get(3L), LocalDateTime.of(2023, 7, 4, 8, 45, 20), "text7", false);
    }

    public void addMessage(Long id, ChatMember chatMember, Chat chat, LocalDateTime sendingTime, String text, Boolean read) {
        Message message = new Message(chatMember, chat, sendingTime, text, read);
        message.setId(id);
        chat.getMessages().add(message);
        messageTable.put(id, message);
    }

    private void chatDaoSetup() {
        chatSaveSetup();
        chatCommonMethodsSetUpper.findAllSetup(chatTable, chatDao);
        chatCommonMethodsSetUpper.findByIdSetup(chatTable, chatDao);
        chatCommonMethodsSetUpper.deleteSetup(chatTable, chatDao, Chat.class);
        chatCommonMethodsSetUpper.deleteByIdSetup(chatTable, chatDao);
        chatCommonMethodsSetUpper.existSetup(chatTable, chatDao);
        lenient().doAnswer(invocationOnMock -> {
            Long firstUserId = invocationOnMock.getArgument(0);
            Long secondUserId = invocationOnMock.getArgument(1);
            for (Chat chat : getChatTable().values()) {
                if (ChatType.PRIVATE.equals(chat.getChatType())) {
                    if (chat.getChatMembers().size() == 2) {
                        if (firstUserId.equals(chat.getChatMembers().get(0).getUserId()) && secondUserId.equals(chat.getChatMembers().get(1).getUserId())) {
                            return chat;
                        }
                        if (secondUserId.equals(chat.getChatMembers().get(0).getUserId()) && firstUserId.equals(chat.getChatMembers().get(1).getUserId())) {
                            return chat;
                        }
                    }
                }
            }
            return null;
        }).when(chatDao).findPrivateChatBetweenUsers(any(Long.class), any(Long.class));

        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            List<Chat> chats = new ArrayList<>();
            for (Chat chat : getChatTable().values()) {
                for (ChatMember chatMember : chat.getChatMembers()) {
                    if (userId.equals(chatMember.getUserId())) {
                        chats.add(chat);
                        break;
                    }
                }
            }
            return chats;
        }).when(chatDao).findByUserId(any(Long.class));

        lenient().doAnswer(invocationOnMock -> {
            ChatType chatType = invocationOnMock.getArgument(0);
            List<Chat> chats = new ArrayList<>();
            for (Chat chat : getChatTable().values()) {
                if (chatType.equals(chat.getChatType())) {
                    chats.add(chat);
                }
            }
            return chats;
        }).when(chatDao).findByChatType(any(ChatType.class));

        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            String chatType = invocationOnMock.getArgument(1);
            List<Chat> chats = new ArrayList<>();
            for (Chat chat : getChatTable().values()) {
                if (chatType.equals(chat.getChatType().name())) {
                    for (ChatMember chatMember : chat.getChatMembers()) {
                        if (userId.equals(chatMember.getUserId())) {
                            chats.add(chat);
                            break;
                        }
                    }
                }
            }
            return chats;
        }).when(chatDao).findByUserIdAndChatType(any(Long.class), any(String.class));
    }

    private void chatSaveSetup() {
        lenient().doAnswer(invocationOnMock -> {
            Chat chat = invocationOnMock.getArgument(0);
            Long id;
            if (chat.getId() == null) {
                id = (long) chatTable.size() + 1;
                while (chatTable.containsKey(id)) {
                    id++;
                }
                chat.setId(id);
            } else {
                id = chat.getId();
            }
            chat.setChatMembers(new ArrayList<>());
            chat.setMessages(new ArrayList<>());
            chatTable.put(id, chat);
            chatDaoSetup();
            return chat;
        }).when(chatDao).save(any(Chat.class));
    }

    private void chatMemberDaoSetup() {
        chatMemberCommonMethodsSetUpper.findAllSetup(chatMemberTable, chatMemberDao);
        chatMemberCommonMethodsSetUpper.findByIdSetup(chatMemberTable, chatMemberDao);
        chatMemberDaoSaveSetup();
        chatMemberDeleteSetup();
        chatMemberCommonMethodsSetUpper.deleteSetup(chatMemberTable, chatMemberDao, ChatMember.class);
        chatMemberCommonMethodsSetUpper.existSetup(chatMemberTable, chatMemberDao);
        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            Long chatId = invocationOnMock.getArgument(1);
            for (ChatMember chatMember : getChatMemberTable().values()) {
                if (userId.equals(chatMember.getUserId()) && chatId.equals(chatMember.getChat().getId())) {
                    return chatMember;
                }
            }
            return null;
        }).when(chatMemberDao).findByUserIdAndChatId(any(Long.class), any(Long.class));

        lenient().doAnswer(invocationOnMock -> {
            String memberName = invocationOnMock.getArgument(0);
            Long chatId = invocationOnMock.getArgument(1);
            for (ChatMember chatMember : getChatMemberTable().values()) {
                if (memberName.equals(chatMember.getMemberName()) && chatId.equals(chatMember.getChat().getId())) {
                    return chatMember;
                }
            }
            return null;
        }).when(chatMemberDao).findByMemberNameAndChatId(any(String.class), any(Long.class));

        lenient().doAnswer(invocationOnMock -> {
            Long chatId = invocationOnMock.getArgument(0);
            Boolean notify = invocationOnMock.getArgument(1);
            List<ChatMember> chatMembers = new ArrayList<>();
            for (ChatMember chatMember : getChatMemberTable().values()) {
                if (chatId.equals(chatMember.getChat().getId()) && notify.equals(chatMember.getNotify())) {
                    chatMembers.add(chatMember);
                }
            }
            return chatMembers;
        }).when(chatMemberDao).findByChatIdAndNotify(any(Long.class), any(Boolean.class));
    }

    private void chatMemberDaoSaveSetup() {
        lenient().doAnswer(invocationOnMock -> {
            ChatMember chatMember = invocationOnMock.getArgument(0);
            Long id;
            if (chatMember.getId() == null) {
                id = (long) chatMemberTable.size() + 1;
                while (chatMemberTable.containsKey(id)) {
                    id++;
                }
                chatMember.setId(id);
            } else {
                id = chatMember.getId();
            }
            chatMemberTable.put(id, chatMember);
            chatMemberDaoSetup();
            return chatMember;
        }).when(chatMemberDao).save(any(ChatMember.class));
    }

    private void chatMemberDeleteSetup() {
        lenient().doAnswer(invocationOnMock -> {
            Long id = invocationOnMock.getArgument(0);
            if (chatMemberTable.containsKey(id)) {
                ChatMember chatMember = chatMemberTable.get(id);
                chatMember.getChat().getChatMembers().remove(chatMember);
                chatMemberTable.remove(id);
                chatMemberDaoSetup();
            } else {
                throw new NotFoundException("Entity with id " + id);
            }
            return null;
        }).when(chatMemberDao).deleteById(any(Long.class));
    }

    private void messageDaoSetup() {
        messageCommonMethodsSetUpper.findAllSetup(messageTable, messageDao);
        messageCommonMethodsSetUpper.findByIdSetup(messageTable, messageDao);
        messageDaoSaveSetup();
        messageCommonMethodsSetUpper.deleteSetup(messageTable, messageDao, Message.class);
        messageCommonMethodsSetUpper.deleteByIdSetup(messageTable, messageDao);
        messageCommonMethodsSetUpper.existSetup(messageTable, messageDao);
        lenient().doAnswer(invocationOnMock -> {
            Long chatId = invocationOnMock.getArgument(0);
            Boolean isRead = invocationOnMock.getArgument(1);
            List<Message> messages = new ArrayList<>();
            for (Message message : getMessageTable().values()) {
                if (chatId.equals(message.getChat().getId()) && isRead.equals(message.getIsRead())) {
                    messages.add(message);
                }
            }
            return messages;
        }).when(messageDao).findByChatIdAndIsRead(any(Long.class), any(Boolean.class));
    }

    private void messageDaoSaveSetup() {
        lenient().doAnswer(invocationOnMock -> {
            Message message = invocationOnMock.getArgument(0);
            Long id;
            if (message.getId() == null) {
                id = (long) messageTable.size() + 1;
                while (messageTable.containsKey(id)) {
                    id++;
                }
                message.setId(id);
            } else {
                id = message.getId();
            }
            messageTable.put(id, message);
//            message.getChat().getMessages().add(message);
            messageDaoSetup();
            return message;
        }).when(messageDao).save(any(Message.class));
    }
}
