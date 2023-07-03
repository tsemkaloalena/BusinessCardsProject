package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
}
