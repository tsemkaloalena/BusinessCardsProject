package com.tsemkalo.businesscards.dto;

import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDTO extends AbstractDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private PermissionType name;
    private Long roleId;

    public PermissionDTO(Long id, PermissionType name, Long roleId) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
    }
}
