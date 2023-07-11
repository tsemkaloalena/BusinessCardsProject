package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.AddSupporterRequestProto;
import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import com.tsemkalo.businesscards.dto.AddSupporterRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AddSupporterRequestMapper implements DTOProtoMapper<AddSupporterRequestDTO, AddSupporterRequestProto>, EntityDTOMapper<AddSupporterRequest, AddSupporterRequestDTO>, EntityProtoMapper<AddSupporterRequest, AddSupporterRequestProto> {
    @Override
    public AddSupporterRequestDTO entityToDTO(AddSupporterRequest entity) {
        AddSupporterRequestDTO dto = new AddSupporterRequestDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUsername(entity.getUsername());
        return dto;
    }

    @Override
    public AddSupporterRequest dtoToEntity(AddSupporterRequestDTO dto) {
        AddSupporterRequest entity = new AddSupporterRequest();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setUsername(dto.getUsername());
        return entity;
    }

    @Override
    public AddSupporterRequest protoToEntity(AddSupporterRequestProto proto) {
        AddSupporterRequest entity = new AddSupporterRequest();
        if (proto.getId() != 0) {
            entity.setId(proto.getId());
        }
        entity.setUsername(proto.getUsername());
        return entity;
    }

    @Override
    public AddSupporterRequestProto entityToProto(AddSupporterRequest entity) {
        AddSupporterRequestProto.Builder builder = AddSupporterRequestProto.newBuilder()
                .setUsername(entity.getUsername());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

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
