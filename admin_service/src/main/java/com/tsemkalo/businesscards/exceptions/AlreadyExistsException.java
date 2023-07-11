package com.tsemkalo.businesscards.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String object) {
        super(object);
    }
}