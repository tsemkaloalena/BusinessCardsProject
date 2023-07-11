package com.tsemkalo.businesscards.mappers;

import com.google.protobuf.GeneratedMessageV3;
import com.tsemkalo.businesscards.dao.entities.AbstractEntity;

public interface EntityProtoMapper<E extends AbstractEntity, P extends GeneratedMessageV3> {
    E protoToEntity(P proto);

    P entityToProto(E entity);
}
