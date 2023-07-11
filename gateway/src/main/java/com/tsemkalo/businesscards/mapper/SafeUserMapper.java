package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.ProtoRoleType;
import com.tsemkalo.businesscards.RoleProto;
import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.RoleDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SafeUserMapper implements DTOProtoMapper<SafeUserDTO, SafeUserProto> {
    @Override
    public SafeUserProto dtoToProto(SafeUserDTO safeUserDTO) {
        RoleProto.Builder roleProto = RoleProto.newBuilder()
                .setId(safeUserDTO.getRoleDTO().getId())
                .setName(ProtoRoleType.valueOf(safeUserDTO.getRoleDTO().getName().name()));
        SafeUserProto.Builder userBuilder = SafeUserProto.newBuilder()
                .setUsername(safeUserDTO.getUsername())
                .setName(safeUserDTO.getName())
                .setSurname(safeUserDTO.getSurname())
                .setEmail(safeUserDTO.getEmail())
                .setRole(roleProto);
        if (safeUserDTO.getId() != null) {
            userBuilder.setId(safeUserDTO.getId());
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
