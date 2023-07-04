package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;

import java.util.List;

public interface ChatService {
    List<Chat> getUserChats(Long userId);

    List<Message> getChatMessages(Long chatId, Long userId);

    List<ChatMember> getChatMembersByChatId(Long chatId, Long userId);

    void changeMemberName(Long userId, Long chatId, String newName);

    void changeChatName(Long userId, Long chatId, String newName);

    void sendMessageToChat(String text, Long userId, Long chatId); // TODO send email

    Long sendMessageToUser(String text, Long senderId, Long recipientId, String senderName, String recipientName);

    void markMessageAsRead(Long userId, Long messageId); // TODO rabbitMQ

    void markAllChatMessagesAsRead(Long userId, Long chatId);

    void inviteMemberToChat(Long userId, Long chatId, Long newMemberId, String newMemberName);

    void sendToSupport(Long userId, String username, String theme, String text);

    List<Chat> getUnassignedSupportChats();

    void assignSupportChat(Long supporterId, String supporterName, Long chatId, Long oldSupporterId);

    void closeQuestion(Long userId, Long chatId, Boolean isAdmin);

    List<Chat> getSupportChats(Long userId);

    void changeSendingNotifications(Long userId, Long chatId, Boolean send);
}
