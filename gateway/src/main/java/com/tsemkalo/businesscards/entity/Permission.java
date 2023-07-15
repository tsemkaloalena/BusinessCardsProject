package com.tsemkalo.businesscards.entity;

import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Permission permission = (Permission) o;
        return Objects.equals(this.getId(), permission.getId()) &&
                Objects.equals(this.getName(), permission.getName()) &&
                Objects.equals(this.getRole(), permission.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getRole());
    }
}