package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO extends AbstractDTO {
    private String address;
    private Long cardId;
    private Boolean showOnMap;
}
