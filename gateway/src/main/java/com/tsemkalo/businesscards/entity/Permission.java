package com.tsemkalo.businesscards.entity;

import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission extends AbstractEntity {
    private PermissionType name;
    private Role role;

    public Permission(Long id, PermissionType name, Role role) {
        this.setId(id);
        this.name = name;
        this.role = role;
    }
}