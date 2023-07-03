package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardDao extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId);
}

