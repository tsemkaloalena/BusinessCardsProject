package com.tsemkalo.businesscards.mapper.messages;

import com.google.protobuf.Timestamp;
import com.tsemkalo.businesscards.MessageProto;
import com.tsemkalo.businesscards.dto.messages.MessageDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MessageMapper implements DTOProtoMapper<MessageDTO, MessageProto> {
    @Override
    public MessageProto dtoToProto(MessageDTO dto) {
        Instant instant = dto.getSendingTime().toInstant(ZoneOffset.UTC);
        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
        MessageProto.Builder builder = MessageProto.newBuilder()
                .setMemberId(dto.getMemberId())
                .setChatId(dto.getChatId())
                .setSendingTime(timestamp)
                .setText(dto.getText())
                .setRead(dto.getIsRead());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public MessageDTO protoToDTO(MessageProto proto) {
        MessageDTO dto = new MessageDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setMemberId(proto.getMemberId());
        dto.setChatId(proto.getChatId());
        Timestamp timestamp = proto.getSendingTime();
        LocalDateTime sendingTime = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime();
        dto.setSendingTime(sendingTime);
        dto.setText(proto.getText());
        dto.setIsRead(proto.getRead());
        return dto;
    }
}
