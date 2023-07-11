package com.tsemkalo.businesscards.exception;

public class MailSendingException extends RuntimeException {
    public MailSendingException(String message) {
        super("During sending an email an error appeared: " + message);
    }
}
