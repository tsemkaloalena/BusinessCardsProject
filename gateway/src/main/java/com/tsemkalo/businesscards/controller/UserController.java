package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.Token;
import com.tsemkalo.businesscards.UserByUsernameRequest;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.configuration.QueueConstants;
import com.tsemkalo.businesscards.configuration.SecurityConstants;
import com.tsemkalo.businesscards.dto.LoginDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import io.grpc.Status;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.tsemkalo.businesscards.configuration.QueueConstants.MESSAGE_DELAY_TIME;
import static com.tsemkalo.businesscards.configuration.SecurityConstants.EXPIRATION_TIME;

@RestController
@EnableRabbit
@RequestMapping("/user")
public class UserController {
    @GrpcClient(GRPCServiceNames.UserService)
    private UserServiceGrpc.UserServiceBlockingStub userService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private UserMapper userMapper;

    /**
     * @param userDTO user data
     * @return signed up and added to database user
     */
    @PostMapping("/sign_up")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        Map<String, Object> body = new LinkedHashMap<>();
        try {
            userService.saveUser(userMapper.dtoToProto(userDTO));
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (status.getDescription() == null) {
                body.put("message", status.getCode() + ": " + status.getCause().getMessage());
            } else {
                body.put("message", status.getCode() + ": " + status.getDescription());
            }
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }


        template.convertAndSend(QueueConstants.ACTIVATE_ACCOUNT_MAIL, userDTO);

//        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setDelay(60000);
//                return message;
//            }
//        };

        MessageProperties properties = new MessageProperties();
//        properties.setHeader("x-delay", 60000);
        properties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        properties.setDelay(60000);

        Message message = MessageBuilder
                .withBody(userDTO.getUsername().getBytes())
                .andProperties(properties)
                .build();

        template.convertAndSend(QueueConstants.DELAYED_EXCHANGE_NAME, QueueConstants.DELETE_IF_NOT_ACTIVATED, message);

//        template.convertAndSend(QueueConstants.DELAYED_EXCHANGE_NAME, QueueConstants.DELETE_IF_NOT_ACTIVATED, MessageBuilder
//                .withBody(userDTO.getUsername().getBytes())
//                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
//                .setHeader(MessageProperties.X_DELAY, MESSAGE_DELAY_TIME)
//                .build()
//        );
        // TODO dlq
        // TODO delete from db if not activated in 24h
        // TODO send message to admin if error
//        Cookie cookie = new Cookie(SecurityConstants.AUTHORIZATION_COOKIE_NAME, token);
//        cookie.setMaxAge((int) SecurityConstants.EXPIRATION_TIME);
//        cookie.setHttpOnly(false);
//        cookie.setPath("/");
//        response.addCookie(cookie);

        body.put("message", "Your account is created. Now you need to activate it by the link. Soon it will be sent to your email.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping("/activate_account/{activateAccountToken}")
    public ResponseEntity<Object> activateAccount(@PathVariable String activateAccountToken) {
        Map<String, Object> body = new LinkedHashMap<>();
        String token;
        try {
            token = userService.activateAccount(Token.newBuilder().setToken(activateAccountToken).build()).getToken();
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            if (status.getDescription() == null) {
                body.put("message", "Your link is expired or incorrect");
            } else {
                body.put("message", status.getDescription());
            }
            return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
        }
        body.put("message", "Your account is successfully activated.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @RabbitListener(queues = QueueConstants.ACTIVATE_ACCOUNT_MAIL + ".dlq")
    public String sendActivateAccountMailFailed(Exception failed) {
        // TODO write to db
        System.out.println(failed.toString());
        return failed.toString();
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws IOException {
        UserProto userProto;
        Map<String, Object> body = new LinkedHashMap<>();
        try {
            userProto = userService.getUserByUsername(UserByUsernameRequest.newBuilder().setUsername(loginDTO.getUsername()).build());
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            body.put("message", status.getCode() + ": " + status.getDescription());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        String token = authorizationService.loginUser(userMapper.protoToEntity(userProto), loginDTO.getPassword());
        Cookie cookie = new Cookie(SecurityConstants.AUTHORIZATION_COOKIE_NAME, token);
        cookie.setMaxAge((int) EXPIRATION_TIME);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);
        body.put("message", "Your are logged in.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    /**
     * @param userDTO current password and new password
     * @return message about successful password change
     */
    @PostMapping("/change_password")
    public ResponseEntity<Object> changePassword(@RequestBody UserDTO userDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String newPassword;
        try {
            ChangePasswordRequest changePasswordRequest = ChangePasswordRequest.newBuilder().setCurrentUsername(authentication.getName()).setOldPassword(userDTO.getOldPassword()).setNewPassword(userDTO.getPassword()).build();
            newPassword = userService.changePassword(changePasswordRequest).getNewPassword();
        } catch (Exception exception) {
            Status status = Status.fromThrowable(exception);
            body.put("message", status.getCode() + ": " + status.getDescription());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        authorizationService.setPassword(newPassword);
        body.put("message", "Your password is successfully changed.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
}
