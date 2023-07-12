package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.generatedProtos.FollowProto;
import com.tsemkalo.businesscards.dto.cards.FollowDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class FollowMapper implements DTOProtoMapper<FollowDTO, FollowProto> {
    @Override
    public FollowProto dtoToProto(FollowDTO dto) {
        FollowProto.Builder builder = FollowProto.newBuilder()
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
    public FollowDTO protoToDTO(FollowProto proto) {
        FollowDTO dto = new FollowDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setUserId(proto.getUserId());
        dto.setCardId(proto.getCardId());
        return dto;
    }
}
