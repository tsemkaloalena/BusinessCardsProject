package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import com.tsemkalo.businesscards.configuration.enums.ContactType;
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
@Table(name = "contacts")
@NoArgsConstructor
@Getter
@Setter
public class Contact extends AbstractEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private ContactType type;

    @NotNull
    @Column
    private String content;

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
        final Contact contact = (Contact) o;
        return Objects.equals(this.getId(), contact.getId()) &&
                Objects.equals(this.getType(), contact.getType()) &&
                Objects.equals(this.getContent(), contact.getContent()) &&
                Objects.equals(this.getCard().getId(), contact.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getType(), this.getContent(), this.getCard().getId());
    }
}
