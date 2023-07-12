package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.generatedProtos.PermissionProto;
import com.tsemkalo.businesscards.generatedProtos.ProtoPermissionType;
import com.tsemkalo.businesscards.generatedProtos.ProtoRoleType;
import com.tsemkalo.businesscards.generatedProtos.RoleProto;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProto;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dao.RoleDao;
import com.tsemkalo.businesscards.dao.entity.Permission;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.RoleDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SafeUserMapper implements DTOProtoMapper<SafeUserDTO, SafeUserProto>, EntityDTOMapper<User, SafeUserDTO>, EntityProtoMapper<User, SafeUserProto> {
    @Autowired
    private RoleDao roleDao;

    @Override
    public SafeUserDTO entityToDTO(User user) {
        RoleDTO roleDTO = new RoleDTO(user.getRole().getId(), user.getRole().getName());
        return new SafeUserDTO(user.getId(), user.getUsername(), user.getName(), user.getSurname(), roleDTO, user.getEmail());
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
        RoleProto.Builder roleProto = RoleProto.newBuilder()
                .setId(user.getRole().getId())
                .setName(ProtoRoleType.valueOf(user.getRole().getName().name()));
        List<PermissionProto> permissionProtos = new ArrayList<>();
        for (Permission permission : user.getRole().getPermissions()) {
            PermissionProto permissionProto = PermissionProto.newBuilder()
                    .setId(permission.getId())
                    .setName(ProtoPermissionType.valueOf(permission.getName().name()))
                    .build();
            permissionProtos.add(permissionProto);
        }
        roleProto.addAllPermission(permissionProtos);
        SafeUserProto.Builder userBuilder = SafeUserProto.newBuilder()
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setRole(roleProto);
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
                .setEmail(safeUserDTO.getEmail());
        if (safeUserDTO.getId() != null) {
            userBuilder.setId(safeUserDTO.getId());
        }

        Role role = roleDao.findByName(RoleType.valueOf(safeUserDTO.getRoleDTO().getName().name()));
        if (role != null) {
            RoleProto.Builder roleProto = RoleProto.newBuilder()
                    .setId(role.getId())
                    .setName(ProtoRoleType.valueOf(role.getName().name()));
            List<PermissionProto> permissionProtos = new ArrayList<>();
            for (Permission permission : role.getPermissions()) {
                PermissionProto permissionProto = PermissionProto.newBuilder()
                        .setId(permission.getId())
                        .setName(ProtoPermissionType.valueOf(permission.getName().name()))
                        .build();
                permissionProtos.add(permissionProto);
            }
            roleProto.addAllPermission(permissionProtos);
            userBuilder.setRole(roleProto);
        }
        return userBuilder.build();
    }

    @Override
    public SafeUserDTO protoToDTO(SafeUserProto proto) {
        RoleDTO roleDTO = new RoleDTO(proto.getRole().getId(), RoleType.valueOf(proto.getRole().getName().name()));
        return new SafeUserDTO(proto.getId(),
                proto.getUsername(),
                proto.getName(),
                proto.getSurname(),
                roleDTO,
                proto.getEmail());
    }
}
