package com.tsemkalo.businesscards.exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String name) {
        super("User " + name + " already exists");
    }
}