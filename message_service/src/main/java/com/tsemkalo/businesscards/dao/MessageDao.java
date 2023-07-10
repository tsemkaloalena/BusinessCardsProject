package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Long> {
    List<Message> findByChatIdAndIsReadOrderBySendingTimeAsc(Long chatId, Boolean isRead);
}
