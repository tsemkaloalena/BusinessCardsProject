package com.tsemkalo.businesscards.mapper.messages;

import com.tsemkalo.businesscards.ChatProto;
import com.tsemkalo.businesscards.ChatTypeProto;
import com.tsemkalo.businesscards.configuration.enums.ChatType;
import com.tsemkalo.businesscards.dto.messages.ChatDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper implements Mapper<AbstractEntity, ChatDTO, ChatProto> {

    @Override
    public ChatDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(ChatDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(ChatProto proto) {
        return null;
    }

    @Override
    public ChatProto entityToProto(AbstractEntity entity) {
        return null;
    }

    @Override
    public ChatProto dtoToProto(ChatDTO dto) {
        ChatProto.Builder builder = ChatProto.newBuilder()
                .setName(dto.getName())
                .setChatType(ChatTypeProto.valueOf(dto.getChatType().name()));
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public ChatDTO protoToDTO(ChatProto proto) {
        ChatDTO dto = new ChatDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setName(proto.getName());
        dto.setChatType(ChatType.valueOf(proto.getChatType().name()));
        return dto;
    }
}
