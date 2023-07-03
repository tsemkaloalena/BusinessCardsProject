package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.PermissionProto;
import com.tsemkalo.businesscards.ProtoPermissionType;
import com.tsemkalo.businesscards.ProtoRoleType;
import com.tsemkalo.businesscards.RoleProto;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.dao.RoleDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.Permission;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper implements Mapper<User, UserDTO, UserProto> {
    @Autowired
    private RoleDao roleDao;

    public User nonActivatedToActivated(NonActivatedUser nonActivatedUser) {
        return new User(
                nonActivatedUser.getUsername(),
                nonActivatedUser.getPassword(),
                nonActivatedUser.getName(),
                nonActivatedUser.getSurname(),
                nonActivatedUser.getRole(),
                nonActivatedUser.getEmail());
    }

    @Override
    public UserDTO entityToDto(User user) {
        Role role = user.getRole();
        Long roleId = null;
        if (role != null) {
            roleId = role.getId();
        }
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), roleId, user.getEmail());
    }

    @Override
    public User dtoToEntity(UserDTO DTO) {
        Role role = null;
        if (DTO.getRoleId() != null) {
            Optional<Role> optionalRole = roleDao.findById(DTO.getRoleId());
            if (optionalRole.isPresent()) {
                role = optionalRole.get();
            }
        }
        User user = new User(DTO.getUsername(), DTO.getPassword(), DTO.getName(), DTO.getSurname(), role, DTO.getEmail());
        user.setId(DTO.getId());
        return user;
    }

    @Override
    public User protoToEntity(UserProto userProto) {
        Optional<Role> optionalRole = roleDao.findById(userProto.getRole().getId());
        Role role = null;
        if (optionalRole.isPresent()) {
            role = optionalRole.get();
        }
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
        UserProto.Builder userProtoBuilder = UserProto.newBuilder()
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setName(userDTO.getName())
                .setSurname(userDTO.getSurname())
                .setEmail(userDTO.getEmail());
        if (userDTO.getId() != null) {
            userProtoBuilder.setId(userDTO.getId());
        }
        Role role = null;
        if (userDTO.getRoleId() != null) {
            Optional<Role> optionalRole = roleDao.findById(userDTO.getRoleId());
            if (optionalRole.isPresent()) {
                role = optionalRole.get();
            }
        }
        if (role != null) {
            RoleProto.Builder roleProto = RoleProto.newBuilder()
                    .setId(userDTO.getRoleId())
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

