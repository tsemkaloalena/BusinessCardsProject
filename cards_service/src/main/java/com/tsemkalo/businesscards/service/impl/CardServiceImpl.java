package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class CardServiceImpl extends AbstractServiceImpl<Card, CardDao> implements CardService {
    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }

    @Override
    public void edit(Card oldCard, Card editedCard) {
        if (!editedCard.getUserId().equals(oldCard.getUserId())) {
            throw new AccessDeniedException("User id doesn't match to the original one");
        }
        if (editedCard.getTitle().isBlank()) {
            throw new IncorrectDataException("Card title is blank");
        }
        if (editedCard.getLogoImgPath().isBlank()) {
            throw new IncorrectDataException("Card logo image path is blank");
        }
        if (editedCard.getHeadline().isBlank()) {
            throw new IncorrectDataException("Card headline is blank");
        }
        if (editedCard.getDescription().isBlank()) {
            throw new IncorrectDataException("Card description is blank");
        }
        oldCard.setTitle(editedCard.getTitle());
        oldCard.setLogoImgPath(editedCard.getLogoImgPath());
        oldCard.setHeadline(editedCard.getHeadline());
        oldCard.setDescription(editedCard.getDescription());
    }

    @Override
    public List<Card> getCardsByUserId(Long userId) {
        return getDefaultDao().findByUserId(userId);
    }

    @Override
    public Long getAvailableCardOwnerId(Long currentCardOwnerId, Long currentUserId, Boolean isCurrentUserAdmin, Long oldCardOwnerId) {
        if (isCurrentUserAdmin) {
            if (currentCardOwnerId == null) {
                throw new IncorrectDataException("You didn't set user's id");
            }
            return currentCardOwnerId;
        }
        if (currentCardOwnerId == null) {
            return currentUserId;
        }
        if (currentCardOwnerId.equals(currentUserId) && (oldCardOwnerId == null || currentCardOwnerId.equals(oldCardOwnerId))) {
            return currentCardOwnerId;
        }
        throw new AccessDeniedException("This card owner id and your id don't match");
    }
}
