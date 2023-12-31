package com.tsemkalo.businesscards.dao.entity;

import com.tsemkalo.businesscards.configuration.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private RoleType name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private List<Permission> permissions;

    public Role(RoleType name) {
        this.name = name;
    }

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
