package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import com.tsemkalo.businesscards.dto.MailNotificationDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.service.MailService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@EnableRabbit
public class RequestController {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = QueueConstants.ACTIVATE_ACCOUNT_MAIL)
    public void sendActivateAccountEmail(UserDTO userDTO) {
        mailService.sendActivateAccountEmail(userDTO);
    }

    @RabbitListener(queues = QueueConstants.FORGOT_PASSWORD_MAIL)
    public void sendForgotPasswordEmail(UserDTO userDTO) {
        mailService.sendForgotPasswordEmail(userDTO);
    }

    @RabbitListener(queues = QueueConstants.SEND_NOTIFICATION)
    public void sendNotification(MailNotificationDTO mailNotificationDTO) {
        mailService.sendNotification(mailNotificationDTO);
    }

    @RabbitListener(queues = QueueConstants.REJECT_ADDING_TECH_SUPPORT_MAIL)
    public void sendRejectAddingTechSupporter(MailNotificationDTO mailNotificationDTO) {
        mailService.sendNotification(mailNotificationDTO);
    }
}
