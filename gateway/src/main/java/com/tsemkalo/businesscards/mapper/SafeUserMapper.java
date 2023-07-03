package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SafeUserMapper implements Mapper<User, SafeUserDTO, SafeUserProto> {

    @Override
    public SafeUserDTO entityToDTO(User user) {
        return null;
    }

    @Override
    public User dtoToEntity(SafeUserDTO DTO) {
        return null;
    }

    @Override
    public User protoToEntity(SafeUserProto safeUserProto) {
        return null;
    }

    @Override
    public SafeUserProto entityToProto(User user) {
        return null;
    }

    @Override
    public SafeUserProto dtoToProto(SafeUserDTO safeUserDTO) {
        SafeUserProto.Builder userBuilder = SafeUserProto.newBuilder()
                .setUsername(safeUserDTO.getUsername())
                .setName(safeUserDTO.getName())
                .setSurname(safeUserDTO.getSurname())
                .setEmail(safeUserDTO.getEmail())
                .setRole(safeUserDTO.getRole());
        if (safeUserDTO.getId() != null) {
            userBuilder.setId(safeUserDTO.getId());
        }
        return userBuilder.build();
    }

    @Override
    public SafeUserDTO protoToDTO(SafeUserProto proto) {
        return new SafeUserDTO(proto.getId(),
                proto.getUsername(),
                proto.getName(),
                proto.getSurname(),
                proto.getRole(),
                proto.getEmail());
    }
}


