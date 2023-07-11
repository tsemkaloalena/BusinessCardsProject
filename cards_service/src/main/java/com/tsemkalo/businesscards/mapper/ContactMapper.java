package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.ProtoContactType;
import com.tsemkalo.businesscards.configuration.enums.ContactType;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements DTOProtoMapper<ContactDTO, ContactProto>, EntityDTOMapper<Contact, ContactDTO>, EntityProtoMapper<Contact, ContactProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public ContactDTO entityToDTO(Contact entity) {
        ContactDTO dto = new ContactDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setType(ContactType.valueOf(entity.getType().name()));
        dto.setContent(entity.getContent());
        dto.setCardId(entity.getCard().getId());
        return dto;
    }

    @Override
    public Contact dtoToEntity(ContactDTO dto) {
        Contact contact = new Contact();
        if (dto.getId() != null) {
            contact.setId(dto.getId());
        }
        contact.setType(ContactType.valueOf(dto.getType().name()));
        contact.setContent(dto.getContent());
        contact.setCard(cardDao.findById(dto.getCardId()).get());
        return contact;
    }

    @Override
    public Contact protoToEntity(ContactProto proto) {
        Contact contact = new Contact();
        if (proto.getId() != 0) {
            contact.setId(proto.getId());
        }
        contact.setType(ContactType.valueOf(proto.getType().name()));
        contact.setContent(proto.getContent());
        if (proto.getCardId() != 0) {
            contact.setCard(cardDao.findById(proto.getCardId()).get());
        }
        return contact;
    }

    @Override
    public ContactProto entityToProto(Contact entity) {
        ContactProto.Builder builder = ContactProto.newBuilder()
                .setId(entity.getId())
                .setType(ProtoContactType.valueOf(entity.getType().name()))
                .setContent(entity.getContent())
                .setCardId(entity.getCard().getId());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
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
