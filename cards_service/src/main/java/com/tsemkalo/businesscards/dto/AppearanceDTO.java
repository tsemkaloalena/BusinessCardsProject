package com.tsemkalo.businesscards.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tsemkalo.businesscards.configuration.enums.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.PictureStretchingType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AppearanceDTO extends AbstractDTO {
    private Long cardId;
    private String fontName;
    private String backgroundColor;
    private String backgroundImagePath;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private PictureStretchingType pictureStretching;

    private String mainColor;
    private String secondColor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private GalleryType galleryType;
}
