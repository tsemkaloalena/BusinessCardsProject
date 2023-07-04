package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.FollowDao;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.exception.AlreadyExistsException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class FollowServiceImpl extends AbstractServiceImpl<Follow, FollowDao> implements FollowService {
    @Autowired
    private FollowDao followDao;

    @Autowired
    private CardDao cardDao;

    @Override
    public Class<Follow> getEntityClass() {
        return Follow.class;
    }

    @Override
    public void add(Long userId, Long cardId) {
        Follow follow = new Follow();
        follow.setUserId(userId);
        Optional<Card> optionalCard = cardDao.findById(cardId);
        if (optionalCard.isEmpty()) {
            throw new NotFoundException(getEntityClass().getSimpleName() + " with id " + cardId);
        }
        if (followDao.findByUserIdAndCardId(userId, cardId) != null) {
            throw new AlreadyExistsException("User " + userId + " already follows card " + cardId);
        }
        follow.setCard(optionalCard.get());
        followDao.save(follow);
    }

    @Override
    public void delete(Long userId, Long cardId) {
        Follow follow = followDao.findByUserIdAndCardId(userId, cardId);
        if (follow == null) {
            throw new IncorrectDataException("User " + userId + " doesn't follow card " + cardId);
        }
        followDao.delete(follow);
    }

    @Override
    public void edit(Follow oldFollow, Follow editedEntity) {
        throw new IncorrectDataException("Follow can not be edited");
    }

    @Override
    public List<Card> getUserFollowings(Long userId) {
        List<Follow> follows = followDao.findByUserId(userId);
        return follows.stream().map(Follow::getCard).collect(Collectors.toList());
    }
}
