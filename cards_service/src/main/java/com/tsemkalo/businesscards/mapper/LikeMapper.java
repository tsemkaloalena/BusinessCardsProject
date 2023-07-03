package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.LikeProto;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Like;
import com.tsemkalo.businesscards.dto.LikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper implements Mapper<Like, LikeDTO, LikeProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public LikeDTO entityToDTO(Like entity) {
        LikeDTO dto = new LikeDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUserId(entity.getUserId());
        dto.setCardId(entity.getCard().getId());
        return dto;
    }

    @Override
    public Like dtoToEntity(LikeDTO dto) {
        Like like = new Like();
        if (dto.getId() != null) {
            like.setId(dto.getId());
        }
        like.setUserId(dto.getUserId());
        like.setCard(cardDao.findById(dto.getCardId()).get());
        return like;
    }

    @Override
    public Like protoToEntity(LikeProto proto) {
        Like like = new Like();
        if (proto.getId() != 0) {
            like.setId(proto.getId());
        }
        like.setUserId(proto.getUserId());
        if (proto.getCardId() != 0) {
            like.setCard(cardDao.findById(proto.getCardId()).get());
        }
        return like;
    }

    @Override
    public LikeProto entityToProto(Like entity) {
        LikeProto.Builder builder = LikeProto.newBuilder()
                .setUserId(entity.getUserId())
                .setCardId(entity.getCard().getId());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
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
