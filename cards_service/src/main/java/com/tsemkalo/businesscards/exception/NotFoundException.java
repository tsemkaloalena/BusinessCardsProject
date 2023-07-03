package com.tsemkalo.businesscards.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String object) {
        super(object + " is not found");
    }
}
