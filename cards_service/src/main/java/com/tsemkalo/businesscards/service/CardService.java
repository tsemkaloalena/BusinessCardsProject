package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Card;

import java.util.List;

public interface CardService extends AbstractService<Card, CardDao> {

    List<Card> getCardsByUserId(Long userId);

    Long getAvailableCardOwnerId(Long currentCardOwnerId, Long currentUserId, Boolean isCurrentUserAdmin, Long oldCardOwnerId);
}
