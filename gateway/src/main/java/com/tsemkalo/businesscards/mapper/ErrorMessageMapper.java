package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.ErrorMessageProto;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageMapper implements DTOProtoMapper<ErrorMessageDTO, ErrorMessageProto> {
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
