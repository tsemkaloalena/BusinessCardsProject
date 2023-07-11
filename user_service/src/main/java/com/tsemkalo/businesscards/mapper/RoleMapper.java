package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dto.RoleDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements EntityDTOMapper<Role, RoleDTO> {
    @Override
    public RoleDTO entityToDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName());
    }

    @Override
    public Role dtoToEntity(RoleDTO dto) {
        Role role = new Role(dto.getName());
        role.setId(dto.getId());
        return role;
    }
}
