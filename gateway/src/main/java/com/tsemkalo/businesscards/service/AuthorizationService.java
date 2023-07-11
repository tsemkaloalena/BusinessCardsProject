package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizationService extends UserDetailsService {

    String loginUser(User user, String password);

    String createToken(String username);
}
