package com.tsemkalo.businesscards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MailNotificationDTO {
    private String name;
    private String surname;
    private String email;
    private String theme;
    private String text;
}
