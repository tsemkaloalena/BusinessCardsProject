package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddSupporterRequestDTO extends AbstractDTO {
    private String username;
}
