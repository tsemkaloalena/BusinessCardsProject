package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.ErrorMessageProto;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageMapper implements Mapper<AbstractEntity, ErrorMessageDTO, ErrorMessageProto> {

    @Override
    public ErrorMessageDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(ErrorMessageDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(ErrorMessageProto proto) {
        return null;
    }

    @Override
    public ErrorMessageProto entityToProto(AbstractEntity entity) {
        return null;
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
