package com.tsemkalo.businesscards.exceptions;

public class LinkExpiredException extends RuntimeException {
    public LinkExpiredException() {
        super("Your link is expired or incorrect");
    }
}
