package com.tsemkalo.businesscards.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.exceptions.AuthenticationCredentialsReadingException;
import com.tsemkalo.businesscards.exceptions.AuthorizationErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.tsemkalo.businesscards.configuration.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.SecurityConstants.SECRET;

@Component

public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private User currentUser;

    @Override
    public String loginUser(User user, String password) {
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            currentUser = user;
            return JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC512(SECRET.getBytes()));
        } else {
            throw new AuthorizationErrorException("Wrong password");
        }
    }

    @Override
    public void setPassword(String newPassword) {
        currentUser.setPassword(newPassword);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return currentUser;
    }
}
