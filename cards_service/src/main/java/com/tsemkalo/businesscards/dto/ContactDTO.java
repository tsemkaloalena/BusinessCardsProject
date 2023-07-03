package com.tsemkalo.businesscards.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tsemkalo.businesscards.configuration.enums.ContactType;
import com.tsemkalo.businesscards.dao.entity.Card;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Getter
@Setter
public class ContactDTO extends AbstractDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private ContactType type;
    private String content;
    private Long cardId;
}
