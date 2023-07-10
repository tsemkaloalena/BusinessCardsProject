package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import com.tsemkalo.businesscards.configuration.enums.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.PictureStretchingType;
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
@Table(name = "appearances")
@NoArgsConstructor
@Getter
@Setter
public class Appearance extends AbstractEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @NotNull
    @Column
    private String fontName;

    @NotNull
    @Column
    private String backgroundColor;

    @Column
    private String backgroundImagePath;

    @Column
    @Enumerated(EnumType.STRING)
    private PictureStretchingType pictureStretching;

    @NotNull
    @Column
    private String mainColor;

    @NotNull
    @Column
    private String secondColor;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private GalleryType galleryType;
}
