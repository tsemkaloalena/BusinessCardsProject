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
import javax.persistence.Table;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Appearance appearance = (Appearance) o;
        return Objects.equals(this.getId(), appearance.getId()) &&
                Objects.equals(this.getFontName(), appearance.getFontName()) &&
                Objects.equals(this.getBackgroundColor(), appearance.getBackgroundColor()) &&
                Objects.equals(this.getBackgroundImagePath(), appearance.getBackgroundImagePath()) &&
                Objects.equals(this.getPictureStretching(), appearance.getPictureStretching()) &&
                Objects.equals(this.getMainColor(), appearance.getMainColor()) &&
                Objects.equals(this.getSecondColor(), appearance.getSecondColor()) &&
                Objects.equals(this.getGalleryType(), appearance.getGalleryType()) &&
                Objects.equals(this.getCard().getId(), appearance.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getFontName(),
                this.getBackgroundColor(),
                this.getBackgroundImagePath(),
                this.getPictureStretching(),
                this.getMainColor(),
                this.getSecondColor(),
                this.getGalleryType(),
                this.getCard().getId());
    }
}
