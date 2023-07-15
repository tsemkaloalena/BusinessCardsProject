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
@Table(name = "likes")
@NoArgsConstructor
@Getter
@Setter
public class Like extends AbstractEntity {
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
        final Like like = (Like) o;
        return Objects.equals(this.getId(), like.getId()) &&
                Objects.equals(this.getUserId(), like.getUserId()) &&
                Objects.equals(this.getCard().getId(), like.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserId(), this.getCard().getId());
    }
}
