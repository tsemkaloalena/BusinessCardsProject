package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entity.Like;

public interface LikeService extends AbstractService<Like> {
    void add(Long userId, Long cardId);

    void delete(Long userId, Long cardId);
}
