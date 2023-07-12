package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.generatedProtos.AddSupporterReplyProto;
import com.tsemkalo.businesscards.generatedProtos.AddSupporterRequestProto;
import com.tsemkalo.businesscards.AdminServiceGrpc;
import com.tsemkalo.businesscards.generatedProtos.ErrorMessageProto;
import com.tsemkalo.businesscards.constants.GRPCServiceNames;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProto;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.generatedProtos.UsernameProto;
import com.tsemkalo.businesscards.constants.QueueConstants;
import com.tsemkalo.businesscards.dto.AddSupporterRequestDTO;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.dto.messages.MailNotificationDTO;
import com.tsemkalo.businesscards.mapper.AddSupporterRequestMapper;
import com.tsemkalo.businesscards.mapper.ErrorMessageMapper;
import com.tsemkalo.businesscards.mapper.SafeUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tsemkalo.businesscards.configuration.constants.PermissionsForController.CONTROL_SUPPORT;
import static com.tsemkalo.businesscards.constants.QueueConstants.MESSAGE_DELAY_TIME;

@RestController
@EnableRabbit
@RequestMapping("/admin")
public class AdminController {
    @GrpcClient(GRPCServiceNames.UserService)
    private UserServiceGrpc.UserServiceBlockingStub userService;

    @GrpcClient(GRPCServiceNames.AdminService)
    private AdminServiceGrpc.AdminServiceBlockingStub adminService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SafeUserMapper safeUserMapper;

    @Autowired
    private AddSupporterRequestMapper addSupporterRequestMapper;

    @Autowired
    private ErrorMessageMapper errorMessageMapper;

    @PreAuthorize(CONTROL_SUPPORT)
    @GetMapping("/support/requests")
    public List<AddSupporterRequestDTO> getAddSupporterRequests() {
        List<AddSupporterRequestProto> protoList = adminService.getAddSupporterRequests(Empty.newBuilder().build()).getRequestsList();
        return protoList.stream().map(addSupporterRequestMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CONTROL_SUPPORT)
    @GetMapping("/errors")
    public List<ErrorMessageDTO> gerErrorMessages() {
        List<ErrorMessageProto> protoList = adminService.gerErrorMessages(Empty.newBuilder().build()).getErrorProtosList();
        return protoList.stream().map(errorMessageMapper::protoToDTO).collect(Collectors.toList());
    }

    @PreAuthorize(CONTROL_SUPPORT)
    @PostMapping("/support/request/{supporterUsername}/approve")
    public ResponseEntity<Object> approveTechnicalSupport(@PathVariable String supporterUsername, @RequestParam Boolean approve, @RequestParam String reason) {
        Map<String, Object> body = new LinkedHashMap<>();
        UsernameProto usernameProto = UsernameProto.newBuilder().setUsername(supporterUsername).build();
        SafeUserProto userProto = userService.getNonActivatedUserByUsername(usernameProto);
        SafeUserDTO userDTO = safeUserMapper.protoToDTO(userProto);
        if (approve) {
            sendActivateAccountMail(userDTO);
            body.put("message", "You approved adding " + supporterUsername);
        } else {
            String theme = "Tech support employee registration application rejected";
            MailNotificationDTO mailNotificationDTO = new MailNotificationDTO(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(), theme, reason);
            template.convertAndSend(QueueConstants.REJECT_ADDING_TECH_SUPPORT_MAIL, mailNotificationDTO);
            body.put("message", "You rejected adding " + supporterUsername);
            userService.deleteNonActivatedAccount(usernameProto);
        }
        AddSupporterReplyProto replyProto = AddSupporterReplyProto.newBuilder()
                .setUsername(supporterUsername)
                .build();
        adminService.deleteAddTechSupportRequest(replyProto);

        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }

    private void sendActivateAccountMail(SafeUserDTO userDTO) {
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
}
