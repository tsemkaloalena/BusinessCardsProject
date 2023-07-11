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
}
