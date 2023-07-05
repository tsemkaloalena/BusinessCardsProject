package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMemberDTO extends AbstractDTO {
    private Long userId;
    private Long chatId;
    private String memberName;
    private Boolean notify;
}
