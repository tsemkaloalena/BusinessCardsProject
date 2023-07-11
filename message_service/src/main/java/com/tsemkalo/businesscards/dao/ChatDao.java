package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.configuration.enums.ChatType;
import com.tsemkalo.businesscards.dao.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatDao extends JpaRepository<Chat, Long> {
    @Query(value = """
            SELECT * FROM chats
            INNER JOIN chat_members AS c1
            ON chats.id = c1.chat_id
            INNER JOIN chat_members AS c2
            ON c1.user_id = :first_user_id AND c2.user_id = :second_user_id AND c1.chat_id = c2.chat_id AND chats.chat_type = 'PRIVATE'
            """, nativeQuery = true)
    Chat findPrivateChatBetweenUsers(@Param("first_user_id") Long firstUserId,
                                     @Param("second_user_id") Long secondUserId);

    @Query(value = """
            SELECT * FROM chats
            INNER JOIN chat_members
            ON chats.id = chat_id AND user_id = :user_id
            """, nativeQuery = true)
    List<Chat> findByUserId(@Param("user_id") Long userId);

    List<Chat> findByChatType(ChatType chatType);

    @Query(value = """
            SELECT chats.* FROM chats
            INNER JOIN chat_members on chats.id = chat_id
            WHERE chat_type = :chat_type AND user_id = :user_id
            """, nativeQuery = true)
    List<Chat> findByUserIdAndChatType(@Param("user_id") Long userId, @Param("chat_type") String chatType);
}
