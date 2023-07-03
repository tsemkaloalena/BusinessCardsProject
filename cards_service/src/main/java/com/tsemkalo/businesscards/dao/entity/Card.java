package com.tsemkalo.businesscards.dao.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

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
}
