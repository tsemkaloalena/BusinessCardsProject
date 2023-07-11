package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.entity.AbstractEntity;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.AbstractService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractServiceImpl<T extends AbstractEntity, D extends JpaRepository<T, Long>> implements AbstractService<T, D> {
    @Autowired
    @Getter
    private D defaultDao;

    protected AbstractServiceImpl(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    protected AbstractServiceImpl() {
        this.defaultDao = null;
    }

    public abstract Class<T> getEntityClass();

    @Override
    public T getById(Long id) {
        if (id == null) {
            throw new IncorrectDataException(getEntityClass().getSimpleName() + " id is not set");
        }
        Optional<T> optional = defaultDao.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException(getEntityClass().getSimpleName() + " with id " + id);
        }
        return optional.get();
    }

    @Override
    public Long add(T entity) {
        if (entity.getId() != null) {
            throw new IncorrectDataException(getEntityClass().getSimpleName() + " is not null");
        }
        defaultDao.save(entity);
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        if (defaultDao.existsById(id)) {
            defaultDao.deleteById(id);
        } else {
            throw new NotFoundException(getEntityClass().getSimpleName() + " with id " + id);
        }
    }
}
