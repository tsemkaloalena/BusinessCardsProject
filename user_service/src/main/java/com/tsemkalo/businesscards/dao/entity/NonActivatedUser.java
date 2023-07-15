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
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final NonActivatedUser user = (NonActivatedUser) o;
        return Objects.equals(this.getId(), user.getId()) &&
                Objects.equals(this.getUsername(), user.getUsername()) &&
                Objects.equals(this.getPassword(), user.getPassword()) &&
                Objects.equals(this.getName(), user.getName()) &&
                Objects.equals(this.getSurname(), user.getSurname()) &&
                Objects.equals(this.getRole(), user.getRole()) &&
                Objects.equals(this.getEmail(), user.getEmail());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(),
                this.getUsername(),
                this.getPassword(),
                this.getName(),
                this.getSurname(),
                this.getRole(),
                this.getEmail());
    }
}