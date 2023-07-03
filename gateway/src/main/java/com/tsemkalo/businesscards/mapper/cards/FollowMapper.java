package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.FollowProto;
import com.tsemkalo.businesscards.dto.cards.FollowDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class FollowMapper implements Mapper<AbstractEntity, FollowDTO, FollowProto> {
    @Override
    public FollowDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(FollowDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(FollowProto proto) {
        return null;
    }

    @Override
    public FollowProto entityToProto(AbstractEntity entity) {
        return null;
    }

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
