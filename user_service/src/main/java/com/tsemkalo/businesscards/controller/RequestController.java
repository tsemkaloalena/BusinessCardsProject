package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.ChangePasswordResponse;
import com.tsemkalo.businesscards.EditInfoRequest;
import com.tsemkalo.businesscards.ForgotPasswordRequest;
import com.tsemkalo.businesscards.Token;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.UsernameProto;
import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import com.tsemkalo.businesscards.mapper.NonActivatedUserMapper;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@EnableRabbit
@GrpcService
public class RequestController extends UserServiceGrpc.UserServiceImplBase {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NonActivatedUserMapper nonActivatedUserMapper;

    @Autowired
    private SafeUserMapper safeUserMapper;

    @Override
    public void getUserByUsername(UsernameProto request,
                                  StreamObserver<UserProto> responseObserver) {
        User user;
        try {
            user = (User) userService.loadUserByUsername(request.getUsername());
        } catch (UsernameNotFoundException exception) {
            Status status = Status.INVALID_ARGUMENT.withDescription("Username " + request.getUsername() + " is not correct");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        UserProto response = userMapper.entityToProto(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void saveUser(UserProto request,
                         StreamObserver<Empty> responseObserver) {
        try {
            userService.saveUser(nonActivatedUserMapper.protoToEntity(request));
        } catch (UserExistsException exception) {
            Status status = Status.ALREADY_EXISTS.withDescription(exception.getMessage());
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void changePassword(ChangePasswordRequest request,
                               StreamObserver<ChangePasswordResponse> responseObserver) {
        String newPassword;
        try {
            newPassword = userService.changePassword(request);
        } catch (IncorrectDataException exception) {
            Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage());
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        ChangePasswordResponse response = ChangePasswordResponse.newBuilder().setNewPassword(newPassword).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void activateAccount(Token tokenRequest, StreamObserver<UsernameProto> responseObserver) {
        try {
            String username = userService.activateAccount(tokenRequest.getToken());
            UsernameProto usernameProto = UsernameProto.newBuilder().setUsername(username).build();
            responseObserver.onNext(usernameProto);
            responseObserver.onCompleted();
        } catch (Exception exception) {
            Status status = Status.PERMISSION_DENIED.withDescription("Your link is expired or incorrect");
            responseObserver.onError(status.asRuntimeException());
        }
    }

    @RabbitListener(queues = QueueConstants.DELETE_IF_NOT_ACTIVATED)
    public void deleteUserIfNotActivated(Message message) {
        userService.deleteUserIfNotActivated(new String(message.getBody(), StandardCharsets.UTF_8));
    }

    @Override
    public void resetPassword(ForgotPasswordRequest request, StreamObserver<ChangePasswordResponse> responseObserver) {
        try {
            String newPassword = userService.resetPassword(request.getResetPasswordToken(), request.getNewPassword());
            responseObserver.onNext(ChangePasswordResponse.newBuilder().setNewPassword(newPassword).build());
            responseObserver.onCompleted();
        } catch (IncorrectDataException exception) {
            Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage());
            responseObserver.onError(status.asRuntimeException());
        } catch (Exception exception) {
            Status status = Status.PERMISSION_DENIED.withDescription("Your link is expired or incorrect");
            responseObserver.onError(status.asRuntimeException());
        }
    }

    @Override
    public void editInfo(EditInfoRequest request, StreamObserver<Empty> responseObserver) {
        try {
            userService.editInfo(request.getCurrentUsername(), safeUserMapper.protoToDTO(request.getEditedInfo()));
        } catch (IncorrectDataException exception) {
            Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage());
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

//    @RabbitListener(queues = QueueName.SIGN_UP_USER)
//    public SafeUserDTO saveUser(UserDTO userDTO, @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key) {
//    }

//    /**
//     * @param userDto current password and new password
//     * @return message about successful password change
//     */
//    @PostMapping("/change_password")
//    public ResponseEntity<Object> changePassword(@RequestBody UserDto userDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        userService.changePassword(authentication.getName(), userDto.getOldPassword(), userDto.getPassword());
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("message",  "Your password is successfully changed.");
//        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
//    }
//
//    /**
//     * @param userDto current password and new username
//     * @return new token
//     */
//    @PostMapping("/change_username")
//    public ResponseEntity<Object> changeUsername(@RequestBody UserDto userDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("message",  userService.changeUsername(authentication.getName(), userDto.getUsername(), userDto.getPassword()));
//        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
//    }
//
//    /**
//     * @param userDto user data that should be edited (email, name or surname)
//     * @return edited user data
//     */
//    @PostMapping("/edit")
//    public PersonalAccountDto editInfo(@RequestBody UserDto userDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getById(userService.editInfo(authentication.getName(), userMapper.toEntity(userDto)));
//        return personalAccountMapper.toDto(user);
//    }
//
//    /**
//     * @return personal account info (user data)
//     */
//    @GetMapping
//    public PersonalAccountDto getPersonalInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) userService.loadUserByUsername(authentication.getName());
//        return personalAccountMapper.toDto(user);
//    }
//
//    @PostMapping("/forgot_password")
//    public ResponseEntity<Object> sendForgotPasswordEmail(@RequestParam String username) {
//        userService.sendForgotPasswordEmail(username);
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("message",  "Email for resetting your password is sent. Follow the instructions and don't lose your new password :)");
//        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
//    }
//

}
