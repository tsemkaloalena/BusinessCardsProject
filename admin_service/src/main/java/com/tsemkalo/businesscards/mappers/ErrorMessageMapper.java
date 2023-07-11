package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.ErrorMessageProto;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageMapper implements DTOProtoMapper<ErrorMessageDTO, ErrorMessageProto>, EntityDTOMapper<ErrorMessage, ErrorMessageDTO>, EntityProtoMapper<ErrorMessage, ErrorMessageProto> {
    @Override
    public ErrorMessageDTO entityToDTO(ErrorMessage entity) {
        ErrorMessageDTO dto = new ErrorMessageDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setCode(entity.getCode());
        dto.setReason(entity.getReason());
        return dto;
    }

    @Override
    public ErrorMessage dtoToEntity(ErrorMessageDTO dto) {
        ErrorMessage entity = new ErrorMessage();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setCode(dto.getCode());
        entity.setReason(dto.getReason());
        return entity;
    }

    @Override
    public ErrorMessage protoToEntity(ErrorMessageProto proto) {
        ErrorMessage entity = new ErrorMessage();
        if (proto.getId() != 0) {
            entity.setId(proto.getId());
        }
        entity.setCode(proto.getCode());
        entity.setReason(proto.getReason());
        return entity;
    }

    @Override
    public ErrorMessageProto entityToProto(ErrorMessage entity) {
        ErrorMessageProto.Builder builder = ErrorMessageProto.newBuilder()
                .setCode(entity.getCode())
                .setReason(entity.getReason());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

    @Override
    public ErrorMessageProto dtoToProto(ErrorMessageDTO dto) {
        ErrorMessageProto.Builder builder = ErrorMessageProto.newBuilder()
                .setCode(dto.getCode())
                .setReason(dto.getReason());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public ErrorMessageDTO protoToDTO(ErrorMessageProto proto) {
        ErrorMessageDTO dto = new ErrorMessageDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setCode(proto.getCode());
        dto.setReason(proto.getReason());
        return dto;
    }
}
