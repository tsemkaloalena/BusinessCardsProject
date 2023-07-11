package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.ChatProto;
import com.tsemkalo.businesscards.ChatTypeProto;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dto.ChatDTO;
import com.tsemkalo.businesscards.configuration.enums.ChatType;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper implements DTOProtoMapper<ChatDTO, ChatProto>, EntityDTOMapper<Chat, ChatDTO>, EntityProtoMapper<Chat, ChatProto> {
    @Override
    public ChatDTO entityToDTO(Chat entity) {
        ChatDTO dto = new ChatDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setName(entity.getName());
        dto.setChatType(ChatType.valueOf(entity.getChatType().name()));
        return dto;
    }

    @Override
    public Chat dtoToEntity(ChatDTO dto) {
        Chat chat = new Chat();
        if (dto.getId() != null) {
            chat.setId(dto.getId());
        }
        chat.setName(dto.getName());
        chat.setChatType(ChatType.valueOf(dto.getChatType().name()));
        return chat;
    }

    @Override
    public Chat protoToEntity(ChatProto proto) {
        Chat chat = new Chat();
        if (proto.getId() != 0) {
            chat.setId(proto.getId());
        }
        chat.setName(proto.getName());
        chat.setChatType(ChatType.valueOf(proto.getChatType().name()));
        return chat;
    }

    @Override
    public ChatProto entityToProto(Chat entity) {
        ChatProto.Builder builder = ChatProto.newBuilder()
                .setName(entity.getName())
                .setChatType(ChatTypeProto.valueOf(entity.getChatType().name()));
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
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
