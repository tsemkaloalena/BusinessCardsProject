package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.generatedProtos.AddSupporterReplyProto;
import com.tsemkalo.businesscards.generatedProtos.AddSupporterRequestProto;
import com.tsemkalo.businesscards.generatedProtos.AddSupporterRequestProtoList;
import com.tsemkalo.businesscards.AdminServiceGrpc;
import com.tsemkalo.businesscards.generatedProtos.ErrorMessageProto;
import com.tsemkalo.businesscards.generatedProtos.ErrorMessageProtoList;
import com.tsemkalo.businesscards.constants.QueueConstants;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.mappers.AddSupporterRequestMapper;
import com.tsemkalo.businesscards.mappers.ErrorMessageMapper;
import com.tsemkalo.businesscards.services.AdminService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@EnableRabbit
@GrpcService
public class RequestController extends AdminServiceGrpc.AdminServiceImplBase {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AddSupporterRequestMapper addSupporterRequestMapper;

    @Autowired
    private ErrorMessageMapper errorMessageMapper;

    @RabbitListener(queues = QueueConstants.ADD_TECH_SUPPORTER_REQUEST)
    public void addTechSupportRequest(SafeUserDTO userDTO) {
        adminService.addTechSupportRequest(userDTO.getUsername());
    }

    @RabbitListener(queues = QueueConstants.SEND_ERROR_TO_ADMIN)
    public void saveErrorMessage(ErrorMessageDTO errorMessageDTO) {
        ErrorMessage errorMessage = errorMessageMapper.dtoToEntity(errorMessageDTO);
        adminService.saveErrorMessage(errorMessage);
    }

    @Override
    public void getAddSupporterRequests(Empty request, StreamObserver<AddSupporterRequestProtoList> responseObserver) {
        List<AddSupporterRequestProto> requests = adminService.getAddSupporterRequests().stream().map(addSupporterRequestMapper::entityToProto).collect(Collectors.toList());
        AddSupporterRequestProtoList protoList = AddSupporterRequestProtoList.newBuilder()
                .addAllRequests(requests)
                .build();
        responseObserver.onNext(protoList);
        responseObserver.onCompleted();
    }

    @Override
    public void gerErrorMessages(Empty request, StreamObserver<ErrorMessageProtoList> responseObserver) {
        List<ErrorMessageProto> protos = adminService.gerErrorMessages().stream().map(errorMessageMapper::entityToProto).collect(Collectors.toList());
        ErrorMessageProtoList protoList = ErrorMessageProtoList.newBuilder()
                .addAllErrorProtos(protos)
                .build();
        responseObserver.onNext(protoList);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteAddTechSupportRequest(AddSupporterReplyProto request, StreamObserver<Empty> responseObserver) {
        adminService.deleteAddTechSupportRequest(request.getUsername());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
