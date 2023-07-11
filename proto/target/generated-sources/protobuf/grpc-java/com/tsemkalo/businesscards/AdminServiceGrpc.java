package com.tsemkalo.businesscards;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: AdminService.proto")
public final class AdminServiceGrpc {

  private AdminServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tsemkalo.businesscards.AdminService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.tsemkalo.businesscards.AddSupporterRequestProtoList> METHOD_GET_ADD_SUPPORTER_REQUESTS =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.tsemkalo.businesscards.AddSupporterRequestProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.AdminService", "getAddSupporterRequests"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.AddSupporterRequestProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.tsemkalo.businesscards.ErrorMessageProtoList> METHOD_GER_ERROR_MESSAGES =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.tsemkalo.businesscards.ErrorMessageProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.AdminService", "gerErrorMessages"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ErrorMessageProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.AddSupporterReplyProto,
      com.google.protobuf.Empty> METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.AddSupporterReplyProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.AdminService", "deleteAddTechSupportRequest"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.AddSupporterReplyProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminServiceStub newStub(io.grpc.Channel channel) {
    return new AdminServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdminServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdminServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AdminServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAddSupporterRequests(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.AddSupporterRequestProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ADD_SUPPORTER_REQUESTS, responseObserver);
    }

    /**
     */
    public void gerErrorMessages(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ErrorMessageProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GER_ERROR_MESSAGES, responseObserver);
    }

    /**
     */
    public void deleteAddTechSupportRequest(com.tsemkalo.businesscards.AddSupporterReplyProto request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ADD_SUPPORTER_REQUESTS,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.tsemkalo.businesscards.AddSupporterRequestProtoList>(
                  this, METHODID_GET_ADD_SUPPORTER_REQUESTS)))
          .addMethod(
            METHOD_GER_ERROR_MESSAGES,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.tsemkalo.businesscards.ErrorMessageProtoList>(
                  this, METHODID_GER_ERROR_MESSAGES)))
          .addMethod(
            METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.AddSupporterReplyProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ADD_TECH_SUPPORT_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class AdminServiceStub extends io.grpc.stub.AbstractStub<AdminServiceStub> {
    private AdminServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAddSupporterRequests(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.AddSupporterRequestProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ADD_SUPPORTER_REQUESTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void gerErrorMessages(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ErrorMessageProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GER_ERROR_MESSAGES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAddTechSupportRequest(com.tsemkalo.businesscards.AddSupporterReplyProto request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdminServiceBlockingStub extends io.grpc.stub.AbstractStub<AdminServiceBlockingStub> {
    private AdminServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProtoList getAddSupporterRequests(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ADD_SUPPORTER_REQUESTS, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ErrorMessageProtoList gerErrorMessages(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GER_ERROR_MESSAGES, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteAddTechSupportRequest(com.tsemkalo.businesscards.AddSupporterReplyProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdminServiceFutureStub extends io.grpc.stub.AbstractStub<AdminServiceFutureStub> {
    private AdminServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.AddSupporterRequestProtoList> getAddSupporterRequests(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ADD_SUPPORTER_REQUESTS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ErrorMessageProtoList> gerErrorMessages(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GER_ERROR_MESSAGES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAddTechSupportRequest(
        com.tsemkalo.businesscards.AddSupporterReplyProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ADD_SUPPORTER_REQUESTS = 0;
  private static final int METHODID_GER_ERROR_MESSAGES = 1;
  private static final int METHODID_DELETE_ADD_TECH_SUPPORT_REQUEST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ADD_SUPPORTER_REQUESTS:
          serviceImpl.getAddSupporterRequests((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.AddSupporterRequestProtoList>) responseObserver);
          break;
        case METHODID_GER_ERROR_MESSAGES:
          serviceImpl.gerErrorMessages((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ErrorMessageProtoList>) responseObserver);
          break;
        case METHODID_DELETE_ADD_TECH_SUPPORT_REQUEST:
          serviceImpl.deleteAddTechSupportRequest((com.tsemkalo.businesscards.AddSupporterReplyProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AdminServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.tsemkalo.businesscards.AdminServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminServiceDescriptorSupplier())
              .addMethod(METHOD_GET_ADD_SUPPORTER_REQUESTS)
              .addMethod(METHOD_GER_ERROR_MESSAGES)
              .addMethod(METHOD_DELETE_ADD_TECH_SUPPORT_REQUEST)
              .build();
        }
      }
    }
    return result;
  }
}
