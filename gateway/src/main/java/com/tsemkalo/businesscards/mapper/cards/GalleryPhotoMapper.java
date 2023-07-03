package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.GalleryPhotoProto;
import com.tsemkalo.businesscards.dto.cards.GalleryPhotoDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GalleryPhotoMapper implements Mapper<AbstractEntity, GalleryPhotoDTO, GalleryPhotoProto> {
    @Override
    public GalleryPhotoDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(GalleryPhotoDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(GalleryPhotoProto proto) {
        return null;
    }

    @Override
    public GalleryPhotoProto entityToProto(AbstractEntity entity) {
        return null;
    }

    @Override
    public GalleryPhotoProto dtoToProto(GalleryPhotoDTO dto) {
        GalleryPhotoProto.Builder builder = GalleryPhotoProto.newBuilder()
                .setImgPath(dto.getImgPath());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public GalleryPhotoDTO protoToDTO(GalleryPhotoProto proto) {
        GalleryPhotoDTO dto = new GalleryPhotoDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setCardId(proto.getCardId());
        dto.setImgPath(proto.getImgPath());
        return dto;
    }
}
