package com.tsemkalo.businesscards.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.dto.MailNotificationDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.exception.MailSendingException;
import com.tsemkalo.businesscards.service.MailService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Date;

import static com.tsemkalo.businesscards.configuration.constants.MailConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.constants.MailConstants.SECRET_ACTIVATE_ACCOUNT;
import static com.tsemkalo.businesscards.configuration.constants.MailConstants.SECRET_FORGOT_PASSWORD;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Override
    public void sendForgotPasswordEmail(UserDTO userDTO) {
        String resetPasswordToken = JWT.create()
                .withSubject(userDTO.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()));
        VelocityContext context = new VelocityContext();
        context.put("name", userDTO.getName());
        context.put("surname", userDTO.getSurname());
        context.put("resetPasswordToken", resetPasswordToken);
        sendEmail(userDTO.getEmail(), "Reset password", "forgot_password.vm", context);
    }

    @Override
    public void sendActivateAccountEmail(UserDTO userDTO) {
        String activateAccountToken = JWT.create()
                .withSubject(userDTO.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()));
        VelocityContext context = new VelocityContext();
        context.put("name", userDTO.getName());
        context.put("surname", userDTO.getSurname());
        context.put("activateAccountToken", activateAccountToken);
        sendEmail(userDTO.getEmail(), "Activate account", "activate_account_email.vm", context);
    }

    @Override
    public void sendNotification(MailNotificationDTO mailNotificationDTO) {
        VelocityContext context = new VelocityContext();
        context.put("name", mailNotificationDTO.getName());
        context.put("surname", mailNotificationDTO.getSurname());
        context.put("text", mailNotificationDTO.getText());
        sendEmail(mailNotificationDTO.getEmail(), mailNotificationDTO.getTheme(), "notification_email.vm", context);
    }

    @Override
    public void sendEmail(String recipientEmail, String subject, String templateName, VelocityContext context) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            message.setFrom(emailFrom);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            StringWriter stringWriter = new StringWriter();
            velocityEngine.mergeTemplate(templateName, "UTF-8", context, stringWriter);
            String text = stringWriter.toString();
            helper.setText(text, true);
            mailSender.send(message);
        } catch (Exception exception) {
            throw new MailSendingException(exception.getMessage());
        }
    }
}
