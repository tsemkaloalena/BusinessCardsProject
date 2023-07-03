package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GalleryPhotoDTO extends AbstractDTO {
    private Long cardId;
    private String imgPath;
}
