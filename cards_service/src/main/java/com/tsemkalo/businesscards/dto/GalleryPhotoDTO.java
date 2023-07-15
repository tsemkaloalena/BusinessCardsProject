package com.tsemkalo.businesscards.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class GalleryPhotoDTO extends AbstractDTO {
    private Long cardId;
    private String imgPath;
}
