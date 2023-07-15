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
@Table(name = "follows")
@NoArgsConstructor
@Getter
@Setter
public class Follow extends AbstractEntity {
    @NotNull
    @Column
    private Long userId;

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
        final Follow follow = (Follow) o;
        return Objects.equals(this.getId(), follow.getId()) &&
                Objects.equals(this.getUserId(), follow.getUserId()) &&
                Objects.equals(this.getCard().getId(), follow.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserId(), this.getCard().getId());
    }
}
