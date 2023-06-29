package com.tsemkalo.businesscards.dao.entity;

import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "nonactivated_users")
@NoArgsConstructor
@Getter
@Setter
public class NonActivatedUser extends AbstractEntity {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column
    private String email;

    public NonActivatedUser(Long id, String username, String password, String name, String surname, Role role, String email) {
        this.setId(id);
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
    }

    public void setEmail(String email) {
        if (!email.contains("@") || !email.contains(".") || email.indexOf("@") > email.lastIndexOf(".")) {
            throw new IncorrectDataException(email + " is not correct email");
        }
        this.email = email;
    }
}