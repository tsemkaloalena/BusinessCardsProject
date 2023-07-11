package com.tsemkalo.businesscards.mappers;

import com.google.protobuf.Timestamp;
import com.tsemkalo.businesscards.MessageProto;
import com.tsemkalo.businesscards.dao.ChatDao;
import com.tsemkalo.businesscards.dao.ChatMemberDao;
import com.tsemkalo.businesscards.dao.entities.Chat;
import com.tsemkalo.businesscards.dao.entities.ChatMember;
import com.tsemkalo.businesscards.dao.entities.Message;
import com.tsemkalo.businesscards.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class MessageMapper implements DTOProtoMapper<MessageDTO, MessageProto>, EntityDTOMapper<Message, MessageDTO>, EntityProtoMapper<Message, MessageProto> {
    @Autowired
    private ChatDao chatDao;

    @Autowired
    private ChatMemberDao chatMemberDao;

    @Override
    public MessageDTO entityToDTO(Message entity) {
        MessageDTO dto = new MessageDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setMemberId(entity.getChatMember().getId());
        dto.setChatId(entity.getChat().getId());
        dto.setSendingTime(entity.getSendingTime());
        dto.setText(entity.getText());
        dto.setIsRead(entity.getIsRead());
        return dto;
    }

    @Override
    public Message dtoToEntity(MessageDTO dto) {
        Message message = new Message();
        if (dto.getId() != null) {
            message.setId(dto.getId());
        }
        Optional<ChatMember> optionalChatMember = chatMemberDao.findById(dto.getMemberId());
        optionalChatMember.ifPresent(message::setChatMember);
        Optional<Chat> optionalChat = chatDao.findById(dto.getChatId());
        optionalChat.ifPresent(message::setChat);
        message.setSendingTime(dto.getSendingTime());
        message.setText(dto.getText());
        message.setIsRead(dto.getIsRead());
        return message;
    }

    @Override
    public Message protoToEntity(MessageProto proto) {
        Message message = new Message();
        if (proto.getId() != 0) {
            message.setId(proto.getId());
        }
        Optional<ChatMember> optionalChatMember = chatMemberDao.findById(proto.getMemberId());
        optionalChatMember.ifPresent(message::setChatMember);
        Optional<Chat> optionalChat = chatDao.findById(proto.getChatId());
        optionalChat.ifPresent(message::setChat);
        Timestamp timestamp = proto.getSendingTime();
        LocalDateTime sendingTime = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime();
        message.setSendingTime(sendingTime);
        message.setText(proto.getText());
        message.setIsRead(proto.getRead());
        return message;
    }

    @Override
    public MessageProto entityToProto(Message entity) {
        Instant instant = entity.getSendingTime().toInstant(ZoneOffset.UTC);
        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
        MessageProto.Builder builder = MessageProto.newBuilder()
                .setMemberId(entity.getChatMember().getId())
                .setChatId(entity.getChat().getId())
                .setSendingTime(timestamp)
                .setText(entity.getText())
                .setRead(entity.getIsRead());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

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
