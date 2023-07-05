package com.tsemkalo.businesscards.dto.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MailNotificationDTO {
    private String name;
    private String surname;
    private String email;
    private String theme;
    private String text;
}
