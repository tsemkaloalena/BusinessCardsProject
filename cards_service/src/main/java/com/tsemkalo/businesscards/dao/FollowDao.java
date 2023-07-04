package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowDao extends JpaRepository<Follow, Long> {
    Follow findByUserIdAndCardId(Long userId, Long cardId);
    List<Follow> findByUserId(Long userId);
}
