package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.ProtoContactType;
import com.tsemkalo.businesscards.configuration.enums.cards.ContactType;
import com.tsemkalo.businesscards.dto.cards.ContactDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements DTOProtoMapper<ContactDTO, ContactProto> {
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
