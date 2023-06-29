package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.dao.entity.AbstractEntity;
import com.tsemkalo.businesscards.dto.AbstractDTO;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO, P extends com.google.protobuf.GeneratedMessageV3> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    E protoToEntity(P userProto);

    P entityToProto(E user);

    P dtoToProto(D DTOEntity);
}
