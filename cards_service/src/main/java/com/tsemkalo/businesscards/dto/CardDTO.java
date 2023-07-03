package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CardDTO extends AbstractDTO {
    private Long userId;
    private String title;
    private String logoImgPath;
    private String headline;
    private String description;
    private AppearanceDTO appearanceDTO;
    private List<GalleryPhotoDTO> photoDTOS;
    private List<ContactDTO> contactDTOS;
    private List<AddressDTO> addressDTOS;
    private int followersAmount;
    private int likesAmount;

//    public CardDTO(Long id, Long userId, String title, String logoImgPath, String headline, String description) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.logoImgPath = logoImgPath;
//        this.headline = headline;
//        this.description = description;
//    }
}
