package com.tsemkalo.businesscards.dto.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserChatIdDTO {
    private Long userId;
    private Long chatId;
}