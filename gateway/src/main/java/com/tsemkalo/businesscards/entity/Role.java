package com.tsemkalo.businesscards.entity;

import com.tsemkalo.businesscards.configuration.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Role role = (Role) o;
        return Objects.equals(this.getId(), role.getId()) &&
                Objects.equals(this.getName(), role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName());
    }
}
