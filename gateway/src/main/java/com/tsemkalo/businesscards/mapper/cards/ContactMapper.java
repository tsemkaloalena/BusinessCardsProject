package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.ProtoContactType;
import com.tsemkalo.businesscards.configuration.enums.cards.ContactType;
import com.tsemkalo.businesscards.dto.cards.ContactDTO;
import com.tsemkalo.businesscards.entity.AbstractEntity;
import com.tsemkalo.businesscards.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements Mapper<AbstractEntity, ContactDTO, ContactProto> {
    @Override
    public ContactDTO entityToDTO(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity dtoToEntity(ContactDTO dto) {
        return null;
    }

    @Override
    public AbstractEntity protoToEntity(ContactProto proto) {
        return null;
    }

    @Override
    public ContactProto entityToProto(AbstractEntity entity) {
        return null;
    }

    @Override
    public ContactProto dtoToProto(ContactDTO dto) {
        ContactProto.Builder builder = ContactProto.newBuilder()
                .setType(ProtoContactType.valueOf(dto.getType().name()))
                .setContent(dto.getContent());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public ContactDTO protoToDTO(ContactProto proto) {
        ContactDTO dto = new ContactDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setType(ContactType.valueOf(proto.getType().name()));
        dto.setContent(proto.getContent());
        dto.setCardId(proto.getCardId());
        return dto;
    }
}
