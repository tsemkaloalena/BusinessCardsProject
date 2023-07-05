package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.ChatDao;
import com.tsemkalo.businesscards.dao.ChatMemberDao;
import com.tsemkalo.businesscards.dao.MessageDao;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;
import com.tsemkalo.businesscards.configuration.enums.ChatType;
import com.tsemkalo.businesscards.exceptions.AccessDeniedException;
import com.tsemkalo.businesscards.exceptions.AlreadyExistsException;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatDao chatDao;

    @Autowired
    private ChatMemberDao chatMemberDao;

    @Autowired
    private MessageDao messageDao;

    public Chat getChatById(Long chatId) {
        Optional<Chat> optional = chatDao.findById(chatId);
        if (optional.isEmpty()) {
            throw new NotFoundException("Chat with id " + chatId);
        }
        return optional.get();
    }

    public Message getMessageById(Long messageId) {
        Optional<Message> optional = messageDao.findById(messageId);
        if (optional.isEmpty()) {
            throw new NotFoundException("Message with id " + messageId);
        }
        return optional.get();
    }

    public void checkUserAccessToChat(Long chatId, Long userId) {
        ChatMember chatMember = chatMemberDao.findByUserIdAndChatId(userId, chatId);
        if (chatMember == null) {
            throw new AccessDeniedException("User " + userId + " is not a member of chat " + chatId);
        }
    }

    public List<Chat> getUserChats(Long userId) {
        return chatDao.findByUserId(userId);
    }

    public List<Message> getChatMessages(Long chatId, Long userId) {
        Chat chat = getChatById(chatId);
        checkUserAccessToChat(chatId, userId);
        return chat.getMessages();
    }

    public List<ChatMember> getChatMembersByChatId(Long chatId, Long userId) {
        checkUserAccessToChat(chatId, userId);
        return getChatById(chatId).getChatMembers();
    }

    public void changeMemberName(Long userId, Long chatId, String newName) {
        if (newName.isBlank()) {
            throw new IncorrectDataException("Member name can not be empty");
        }
        ChatMember chatMember = chatMemberDao.findByMemberNameAndChatId(newName, chatId);
        if (chatMember != null) {
            throw new AlreadyExistsException("chat member " + newName + " already exists in chat " + chatId);
        }
        chatMember = chatMemberDao.findByUserIdAndChatId(userId, chatId);
        chatMember.setMemberName(newName);
    }

    public void changeChatName(Long userId, Long chatId, String newName) {
        if (newName.isBlank()) {
            throw new IncorrectDataException("Chat name can not be empty");
        }
        checkUserAccessToChat(chatId, userId);
        Chat chat = getChatById(chatId);
        chat.setName(newName);
    }

    public List<Long> sendMessageToChat(String text, Long userId, Long chatId) {
        checkUserAccessToChat(chatId, userId);
        LocalDateTime sendingTime = LocalDateTime.now();
        checkUserAccessToChat(chatId, userId);
        Chat chat = getChatById(chatId);
        ChatMember sender = chatMemberDao.findByUserIdAndChatId(userId, chatId);
        Message message = new Message(sender, chat, sendingTime, text, false);
        messageDao.save(message);

        List<ChatMember> chatMembersToNotify = chatMemberDao.findByChatIdAndNotify(chatId, true);
        return chatMembersToNotify.stream().map(ChatMember::getUserId).collect(Collectors.toList());
    }

    public Boolean sendMessageToUser(String text, Long senderId, Long recipientId, String senderName, String recipientName) {
        Boolean notify = true;
        Chat chat = chatDao.findPrivateChatBetweenUsers(senderId, recipientId);
        ChatMember sender;
        if (chat == null) {
            chat = new Chat();
            chat.setName(senderName + ", " + recipientName);
            chat.setChatType(ChatType.PRIVATE);
            chatDao.save(chat);
            sender = new ChatMember(senderId, senderName, chat, true);
            ChatMember recipient = new ChatMember(recipientId, recipientName, chat, true);
            chatMemberDao.save(sender);
            chatMemberDao.save(recipient);
        } else {
            sender = chatMemberDao.findByUserIdAndChatId(senderId, chat.getId());
            notify = chatMemberDao.findByUserIdAndChatId(recipientId, chat.getId()).getNotify();
        }
        if (sender == null) {
            throw new IncorrectDataException("Sender is not found");
        }
        LocalDateTime sendingTime = LocalDateTime.now();
        Message message = new Message(sender, chat, sendingTime, text, false);
        messageDao.save(message);
        return notify;
    }

    public void markMessageAsRead(Long userId, Long messageId) {
        Message message = getMessageById(messageId);
        checkUserAccessToChat(message.getChat().getId(), userId);
        message.setRead(true);
    }

    public void markAllChatMessagesAsRead(Long userId, Long chatId) {
        checkUserAccessToChat(chatId, userId);
        List<Message> unreadMessages = messageDao.findByChatIdAndRead(chatId, false);
        for (Message message : unreadMessages) {
            message.setRead(true);
        }
    }

    public void inviteMemberToChat(Long userId, Long chatId, Long newMemberId, String newMemberName) {
        checkUserAccessToChat(chatId, userId);
        ChatMember chatMember = chatMemberDao.findByUserIdAndChatId(newMemberId, chatId);
        if (chatMember != null) {
            throw new AlreadyExistsException("User " + newMemberId + " is already a member of chat " + chatId);
        }
        Chat chat = getChatById(chatId);
        if (chat.getChatType().equals(ChatType.GROUP) || chat.getChatType().equals(ChatType.PRIVATE)) {
            chat.setChatType(ChatType.GROUP);
            chatMember = new ChatMember(newMemberId, newMemberName, chat, true);
            chatMemberDao.save(chatMember);
            return;
        }
        throw new AccessDeniedException("This chat can not be for group");
    }

    public void sendToSupport(Long userId, String username, String theme, String text) {
        Chat chat = new Chat();
        chat.setName(theme);
        chat.setChatType(ChatType.SUPPORT_UNASSIGNED);
        chatDao.save(chat);
        ChatMember chatMember = new ChatMember(userId, username, chat, true);
        chatMemberDao.save(chatMember);
        LocalDateTime sendingTime = LocalDateTime.now();
        Message message = new Message(chatMember, chat, sendingTime, text, false);
        messageDao.save(message);
    }

    public List<Chat> getUnassignedSupportChats() {
        return chatDao.findByChatType(ChatType.SUPPORT_UNASSIGNED);
    }

    public void assignSupportChat(Long supporterId, String supporterName, Long chatId, Long oldSupporterId) {
        Chat chat = getChatById(chatId);
        if (oldSupporterId != null) {
            if (!(ChatType.SUPPORT_QUESTION.equals(chat.getChatType()) || ChatType.SUPPORT_UNASSIGNED.equals(chat.getChatType()))) {
                throw new AccessDeniedException("User doesn't need support anymore");
            }
            ChatMember oldChatMember = chatMemberDao.findByUserIdAndChatId(oldSupporterId, chatId);
            chatMemberDao.deleteById(oldChatMember.getId());
        }
        if (oldSupporterId == null) {
            if (ChatType.SUPPORT_QUESTION.equals(chat.getChatType())) {
                throw new AccessDeniedException("This question is already assigned");
            }
            if (ChatType.SUPPORT_CLOSED.equals(chat.getChatType())) {
                throw new AccessDeniedException("This question is already closed");
            }
            if (!ChatType.SUPPORT_UNASSIGNED.equals(chat.getChatType())) {
                throw new AccessDeniedException("This chat is not unassigned for support");
            }
        }
        ChatMember supporter = new ChatMember(supporterId, supporterName, chat, true);
        chatMemberDao.save(supporter);
        chat.setChatType(ChatType.SUPPORT_QUESTION);
    }

    public List<Long> closeQuestion(Long userId, Long chatId, Boolean isAdmin) {
        if (!isAdmin) {
            checkUserAccessToChat(chatId, userId);
        }
        Chat chat = getChatById(chatId);
        chat.setChatType(ChatType.SUPPORT_CLOSED);
        return chat.getChatMembers().stream().map(ChatMember::getUserId).collect(Collectors.toList());
    }

    public List<Chat> getSupportChats(Long userId) {
        List<Chat> chats = chatDao.findByUserIdAndChatType(userId, ChatType.SUPPORT_QUESTION);
        chats.addAll(chatDao.findByUserIdAndChatType(userId, ChatType.SUPPORT_UNASSIGNED));
        return chats;
    }

    @Override
    public void changeSendingNotifications(Long userId, Long chatId, Boolean send) {
        ChatMember chatMember = chatMemberDao.findByUserIdAndChatId(userId, chatId);
        if (chatMember == null) {
            throw new NotFoundException("User " + userId + " is not a member of chat " + chatId);
        }
        chatMember.setNotify(send);
    }
    //sendToAdmin (for errors)
    //for admin: getErrorChats
}
