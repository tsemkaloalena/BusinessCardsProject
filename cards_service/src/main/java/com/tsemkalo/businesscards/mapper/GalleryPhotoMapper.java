package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.generatedProtos.GalleryPhotoProto;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.dto.GalleryPhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GalleryPhotoMapper implements DTOProtoMapper<GalleryPhotoDTO, GalleryPhotoProto>, EntityDTOMapper<GalleryPhoto, GalleryPhotoDTO>, EntityProtoMapper<GalleryPhoto, GalleryPhotoProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public GalleryPhotoDTO entityToDTO(GalleryPhoto entity) {
        GalleryPhotoDTO dto = new GalleryPhotoDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setCardId(entity.getCard().getId());
        dto.setImgPath(entity.getImgPath());
        return dto;
    }

    @Override
    public GalleryPhoto dtoToEntity(GalleryPhotoDTO dto) {
        GalleryPhoto galleryPhoto = new GalleryPhoto();
        if (dto.getId() != null) {
            galleryPhoto.setId(dto.getId());
        }
        galleryPhoto.setCard(cardDao.findById(dto.getCardId()).get());
        galleryPhoto.setImgPath(dto.getImgPath());
        return galleryPhoto;
    }

    @Override
    public GalleryPhoto protoToEntity(GalleryPhotoProto proto) {
        GalleryPhoto galleryPhoto = new GalleryPhoto();
        if (proto.getId() != 0) {
            galleryPhoto.setId(proto.getId());
        }
        if (proto.getCardId() != 0) {
            galleryPhoto.setCard(cardDao.findById(proto.getCardId()).get());
        }
        galleryPhoto.setImgPath(proto.getImgPath());
        return galleryPhoto;
    }

    @Override
    public GalleryPhotoProto entityToProto(GalleryPhoto entity) {
        GalleryPhotoProto.Builder builder = GalleryPhotoProto.newBuilder()
                .setCardId(entity.getCard().getId())
                .setImgPath(entity.getImgPath());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
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
