package com.tsemkalo.businesscards.dto.cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tsemkalo.businesscards.configuration.enums.cards.ContactType;
import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO extends AbstractDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private ContactType type;
    private String content;
    private Long cardId;
}
