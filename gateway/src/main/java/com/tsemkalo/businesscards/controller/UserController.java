package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.EditInfoRequest;
import com.tsemkalo.businesscards.ForgotPasswordRequest;
import com.tsemkalo.businesscards.configuration.constants.GRPCServiceNames;
import com.tsemkalo.businesscards.Token;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.UsernameProto;
import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import com.tsemkalo.businesscards.configuration.constants.SecurityConstants;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import com.tsemkalo.businesscards.dto.LoginDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.AuthorizationService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.tsemkalo.businesscards.configuration.constants.QueueConstants.MESSAGE_DELAY_TIME;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.COOKIE_EXPIRATION_TIME;

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

    @Autowired
    private SafeUserMapper safeUserMapper;

    /**
     * @param userDTO user data
     * @return signed up and added to database user
     */
    @PostMapping("/sign_up")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        if (RoleType.ADMIN.equals(userDTO.getRoleDTO().getName())) {
            throw new AccessDeniedException("You can not register yourself as admin");
        }
        userService.saveUser(userMapper.dtoToProto(userDTO));
        if (RoleType.TECHNICAL_SUPPORT.equals(userDTO.getRoleDTO().getName())) {
            template.convertAndSend(QueueConstants.ADD_TECH_SUPPORTER_REQUEST, userDTO);
            body.put("message", "Your request is sent to admin. Wait for reply");
        } else {
            sendActivateAccountMail(userDTO);
            body.put("message", "Your account is created. Now you need to activate it by the link. Soon it will be sent to your email.");
        }
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    private void sendActivateAccountMail(UserDTO userDTO) {
        template.convertAndSend(QueueConstants.ACTIVATE_ACCOUNT_MAIL, userDTO);

        MessageProperties properties = new MessageProperties();
        properties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        properties.setDelay(MESSAGE_DELAY_TIME);

        Message message = MessageBuilder
                .withBody(userDTO.getUsername().getBytes())
                .andProperties(properties)
                .build();

        template.convertAndSend(QueueConstants.DELAYED_EXCHANGE_NAME, QueueConstants.DELETE_IF_NOT_ACTIVATED, message);
    }

    @GetMapping("/activate_account/{activateAccountToken}")
    public ResponseEntity<Object> activateAccount(@PathVariable String activateAccountToken, HttpServletResponse response) {
        Map<String, Object> body = new LinkedHashMap<>();
        String username;
        username = userService.activateAccount(Token.newBuilder().setToken(activateAccountToken).build()).getUsername();
        String token = authorizationService.createToken(username);
        Cookie cookie = new Cookie(SecurityConstants.AUTHORIZATION_COOKIE_NAME, token);
        cookie.setMaxAge((int) SecurityConstants.COOKIE_EXPIRATION_TIME);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);

        body.put("message", "Your account is successfully activated.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @RabbitListener(queues = QueueConstants.ACTIVATE_ACCOUNT_MAIL + ".dlq")
    public String sendActivateAccountMailFailed(Exception failed) {
        if (failed.getMessage() != null && !failed.getMessage().isBlank()) {
            sendErrorToAdmin(500, failed.getMessage());
        } else if (failed.getCause() != null) {
            sendErrorToAdmin(500, failed.getCause().toString());
        } else {
            sendErrorToAdmin(500, "Could not send account activation email");
        }
        return failed.toString();
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws IOException {
        UserProto userProto;
        Map<String, Object> body = new LinkedHashMap<>();
        userProto = userService.getUserByUsername(UsernameProto.newBuilder().setUsername(loginDTO.getUsername()).build());
        String token = authorizationService.loginUser(userMapper.protoToEntity(userProto), loginDTO.getPassword());
        Cookie cookie = new Cookie(SecurityConstants.AUTHORIZATION_COOKIE_NAME, token);
        cookie.setMaxAge((int) COOKIE_EXPIRATION_TIME);
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
        ChangePasswordRequest changePasswordRequest = ChangePasswordRequest.newBuilder().setCurrentUsername(authentication.getName()).setOldPassword(userDTO.getOldPassword()).setNewPassword(userDTO.getPassword()).build();
        userService.changePassword(changePasswordRequest).getNewPassword();
        body.put("message", "Your password is successfully changed.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping("/forgot_password")
    public ResponseEntity<Object> sendForgotPasswordEmail(@RequestParam String username) {
        template.convertAndSend(QueueConstants.FORGOT_PASSWORD_MAIL, username);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Email for resetting your password will be sent. Follow the instructions and don't lose your new password :)");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @PostMapping("/reset_password/{resetPasswordToken}")
    public ResponseEntity<Object> resetPassword(@PathVariable String resetPasswordToken, @RequestParam String newPassword) {
        Map<String, Object> body = new LinkedHashMap<>();
        ForgotPasswordRequest request = ForgotPasswordRequest.newBuilder().setResetPasswordToken(resetPasswordToken).setNewPassword(newPassword).build();
        newPassword = userService.resetPassword(request).getNewPassword();
        body.put("message", "Your password is successfully changed.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    @RabbitListener(queues = QueueConstants.FORGOT_PASSWORD_MAIL + ".dlq")
    public String sendForgotPasswordMailFailed(Exception failed) {
        if (failed.getMessage() != null && !failed.getMessage().isBlank()) {
            sendErrorToAdmin(500, failed.getMessage());
        } else if (failed.getCause() != null) {
            sendErrorToAdmin(500, failed.getCause().toString());
        } else {
            sendErrorToAdmin(500, "Could not send email with resetting password link");
        }
        return failed.toString();
    }

    @PostMapping("/edit")
    public ResponseEntity<Object> editInfo(@RequestBody SafeUserDTO safeUserDTO) {
        Map<String, Object> body = new LinkedHashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EditInfoRequest request = EditInfoRequest.newBuilder().setCurrentUsername(authentication.getName())
                .setEditedInfo(safeUserMapper.dtoToProto(safeUserDTO)).build();
        userService.editInfo(request);
        body.put("message", "Your info is successfully edited.");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    private void sendErrorToAdmin(Integer code, String text) {
        template.convertAndSend(QueueConstants.SEND_ERROR_TO_ADMIN, new ErrorMessageDTO(code, text));
    }
}
