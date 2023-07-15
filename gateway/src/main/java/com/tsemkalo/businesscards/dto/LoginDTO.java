package com.tsemkalo.businesscards.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoginDTO extends AbstractDTO {
    private String username;
    private String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
