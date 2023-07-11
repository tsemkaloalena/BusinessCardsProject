package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.AddSupporterRequestProto;
import com.tsemkalo.businesscards.dto.AddSupporterRequestDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import org.springframework.stereotype.Component;

@Component
public class AddSupporterRequestMapper implements DTOProtoMapper<AddSupporterRequestDTO, AddSupporterRequestProto> {
    @Override
    public AddSupporterRequestProto dtoToProto(AddSupporterRequestDTO dto) {
        AddSupporterRequestProto.Builder builder = AddSupporterRequestProto.newBuilder()
                .setUsername(dto.getUsername());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public AddSupporterRequestDTO protoToDTO(AddSupporterRequestProto proto) {
        AddSupporterRequestDTO dto = new AddSupporterRequestDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setUsername(proto.getUsername());
        return dto;
    }
}
