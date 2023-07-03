package com.tsemkalo.businesscards.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String object) {
        super(object);
    }
}