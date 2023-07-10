package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dao.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractService<T extends AbstractEntity, D extends JpaRepository<T, Long>> {

//    D getDefaultDao();

    T getById(Long id);

    Long add(T entity);

    void delete(Long id);

    void edit(T oldEntity, T editedEntity);
}
