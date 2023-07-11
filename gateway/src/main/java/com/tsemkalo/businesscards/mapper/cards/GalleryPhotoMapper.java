package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.GalleryPhotoProto;
import com.tsemkalo.businesscards.dto.cards.GalleryPhotoDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class GalleryPhotoMapper implements DTOProtoMapper<GalleryPhotoDTO, GalleryPhotoProto> {
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
