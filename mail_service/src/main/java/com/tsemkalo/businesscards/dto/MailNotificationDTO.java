package com.tsemkalo.businesscards.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MailNotificationDTO extends AbstractDTO {
    private String name;
    private String surname;
    private String email;
    private String theme;
    private String text;
}
