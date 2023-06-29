//package com.tsemkalo.businesscards.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@NoArgsConstructor
//@Getter
//@Setter
//public class NonActivatedUser extends AbstractEntity {
//    private String username;
//    private String password;
//    private String name;
//    private String surname;
//    private Role role;
//    private String email;
//
//    // TODO заменить на RequiredArgsConstructor
//    public NonActivatedUser(Long id, String username, String password, String name, String surname, Role role, String email) {
//        this.setId(id);
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.surname = surname;
//        this.role = role;
//        this.email = email;
//    }
//}
