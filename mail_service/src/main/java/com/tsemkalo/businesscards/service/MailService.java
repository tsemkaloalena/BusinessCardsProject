package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.dto.UserDTO;
import org.apache.velocity.VelocityContext;

public interface MailService {
    void sendForgotPasswordEmail(UserDTO userDTO);
    void sendActivateAccountEmail(UserDTO userDTO);
    void sendEmail(String recipientEmail, String subject, String templateName, VelocityContext context);
}
