package com.tsemkalo.businesscards.mapper;

import com.google.protobuf.GeneratedMessageV3;
import com.tsemkalo.businesscards.dao.entity.AbstractEntity;

public interface EntityProtoMapper<E extends AbstractEntity, P extends GeneratedMessageV3> {
    E protoToEntity(P proto);

    P entityToProto(E entity);
}
