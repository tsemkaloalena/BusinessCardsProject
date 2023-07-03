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
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
}
