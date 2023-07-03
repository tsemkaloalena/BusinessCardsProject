package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowDao extends JpaRepository<Follow, Long> {
    Follow findByUserIdAndCardId(Long userId, Long cardId);
}
