package com.tsemkalo.businesscards.dto.cards;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class LikeDTO extends AbstractDTO {
    private Long userId;
    private Long cardId;
}
