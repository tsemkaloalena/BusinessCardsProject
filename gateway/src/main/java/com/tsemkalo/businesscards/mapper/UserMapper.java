package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.PermissionProto;
import com.tsemkalo.businesscards.ProtoPermissionType;
import com.tsemkalo.businesscards.ProtoRoleType;
import com.tsemkalo.businesscards.RoleProto;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.entity.Permission;
import com.tsemkalo.businesscards.entity.Role;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.enums.PermissionType;
import com.tsemkalo.businesscards.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper implements Mapper<User, UserDTO, UserProto> {

    @Override
    public UserDTO entityToDto(User user) {
        return null;
    }

    @Override
    public User dtoToEntity(UserDTO DTO) {
        return null;
    }

    @Override
    public User protoToEntity(UserProto userProto) {
        Role role = new Role();
        role.setId(userProto.getRole().getId());
        role.setName(RoleType.valueOf(userProto.getRole().getName().name()));
        List<Permission> permissions = new ArrayList<>();
        for (PermissionProto permissionProto : userProto.getRole().getPermissionList()) {
            permissions.add(new Permission(permissionProto.getId(), PermissionType.valueOf(permissionProto.getName().name()), role));
        }
        role.setPermissions(permissions);

        return new User(userProto.getId(),
                userProto.getUsername(),
                userProto.getPassword(),
                userProto.getName(),
                userProto.getSurname(),
                role,
                userProto.getEmail());
    }

    @Override
    public UserProto entityToProto(User user) {
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

    @Override
    public UserProto dtoToProto(UserDTO userDTO) {
        RoleProto.Builder roleProto = RoleProto.newBuilder()
                .setId(userDTO.getRoleId());
        UserProto.Builder userBuilder = UserProto.newBuilder()
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setName(userDTO.getName())
                .setSurname(userDTO.getSurname())
                .setEmail(userDTO.getEmail())
                .setRole(roleProto);
        if (userDTO.getId() != null) {
            userBuilder.setId(userDTO.getId());
        }
        return userBuilder.build();
    }
}

