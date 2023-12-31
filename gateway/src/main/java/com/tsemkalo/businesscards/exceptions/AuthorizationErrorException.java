package com.tsemkalo.businesscards.exceptions;

public class AuthorizationErrorException extends RuntimeException {
    public AuthorizationErrorException(String message) {
        super("During authorization an error was caught: " + message);
    }
}
