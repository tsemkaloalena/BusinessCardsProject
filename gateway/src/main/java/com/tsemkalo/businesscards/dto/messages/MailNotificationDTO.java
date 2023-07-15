package com.tsemkalo.businesscards.dto.messages;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class MailNotificationDTO extends AbstractDTO {
    private String name;
    private String surname;
    private String email;
    private String theme;
    private String text;
}
