package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@Getter
@Setter
public class Card extends AbstractEntity {
    @NotNull
    @Column
    private Long userId;

    @NotNull
    @Column
    private String title;

    @Column
    private String logoImgPath;

    @Column
    private String headline;

    @Column
    private String description;

    @OneToOne(mappedBy = "card", cascade = CascadeType.REMOVE)
    private Appearance appearance;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private List<GalleryPhoto> photos;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private List<Address> addresses;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private List<Follow> follows;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private List<Like> likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Card card = (Card) o;
        return Objects.equals(this.getId(), card.getId()) &&
                Objects.equals(this.getUserId(), card.getUserId()) &&
                Objects.equals(this.getTitle(), card.getTitle()) &&
                Objects.equals(this.getLogoImgPath(), card.getLogoImgPath()) &&
                Objects.equals(this.getHeadline(), card.getHeadline()) &&
                Objects.equals(this.getDescription(), card.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getUserId(),
                this.getTitle(),
                this.getLogoImgPath(),
                this.getHeadline(),
                this.getDescription());
    }
}
