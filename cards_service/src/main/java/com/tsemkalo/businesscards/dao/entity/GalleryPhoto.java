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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final GalleryPhoto galleryPhoto = (GalleryPhoto) o;
        return Objects.equals(this.getId(), galleryPhoto.getId()) &&
                Objects.equals(this.getImgPath(), galleryPhoto.getImgPath()) &&
                Objects.equals(this.getCard().getId(), galleryPhoto.getCard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getImgPath(), this.getCard().getId());
    }
}
