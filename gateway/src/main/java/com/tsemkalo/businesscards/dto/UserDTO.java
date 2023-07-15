package com.tsemkalo.businesscards.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends AbstractDTO {
    private String username;
    private String password;
    private String oldPassword; // for temporary use when changing the password
    private String name;
    private String surname;
    private RoleDTO roleDTO;
    private String email;

    public UserDTO(Long id, String username, String password, String name, String surname, RoleDTO roleDTO, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.roleDTO = roleDTO;
        this.email = email;
    }
}
