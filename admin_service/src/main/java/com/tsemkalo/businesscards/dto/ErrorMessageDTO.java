package com.tsemkalo.businesscards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessageDTO extends AbstractDTO {
    private Integer code;
    private String reason;
}
