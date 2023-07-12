package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.generatedProtos.AddressProto;
import com.tsemkalo.businesscards.dto.cards.AddressDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements DTOProtoMapper<AddressDTO, AddressProto> {
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
