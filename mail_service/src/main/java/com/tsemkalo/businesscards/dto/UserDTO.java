package com.tsemkalo.businesscards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO {
    private String username;
    private String password;
    private String oldPassword; // for temporary use when changing the password
    private String name;
    private String surname;
    private Long roleId;
    private String email;

    public UserDTO(Long id, String username, String password, String name, String surname, Long roleId, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.roleId = roleId;
        this.email = email;
    }
}
