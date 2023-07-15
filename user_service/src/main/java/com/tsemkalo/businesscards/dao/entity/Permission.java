package com.tsemkalo.businesscards.dao.entity;

import com.tsemkalo.businesscards.configuration.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private PermissionType name;

    @ManyToOne
    @JoinColumn(name = "role_id")
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