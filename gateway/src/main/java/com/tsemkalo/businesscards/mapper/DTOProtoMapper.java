package com.tsemkalo.businesscards.mapper;

import com.google.protobuf.GeneratedMessageV3;
import com.tsemkalo.businesscards.dto.AbstractDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;

public interface DTOProtoMapper<D extends AbstractDTO, P extends GeneratedMessageV3> {
    P dtoToProto(D DTOEntity);

    D protoToDTO(P proto);
}
