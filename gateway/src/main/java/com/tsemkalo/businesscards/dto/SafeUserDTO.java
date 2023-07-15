package com.tsemkalo.businesscards.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SafeUserDTO extends AbstractDTO {
    private String username;
    private String name;
    private String surname;
    private RoleDTO roleDTO;
    private String email;

    public SafeUserDTO(Long id, String username, String name, String surname, RoleDTO roleDTO, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.roleDTO = roleDTO;
        this.email = email;
    }
}
