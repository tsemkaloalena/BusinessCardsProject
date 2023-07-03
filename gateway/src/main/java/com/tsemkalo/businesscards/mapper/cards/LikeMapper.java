package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.LikeProto;
import com.tsemkalo.businesscards.dto.cards.LikeDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper implements Mapper<AbstractEntity, LikeDTO, LikeProto> {
    @Override
    public LikeDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(LikeDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(LikeProto proto) {
        return null;
    }

    @Override
    public LikeProto entityToProto(AbstractEntity entity) {
        return null;
    }

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
