package com.tsemkalo.businesscards.dto.cards;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GalleryPhotoDTO extends AbstractDTO {
    private Long cardId;
    private String imgPath;
}
