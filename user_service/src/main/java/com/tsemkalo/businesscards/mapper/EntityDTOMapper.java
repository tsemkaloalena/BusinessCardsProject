package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import com.tsemkalo.businesscards.dao.entity.AbstractEntity;

public interface EntityDTOMapper<E extends AbstractEntity, D extends AbstractDTO> {
    D entityToDTO(E entity);

    E dtoToEntity(D dto);
}
