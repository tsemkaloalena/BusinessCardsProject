package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDTO extends AbstractDTO {
    private Long userId;
    private Long cardId;
}
