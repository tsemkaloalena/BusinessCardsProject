package com.tsemkalo.businesscards.exceptions;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String object) {
        super("Incorrect data: " + object);
    }
}
