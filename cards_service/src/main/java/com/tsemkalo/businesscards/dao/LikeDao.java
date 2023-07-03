package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.dao.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDao extends JpaRepository<Like, Long>  {
    Like findByUserIdAndCardId(Long userId, Long cardId);
}
