package com.tsemkalo.businesscards;

import com.tsemkalo.businesscards.dao.entity.AbstractEntity;
import com.tsemkalo.businesscards.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

public class CommonMethodsSetUpper<T extends AbstractEntity> {
    public void findAllSetup(Map<Long, T> hashMap, JpaRepository<T, Long> dao) {
        lenient().when(dao.findAll()).thenReturn(new ArrayList<T>(hashMap.values()));
    }

    public void findByIdSetup(Map<Long, T> hashMap, JpaRepository<T, Long> dao) {
        lenient().doAnswer(invocationOnMock -> {
            Long id = invocationOnMock.getArgument(0);
            Optional<T> optional = Optional.empty();
            if (hashMap.containsKey(id)) {
                optional = Optional.of(hashMap.get(id));
            }
            return optional;
        }).when(dao).findById(any(Long.class));
    }

    public void saveSetup(Map<Long, T> hashMap, JpaRepository<T, Long> dao, Class<T> type) {
        lenient().doAnswer(invocationOnMock -> {
            T entity = invocationOnMock.getArgument(0);
            Long id = (long) hashMap.size() + 1;
            while (hashMap.containsKey(id)) {
                id++;
            }
            entity.setId(id);
            hashMap.put(id, entity);
            findAllSetup(hashMap, dao);
            findByIdSetup(hashMap, dao);
            return entity;
        }).when(dao).save(any(type));
    }

    public void deleteByIdSetup(Map<Long, T> hashMap, JpaRepository<T, Long> dao) {
        lenient().doAnswer(invocationOnMock -> {
            Long id = invocationOnMock.getArgument(0);
            if (hashMap.containsKey(id)) {
                hashMap.remove(id);
                findAllSetup(hashMap, dao);
                findByIdSetup(hashMap, dao);
            } else {
                throw new NotFoundException("Entity with id " + id);
            }
            return null;
        }).when(dao).deleteById(any(Long.class));
    }

    public void deleteSetup(Map<Long, T> hashMap, JpaRepository<T, Long> dao, Class<T> type) {
        lenient().doAnswer(invocationOnMock -> {
            T entity = invocationOnMock.getArgument(0);
            for (Long id : hashMap.keySet()) {
                if (hashMap.get(id).equals(entity)) {
                    hashMap.remove(id);
                    findAllSetup(hashMap, dao);
                    findByIdSetup(hashMap, dao);
                    return null;
                }
            }
            throw new NotFoundException("Entity with id " + entity.getId());
        }).when(dao).delete(any(type));
    }
}
