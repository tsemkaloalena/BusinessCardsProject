package com.tsemkalo.businesscards.exceptions;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String object) {
        super(object);
    }
}