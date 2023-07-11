package com.tsemkalo.businesscards.mapper.messages;

import com.tsemkalo.businesscards.ChatMemberProto;
import com.tsemkalo.businesscards.dto.messages.ChatMemberDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ChatMemberMapper implements DTOProtoMapper<ChatMemberDTO, ChatMemberProto> {
    @Override
    public ChatMemberProto dtoToProto(ChatMemberDTO dto) {
        ChatMemberProto.Builder builder = ChatMemberProto.newBuilder()
                .setUserId(dto.getUserId())
                .setChatId(dto.getChatId())
                .setMemberName(dto.getMemberName())
                .setNotify(dto.getNotify());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public ChatMemberDTO protoToDTO(ChatMemberProto proto) {
        ChatMemberDTO dto = new ChatMemberDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setUserId(proto.getUserId());
        dto.setChatId(proto.getChatId());
        dto.setMemberName(proto.getMemberName());
        dto.setNotify(proto.getNotify());
        return dto;
    }
}
