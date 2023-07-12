package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.generatedProtos.LikeProto;
import com.tsemkalo.businesscards.dto.cards.LikeDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper implements DTOProtoMapper<LikeDTO, LikeProto> {
    @Override
    public LikeProto dtoToProto(LikeDTO dto) {
        LikeProto.Builder builder = LikeProto.newBuilder()
                .setUserId(dto.getUserId());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public LikeDTO protoToDTO(LikeProto proto) {
        LikeDTO dto = new LikeDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setUserId(proto.getUserId());
        dto.setCardId(proto.getCardId());
        return dto;
    }
}
