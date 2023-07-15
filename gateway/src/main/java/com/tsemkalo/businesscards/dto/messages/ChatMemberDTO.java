package com.tsemkalo.businesscards.dto.messages;

import com.tsemkalo.businesscards.dto.AbstractDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChatMemberDTO extends AbstractDTO {
    private Long userId;
    private Long chatId;
    private String memberName;
    private Boolean notify;
}
