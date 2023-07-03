package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.RoleProto;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dto.RoleDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Mapper<Role, RoleDTO, RoleProto> {
    @Override
    public RoleDTO entityToDto(Role role) {
        return new RoleDTO(role.getId(), role.getName());
    }

    @Override
    public Role dtoToEntity(RoleDTO dto) {
        Role role = new Role(dto.getName());
        role.setId(dto.getId());
        return role;
    }

    @Override
    public Role protoToEntity(RoleProto userProto) {
        return null;
    }

    @Override
    public RoleProto entityToProto(Role user) {
        return null;
    }

    @Override
    public RoleProto dtoToProto(RoleDTO DTOEntity) {
        return null;
    }

    @Override
    public RoleDTO protoToDTO(RoleProto proto) {
        return null;
    }
}
