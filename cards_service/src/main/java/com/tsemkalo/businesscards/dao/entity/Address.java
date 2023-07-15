package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
public class Address extends AbstractEntity {
    @NotNull
    @Column
    private String address;

    @NotNull
    @Column
    private Boolean showOnMap;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Address address = (Address) o;
        return Objects.equals(this.getId(), address.getId()) &&
                Objects.equals(this.getAddress(), address.getAddress()) &&
                Objects.equals(this.getShowOnMap(), address.getShowOnMap()) &&
                Objects.equals(this.getCard().getId(), address.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getAddress(), this.getShowOnMap(), this.getCard().getId());
    }
}
