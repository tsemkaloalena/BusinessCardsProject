package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class SafeUserMapper implements Mapper<User, SafeUserDTO, SafeUserProto> {
    @Override
    public SafeUserDTO entityToDto(User user) {
        Role role = user.getRole();
        String roleName = "unknown role";
        if (role != null) {
            roleName = role.getName().name().toLowerCase();
        }
        return new SafeUserDTO(user.getId(), user.getUsername(), user.getName(), user.getSurname(), roleName, user.getEmail());
    }

    @Override
    public User dtoToEntity(SafeUserDTO dto) {
        return null;
    }

    @Override
    public User protoToEntity(SafeUserProto userProto) {
        return null;
    }

    @Override
    public SafeUserProto entityToProto(User user) {
        SafeUserProto.Builder userBuilder = SafeUserProto.newBuilder()
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setRole(user.getRole().getName().name());
        if (user.getId() != null) {
            userBuilder.setId(user.getId());
        }
        return userBuilder.build();
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
