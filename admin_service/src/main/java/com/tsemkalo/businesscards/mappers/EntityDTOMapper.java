package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.dao.entities.AbstractEntity;
import com.tsemkalo.businesscards.dto.AbstractDTO;

public interface EntityDTOMapper<E extends AbstractEntity, D extends AbstractDTO> {
    D entityToDTO(E entity);

    E dtoToEntity(D dto);
}
