package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.AppearanceProto;
import com.tsemkalo.businesscards.ProtoGalleryType;
import com.tsemkalo.businesscards.ProtoPictureStretchingType;
import com.tsemkalo.businesscards.configuration.enums.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.PictureStretchingType;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.dto.AppearanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppearanceMapper implements Mapper<Appearance, AppearanceDTO, AppearanceProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public AppearanceDTO entityToDTO(Appearance entity) {
        AppearanceDTO dto = new AppearanceDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setCardId(entity.getCard().getId());
        dto.setFontName(entity.getFontName());
        dto.setBackgroundColor(entity.getBackgroundColor());
        dto.setBackgroundImagePath(entity.getBackgroundImagePath());
        dto.setPictureStretching(PictureStretchingType.valueOf(entity.getPictureStretching().name()));
        dto.setMainColor(entity.getMainColor());
        dto.setSecondColor(entity.getSecondColor());
        dto.setGalleryType(GalleryType.valueOf(entity.getGalleryType().name()));
        return dto;
    }

    @Override
    public Appearance dtoToEntity(AppearanceDTO dto) {
        Appearance appearance = new Appearance();
        if (dto.getId() != null) {
            appearance.setId(dto.getId());
        }
        appearance.setCard(cardDao.findById(dto.getCardId()).get());
        appearance.setFontName(dto.getFontName());
        appearance.setBackgroundColor(dto.getBackgroundColor());
        appearance.setBackgroundImagePath(dto.getBackgroundImagePath());
        appearance.setPictureStretching(PictureStretchingType.valueOf(dto.getPictureStretching().name()));
        appearance.setMainColor(dto.getMainColor());
        appearance.setSecondColor(dto.getSecondColor());
        appearance.setGalleryType(GalleryType.valueOf(dto.getGalleryType().name()));
        return appearance;
    }

    @Override
    public Appearance protoToEntity(AppearanceProto proto) {
        Appearance appearance = new Appearance();
        if (proto.getId() != 0) {
            appearance.setId(proto.getId());
        }
        if (proto.getCardId() != 0) {
            appearance.setCard(cardDao.findById(proto.getCardId()).get());
        }
        appearance.setFontName(proto.getFontName());
        appearance.setBackgroundColor(proto.getBackgroundColor());
        appearance.setBackgroundImagePath(proto.getBackgroundImagePath());
        appearance.setPictureStretching(PictureStretchingType.valueOf(proto.getPictureStretching().name()));
        appearance.setMainColor(proto.getMainColor());
        appearance.setSecondColor(proto.getSecondColor());
        appearance.setGalleryType(GalleryType.valueOf(proto.getGalleryType().name()));
        return appearance;
    }

    @Override
    public AppearanceProto entityToProto(Appearance entity) {
        AppearanceProto.Builder builder = AppearanceProto.newBuilder()
                .setId(entity.getId())
                .setCardId(entity.getCard().getId())
                .setFontName(entity.getFontName())
                .setBackgroundColor(entity.getBackgroundColor())
                .setBackgroundImagePath(entity.getBackgroundImagePath())
                .setPictureStretching(ProtoPictureStretchingType.valueOf(entity.getPictureStretching().name()))
                .setMainColor(entity.getMainColor())
                .setSecondColor(entity.getSecondColor())
                .setGalleryType(ProtoGalleryType.valueOf(entity.getGalleryType().name()));
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

    @Override
    public AppearanceProto dtoToProto(AppearanceDTO dto) {
        AppearanceProto.Builder builder = AppearanceProto.newBuilder()
                .setFontName(dto.getFontName())
                .setBackgroundColor(dto.getBackgroundColor())
                .setBackgroundImagePath(dto.getBackgroundImagePath())
                .setPictureStretching(ProtoPictureStretchingType.valueOf(dto.getPictureStretching().name()))
                .setMainColor(dto.getMainColor())
                .setSecondColor(dto.getSecondColor())
                .setGalleryType(ProtoGalleryType.valueOf(dto.getGalleryType().name()));
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public AppearanceDTO protoToDTO(AppearanceProto proto) {
        AppearanceDTO dto = new AppearanceDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setCardId(proto.getCardId());
        dto.setFontName(proto.getFontName());
        dto.setBackgroundColor(proto.getBackgroundColor());
        dto.setBackgroundImagePath(proto.getBackgroundImagePath());
        dto.setPictureStretching(PictureStretchingType.valueOf(proto.getPictureStretching().name()));
        dto.setMainColor(proto.getMainColor());
        dto.setSecondColor(proto.getSecondColor());
        dto.setGalleryType(GalleryType.valueOf(proto.getGalleryType().name()));
        return dto;
    }
}
