package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Follow;

import java.util.List;

public interface FollowService extends AbstractService<Follow> {
    void add(Long userId, Long cardId);

    void delete(Long userId, Long cardId);

    List<Card> getUserFollowings(Long userId);
}
