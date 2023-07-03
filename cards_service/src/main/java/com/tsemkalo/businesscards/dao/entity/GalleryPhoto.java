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
@Table(name = "gallery_photos")
@NoArgsConstructor
@Getter
@Setter
public class GalleryPhoto extends AbstractEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @NotNull
    @Column
    private String imgPath;
}
