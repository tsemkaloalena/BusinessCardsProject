package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMemberDao extends JpaRepository<ChatMember, Long> {

    ChatMember findByUserIdAndChatId(Long userId, Long chatId);

    ChatMember findByMemberNameAndChatId(String memberName, Long chatId);
}
