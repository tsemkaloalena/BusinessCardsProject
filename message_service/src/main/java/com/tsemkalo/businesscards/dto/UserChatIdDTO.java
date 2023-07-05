package com.tsemkalo.businesscards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserChatIdDTO {
    private Long userId;
    private Long chatId;
}
