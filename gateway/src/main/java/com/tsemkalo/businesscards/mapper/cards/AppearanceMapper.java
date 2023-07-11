package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.AppearanceProto;
import com.tsemkalo.businesscards.ProtoGalleryType;
import com.tsemkalo.businesscards.ProtoPictureStretchingType;
import com.tsemkalo.businesscards.configuration.enums.cards.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.cards.PictureStretchingType;
import com.tsemkalo.businesscards.dto.cards.AppearanceDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class AppearanceMapper implements DTOProtoMapper<AppearanceDTO, AppearanceProto> {
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
