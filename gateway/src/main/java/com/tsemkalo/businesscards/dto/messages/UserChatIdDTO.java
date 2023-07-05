package com.tsemkalo.businesscards.dto.messages;

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