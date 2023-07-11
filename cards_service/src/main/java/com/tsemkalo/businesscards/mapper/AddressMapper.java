package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.AddressProto;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements DTOProtoMapper<AddressDTO, AddressProto>, EntityDTOMapper<Address, AddressDTO>, EntityProtoMapper<Address, AddressProto> {
    @Autowired
    private CardDao cardDao;

    @Override
    public AddressDTO entityToDTO(Address entity) {
        AddressDTO dto = new AddressDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setAddress(entity.getAddress());
        dto.setShowOnMap(entity.getShowOnMap());
        dto.setCardId(entity.getCard().getId());
        return dto;
    }

    @Override
    public Address dtoToEntity(AddressDTO dto) {
        Address address = new Address();
        if (dto.getId() != null) {
            address.setId(dto.getId());
        }
        address.setAddress(dto.getAddress());
        address.setShowOnMap(dto.getShowOnMap());
        address.setCard(cardDao.findById(dto.getCardId()).get());
        return address;
    }

    @Override
    public Address protoToEntity(AddressProto proto) {
        Address address = new Address();
        if (proto.getId() != 0) {
            address.setId(proto.getId());
        }
        address.setAddress(proto.getAddress());
        address.setShowOnMap(proto.getShowOnMap());
        if (proto.getCardId() != 0) {
            address.setCard(cardDao.findById(proto.getCardId()).get());
        }
        return address;
    }

    @Override
    public AddressProto entityToProto(Address entity) {
        AddressProto.Builder builder = AddressProto.newBuilder()
                .setAddress(entity.getAddress())
                .setShowOnMap(entity.getShowOnMap())
                .setCardId(entity.getCard().getId());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

    @Override
    public AddressProto dtoToProto(AddressDTO dto) {
        AddressProto.Builder builder = AddressProto.newBuilder()
                .setAddress(dto.getAddress())
                .setShowOnMap(dto.getShowOnMap());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        if (dto.getCardId() != null) {
            builder.setCardId(dto.getCardId());
        }
        return builder.build();
    }

    @Override
    public AddressDTO protoToDTO(AddressProto proto) {
        AddressDTO dto = new AddressDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setAddress(proto.getAddress());
        dto.setShowOnMap(proto.getShowOnMap());
        dto.setCardId(proto.getCardId());
        return dto;
    }
}
