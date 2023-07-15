package com.tsemkalo.businesscards.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity implements UserDetails {
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;
    private String email;

    public User(Long id, String username, String password, String name, String surname, Role role, String email) {
        this.setId(id);
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : getRole().getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getName().name()));
        }
        return authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
