package com.tsemkalo.businesscards.exceptions;

public class AuthenticationCredentialsReadingException extends RuntimeException {
    public AuthenticationCredentialsReadingException() {
        super("Reading your credentials was failed");
    }
}