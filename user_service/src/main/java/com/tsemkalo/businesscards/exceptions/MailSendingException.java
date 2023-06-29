package com.tsemkalo.businesscards.exceptions;

public class MailSendingException extends RuntimeException {
    public MailSendingException(String message) {
        super("During sending an email an error appeared: " + message);
    }
}