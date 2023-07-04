package com.tsemkalo.businesscards.exception;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String object) {
        super(object);
    }
}
