package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.generatedProtos.PermissionProto;
import com.tsemkalo.businesscards.generatedProtos.ProtoPermissionType;
import com.tsemkalo.businesscards.generatedProtos.ProtoRoleType;
import com.tsemkalo.businesscards.generatedProtos.RoleProto;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProto;
import com.tsemkalo.businesscards.generatedProtos.UserProto;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dao.RoleDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.Permission;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dto.RoleDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NonActivatedUserMapper implements DTOProtoMapper<UserDTO, UserProto>, EntityDTOMapper<NonActivatedUser, UserDTO>, EntityProtoMapper<NonActivatedUser, UserProto> {
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDTO entityToDTO(NonActivatedUser user) {
        RoleDTO roleDTO = new RoleDTO(user.getRole().getId(), user.getRole().getName());
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), roleDTO, user.getEmail());
    }

    @Override
    public NonActivatedUser dtoToEntity(UserDTO DTO) {
        Role role = roleDao.findByName(RoleType.valueOf(DTO.getRoleDTO().getName().name()));
        return new NonActivatedUser(DTO.getId(), DTO.getUsername(), DTO.getPassword(), DTO.getName(), DTO.getSurname(), role, DTO.getEmail());
    }

    @Override
    public NonActivatedUser protoToEntity(UserProto userProto) {
        Optional<Role> optionalRole = roleDao.findById(userProto.getRole().getId());
        Role role = null;
        if (optionalRole.isPresent()) {
            role = optionalRole.get();
        }
        return new NonActivatedUser(userProto.getId(),
                userProto.getUsername(),
                userProto.getPassword(),
                userProto.getName(),
                userProto.getSurname(),
                role,
                userProto.getEmail());
    }

    @Override
    public UserProto entityToProto(NonActivatedUser user) {
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

        return UserProto.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setRole(roleProto)
                .setEmail(user.getEmail())
                .build();
    }

    public SafeUserProto entityToSafeProto(NonActivatedUser user) {
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

        return SafeUserProto.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setRole(roleProto)
                .setEmail(user.getEmail())
                .build();
    }

    @Override
    public UserProto dtoToProto(UserDTO userDTO) {
        UserProto.Builder userProtoBuilder = UserProto.newBuilder()
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setName(userDTO.getName())
                .setSurname(userDTO.getSurname())
                .setEmail(userDTO.getEmail());
        if (userDTO.getId() != null) {
            userProtoBuilder.setId(userDTO.getId());
        }
        Role role = roleDao.findByName(RoleType.valueOf(userDTO.getRoleDTO().getName().name()));
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
            userProtoBuilder.setRole(roleProto);
        }
        return userProtoBuilder.build();
    }

    @Override
    public UserDTO protoToDTO(UserProto proto) {
        return null;
    }
}

