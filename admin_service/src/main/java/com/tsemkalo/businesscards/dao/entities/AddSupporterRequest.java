package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "add_supporter_requests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddSupporterRequest extends AbstractEntity {
    @NotNull
    @Column
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final AddSupporterRequest request = (AddSupporterRequest) o;
        return Objects.equals(this.getId(), request.getId()) &&
                Objects.equals(this.getUsername(), request.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUsername());
    }
}
