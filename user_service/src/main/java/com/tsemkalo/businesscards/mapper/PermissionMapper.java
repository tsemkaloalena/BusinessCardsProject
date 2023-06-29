package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.PermissionProto;
import com.tsemkalo.businesscards.dao.RoleDao;
import com.tsemkalo.businesscards.dao.entity.Permission;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dto.PermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermissionMapper implements Mapper<Permission, PermissionDTO, PermissionProto> {
    @Autowired
    RoleDao roleDao;

    @Override
    public PermissionDTO entityToDto(Permission permission) {
        Role role = permission.getRole();
        Long roleId = null;
        if (role != null) {
            roleId = role.getId();
        }
        return new PermissionDTO(permission.getId(), permission.getName(), roleId);
    }

    @Override
    public Permission dtoToEntity(PermissionDTO dto) {
        Role role = null;
        if (dto.getRoleId() != null) {
            Optional<Role> optionalRole = roleDao.findById(dto.getRoleId());
            if (optionalRole.isPresent()) {
                role = optionalRole.get();
            }
        }
        Permission permission = new Permission(dto.getName(), role);
        permission.setId(dto.getId());
        return permission;
    }

    @Override
    public Permission protoToEntity(PermissionProto userProto) {
        return null;
    }

    @Override
    public PermissionProto entityToProto(Permission user) {
        return null;
    }

    @Override
    public PermissionProto dtoToProto(PermissionDTO DTOEntity) {
        return null;
    }


}
