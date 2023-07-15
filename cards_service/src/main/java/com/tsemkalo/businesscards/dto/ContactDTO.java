package com.tsemkalo.businesscards.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tsemkalo.businesscards.configuration.enums.ContactType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ContactDTO extends AbstractDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private ContactType type;
    private String content;
    private Long cardId;
}
