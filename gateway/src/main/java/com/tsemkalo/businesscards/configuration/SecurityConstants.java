package com.tsemkalo.businesscards.configuration;

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    public static final String SECRET_FORGOT_PASSWORD = "FORGOT_PASSWORD_KEY";
    public static final long EXPIRATION_TIME = 1000L * 60L * 60L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORIZATION_COOKIE_NAME = "Authorization";
}
