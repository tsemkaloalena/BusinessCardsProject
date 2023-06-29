package com.tsemkalo.businesscards.dto;

import com.tsemkalo.businesscards.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO extends AbstractDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private RoleType name;

    public RoleDTO(Long id, RoleType name) {
        this.id = id;
        this.name = name;
    }
}
