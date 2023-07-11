package com.tsemkalo.businesscards.mapper;

import com.google.protobuf.GeneratedMessageV3;
import com.tsemkalo.businesscards.dto.AbstractDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;

public interface EntityProtoMapper<E extends AbstractEntity, P extends GeneratedMessageV3> {
    E protoToEntity(P proto);

    P entityToProto(E entity);
}
