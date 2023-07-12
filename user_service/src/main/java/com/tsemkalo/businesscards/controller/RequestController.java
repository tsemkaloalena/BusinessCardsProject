package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.generatedProtos.ChangePasswordRequest;
import com.tsemkalo.businesscards.generatedProtos.ChangePasswordResponse;
import com.tsemkalo.businesscards.generatedProtos.EditInfoRequest;
import com.tsemkalo.businesscards.generatedProtos.ForgotPasswordRequest;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProto;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProtoList;
import com.tsemkalo.businesscards.generatedProtos.Token;
import com.tsemkalo.businesscards.generatedProtos.UserIdProtoList;
import com.tsemkalo.businesscards.generatedProtos.UserProto;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.generatedProtos.UsernameProto;
import com.tsemkalo.businesscards.constants.QueueConstants;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.mapper.NonActivatedUserMapper;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.UserService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Controller
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
        user = (User) userService.loadUserByUsername(request.getUsername());
        UserProto response = userMapper.entityToProto(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getNonActivatedUserByUsername(UsernameProto request,
                                              StreamObserver<SafeUserProto> responseObserver) {
        NonActivatedUser user = userService.loadNonActivateUserByUsername(request.getUsername());
        SafeUserProto response = nonActivatedUserMapper.entityToSafeProto(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void saveUser(UserProto request,
                         StreamObserver<Empty> responseObserver) {
        userService.saveUser(nonActivatedUserMapper.protoToEntity(request));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void changePassword(ChangePasswordRequest request,
                               StreamObserver<ChangePasswordResponse> responseObserver) {
        String newPassword;
        newPassword = userService.changePassword(request.getOldPassword(), request.getNewPassword(), request.getCurrentUsername());
        ChangePasswordResponse response = ChangePasswordResponse.newBuilder().setNewPassword(newPassword).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void activateAccount(Token tokenRequest, StreamObserver<UsernameProto> responseObserver) {
        String username = userService.activateAccount(tokenRequest.getToken());
        UsernameProto usernameProto = UsernameProto.newBuilder().setUsername(username).build();
        responseObserver.onNext(usernameProto);
        responseObserver.onCompleted();
    }

    @RabbitListener(queues = QueueConstants.DELETE_IF_NOT_ACTIVATED)
    public void deleteUserIfNotActivated(Message message) {
        userService.deleteUserIfNotActivated(new String(message.getBody(), StandardCharsets.UTF_8));
    }

    @Override
    public void deleteNonActivatedAccount(UsernameProto request, StreamObserver<Empty> responseObserver) {
        userService.deleteUserIfNotActivated(request.getUsername());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void resetPassword(ForgotPasswordRequest request, StreamObserver<ChangePasswordResponse> responseObserver) {
        String newPassword = userService.resetPassword(request.getResetPasswordToken(), request.getNewPassword());
        responseObserver.onNext(ChangePasswordResponse.newBuilder().setNewPassword(newPassword).build());
        responseObserver.onCompleted();
    }

    @Override
    public void editInfo(EditInfoRequest request, StreamObserver<Empty> responseObserver) {
        userService.editInfo(request.getCurrentUsername(), safeUserMapper.protoToDTO(request.getEditedInfo()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUsersByTheirId(UserIdProtoList request, StreamObserver<SafeUserProtoList> responseObserver) {
        List<Long> userIds = request.getUserIdsList();
        List<User> users = userService.getUsersByTheirId(userIds);
        List<SafeUserProto> safeUserProtos = users.stream().map(safeUserMapper::entityToProto).collect(Collectors.toList());
        SafeUserProtoList safeUserProtoList = SafeUserProtoList.newBuilder()
                .addAllUsers(safeUserProtos)
                .build();
        responseObserver.onNext(safeUserProtoList);
        responseObserver.onCompleted();
    }
}
