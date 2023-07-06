package com.tsemkalo.businesscards.mappers;

import com.tsemkalo.businesscards.ChatMemberProto;
import com.tsemkalo.businesscards.dao.ChatDao;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dto.ChatMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChatMemberMapper implements Mapper<ChatMember, ChatMemberDTO, ChatMemberProto> {
    @Autowired
    private ChatDao chatDao;

    @Override
    public ChatMemberDTO entityToDTO(ChatMember entity) {
        ChatMemberDTO dto = new ChatMemberDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUserId(entity.getUserId());
        dto.setChatId(entity.getChat().getId());
        dto.setMemberName(entity.getMemberName());
        dto.setNotify(entity.getNotify());
        return dto;
    }

    @Override
    public ChatMember dtoToEntity(ChatMemberDTO dto) {
        ChatMember chatMember = new ChatMember();
        if (dto.getId() != null) {
            chatMember.setId(dto.getId());
        }
        chatMember.setUserId(dto.getUserId());
        Optional<Chat> optionalChat = chatDao.findById(dto.getChatId());
        optionalChat.ifPresent(chatMember::setChat);
        chatMember.setMemberName(dto.getMemberName());
        chatMember.setNotify(dto.getNotify());
        return chatMember;
    }

    @Override
    public ChatMember protoToEntity(ChatMemberProto proto) {
        ChatMember chatMember = new ChatMember();
        if (proto.getId() != 0) {
            chatMember.setId(proto.getId());
        }
        chatMember.setUserId(proto.getUserId());
        Optional<Chat> optionalChat = chatDao.findById(proto.getChatId());
        optionalChat.ifPresent(chatMember::setChat);
        chatMember.setMemberName(proto.getMemberName());
        chatMember.setNotify(proto.getNotify());
        return chatMember;
    }

    @Override
    public ChatMemberProto entityToProto(ChatMember entity) {
        ChatMemberProto.Builder builder = ChatMemberProto.newBuilder()
                .setUserId(entity.getUserId())
                .setChatId(entity.getChat().getId())
                .setMemberName(entity.getMemberName())
                .setNotify(entity.getNotify());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

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
