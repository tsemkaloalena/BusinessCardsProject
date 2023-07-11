package com.tsemkalo.businesscards.entity;

import com.tsemkalo.businesscards.configuration.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Role extends AbstractEntity {
    private RoleType name;
    private List<Permission> permissions;

    public Role(Long id, RoleType name, List<Permission> permissions) {
        this.setId(id);
        this.name = name;
        this.permissions = permissions;
    }
}
