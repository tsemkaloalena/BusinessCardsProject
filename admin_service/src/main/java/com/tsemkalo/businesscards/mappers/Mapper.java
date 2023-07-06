package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.dao.entities.AbstractEntity;
import com.tsemkalo.businesscards.dto.AbstractDTO;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO, P extends com.google.protobuf.GeneratedMessageV3> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    E protoToEntity(P proto);

    P entityToProto(E entity);

    P dtoToProto(D dto);

    D protoToDTO(P proto);
}
