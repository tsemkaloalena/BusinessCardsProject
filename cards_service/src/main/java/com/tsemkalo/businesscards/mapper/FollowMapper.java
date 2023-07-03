package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.FollowProto;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.dto.FollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FollowMapper implements Mapper<Follow, FollowDTO, FollowProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public FollowDTO entityToDTO(Follow entity) {
        FollowDTO dto = new FollowDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUserId(entity.getUserId());
        dto.setCardId(entity.getCard().getId());
        return dto;
    }

    @Override
    public Follow dtoToEntity(FollowDTO dto) {
        Follow follow = new Follow();
        if (dto.getId() != null) {
            follow.setId(dto.getId());
        }
        follow.setUserId(dto.getUserId());
        follow.setCard(cardDao.findById(dto.getCardId()).get());
        return follow;
    }

    @Override
    public Follow protoToEntity(FollowProto proto) {
        Follow follow = new Follow();
        if (proto.getId() != 0) {
            follow.setId(proto.getId());
        }
        follow.setUserId(proto.getUserId());
        if (proto.getCardId() != 0) {
            follow.setCard(cardDao.findById(proto.getCardId()).get());
        }
        return follow;
    }

    @Override
    public FollowProto entityToProto(Follow entity) {
        FollowProto.Builder builder = FollowProto.newBuilder()
                .setUserId(entity.getUserId())
                .setCardId(entity.getCard().getId());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
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
