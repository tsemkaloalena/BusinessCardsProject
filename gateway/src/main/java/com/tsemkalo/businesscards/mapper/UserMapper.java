package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.generatedProtos.PermissionProto;
import com.tsemkalo.businesscards.generatedProtos.ProtoPermissionType;
import com.tsemkalo.businesscards.generatedProtos.ProtoRoleType;
import com.tsemkalo.businesscards.generatedProtos.RoleProto;
import com.tsemkalo.businesscards.generatedProtos.UserProto;
import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.entity.Permission;
import com.tsemkalo.businesscards.entity.Role;
import com.tsemkalo.businesscards.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements EntityProtoMapper<User, UserProto>, DTOProtoMapper<UserDTO, UserProto> {
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
                .setId(userDTO.getRoleDTO().getId())
                .setName(ProtoRoleType.valueOf(userDTO.getRoleDTO().getName().name()));
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

    @Override
    public UserDTO protoToDTO(UserProto proto) {
        return null;
    }
}
