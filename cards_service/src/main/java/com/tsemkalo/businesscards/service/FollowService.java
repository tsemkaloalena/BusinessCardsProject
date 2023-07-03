package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entity.Follow;

public interface FollowService extends AbstractService<Follow> {
    void add(Long userId, Long cardId);

    void delete(Long userId, Long cardId);
}
