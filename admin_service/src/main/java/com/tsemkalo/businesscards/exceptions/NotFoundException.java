package com.tsemkalo.businesscards.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String object) {
        super(object);
    }
}
