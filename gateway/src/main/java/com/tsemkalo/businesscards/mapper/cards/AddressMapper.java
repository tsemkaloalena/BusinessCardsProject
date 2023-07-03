package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.AddressProto;
import com.tsemkalo.businesscards.dto.cards.AddressDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<AbstractEntity, AddressDTO, AddressProto> {

    @Override
    public AddressDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(AddressDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(AddressProto proto) {
        return null;
    }

    @Override
    public AddressProto entityToProto(AbstractEntity entity) {
        return null;
    }

    @Override
    public AddressProto dtoToProto(AddressDTO dto) {
        AddressProto.Builder builder = AddressProto.newBuilder()
                .setAddress(dto.getAddress())
                .setShowOnMap(dto.getShowOnMap());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public AddressDTO protoToDTO(AddressProto proto) {
        AddressDTO dto = new AddressDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setAddress(proto.getAddress());
        dto.setShowOnMap(proto.getShowOnMap());
        dto.setCardId(proto.getCardId());
        return dto;
    }
}
