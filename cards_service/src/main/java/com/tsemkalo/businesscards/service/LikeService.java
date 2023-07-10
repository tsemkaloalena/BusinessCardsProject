package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.LikeDao;
import com.tsemkalo.businesscards.dao.entity.Like;

public interface LikeService extends AbstractService<Like, LikeDao> {
    void add(Long userId, Long cardId);

    void delete(Long userId, Long cardId);
}
