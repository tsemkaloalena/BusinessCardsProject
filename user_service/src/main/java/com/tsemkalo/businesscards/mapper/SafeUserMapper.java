package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
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
        return null;
    }

    @Override
    public SafeUserProto dtoToProto(SafeUserDTO DTOEntity) {
        return null;
    }
}
