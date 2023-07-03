package com.tsemkalo.businesscards.dto.cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tsemkalo.businesscards.configuration.enums.cards.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.cards.PictureStretchingType;
import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppearanceDTO extends AbstractDTO {
    private Long cardId;
    private String fontName;
    private String backgroundColor;
    private String backgroundImagePath;
    private PictureStretchingType pictureStretching;
    private String mainColor;
    private String secondColor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private GalleryType galleryType;
}
