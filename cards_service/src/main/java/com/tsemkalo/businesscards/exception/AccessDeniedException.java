package com.tsemkalo.businesscards.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String object) {
        super("Access denied: " + object);
    }
}