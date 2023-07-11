package com.tsemkalo.businesscards.configuration.filters;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.configuration.constants.SecurityConstants;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.exceptions.AuthorizationErrorException;
import com.tsemkalo.businesscards.service.impl.AuthorizationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private final AuthorizationServiceImpl authorizationService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, AuthorizationServiceImpl authorizationService) {
        super(authenticationManager);
        this.authorizationService = authorizationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SecurityConstants.AUTHORIZATION_COOKIE_NAME)) {
                    token = cookie.getValue();
                }
            }
        }

        if (token == null) {
            try {
                chain.doFilter(request, response);
            } catch (IOException | ServletException exception) {
                log.error(Arrays.toString(exception.getStackTrace()));
                throw new AuthorizationErrorException(Arrays.toString(exception.getStackTrace()));
            }
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException exception) {
            log.error(Arrays.toString(exception.getStackTrace()));
            throw new AuthorizationErrorException(Arrays.toString(exception.getStackTrace()));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SecurityConstants.AUTHORIZATION_COOKIE_NAME)) {
                    token = cookie.getValue();
                }
            }
        }
        if (token != null) {
            String username = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            if (username != null) {
                User user = authorizationService.loadUserByUsername(username);
                return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
            }
            return null;
        }
        return null;
    }
}
