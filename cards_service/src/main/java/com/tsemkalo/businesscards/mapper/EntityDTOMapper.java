package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.dao.entity.AbstractEntity;
import com.tsemkalo.businesscards.dto.AbstractDTO;

public interface EntityDTOMapper<E extends AbstractEntity, D extends AbstractDTO> {
    D entityToDTO(E entity);

    E dtoToEntity(D dto);
}
