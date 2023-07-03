package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.LikeDao;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Like;
import com.tsemkalo.businesscards.exception.AlreadyExistsException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class LikeServiceImpl extends AbstractServiceImpl<Like, LikeDao> implements LikeService {
    @Autowired
    private CardDao cardDao;

    @Autowired
    private LikeDao likeDao;

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    public void add(Long userId, Long cardId) {
        Like like = new Like();
        like.setUserId(userId);
        Optional<Card> optionalCard = cardDao.findById(cardId);
        if (optionalCard.isEmpty()) {
            throw new NotFoundException(getEntityClass().getSimpleName() + " with id " + cardId);
        }
        if (likeDao.findByUserIdAndCardId(userId, cardId) != null) {
            throw new AlreadyExistsException("User " + userId + " already liked card " + cardId);
        }
        like.setCard(optionalCard.get());
        likeDao.save(like);
    }

    @Override
    public void delete(Long userId, Long cardId) {
        Like like = likeDao.findByUserIdAndCardId(userId, cardId);
        if (like == null) {
            throw new IncorrectDataException("User " + userId + " didn't check like card " + cardId);
        }
        likeDao.delete(like);
    }

    @Override
    public void edit(Like oldLike, Like editedEntity) {
        throw new IncorrectDataException("Like can not be edited");
    }
}
