package com.tsemkalo.businesscards.dto.cards;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AddressDTO extends AbstractDTO {
    private String address;
    private Long cardId;
    private Boolean showOnMap;
}
