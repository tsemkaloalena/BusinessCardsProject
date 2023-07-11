package com.tsemkalo.businesscards.mappers;

import com.google.protobuf.GeneratedMessageV3;
import com.tsemkalo.businesscards.dto.AbstractDTO;

public interface DTOProtoMapper<D extends AbstractDTO, P extends GeneratedMessageV3> {
    P dtoToProto(D DTOEntity);

    D protoToDTO(P proto);
}
