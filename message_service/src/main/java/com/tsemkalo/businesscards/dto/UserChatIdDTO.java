package com.tsemkalo.businesscards.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class UserChatIdDTO extends AbstractDTO {
    private Long userId;
    private Long chatId;
}
