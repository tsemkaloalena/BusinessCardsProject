package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entities.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {
    T getById(Long id);

    Long add(T entity);

    void delete(Long id);

    void edit(T oldEntity, T editedEntity);
}
