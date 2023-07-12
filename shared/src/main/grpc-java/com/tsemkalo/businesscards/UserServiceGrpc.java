package com.tsemkalo.businesscards;

import com.tsemkalo.businesscards.generatedProtos.ChangePasswordRequest;
import com.tsemkalo.businesscards.generatedProtos.ChangePasswordResponse;
import com.tsemkalo.businesscards.generatedProtos.EditInfoRequest;
import com.tsemkalo.businesscards.generatedProtos.ForgotPasswordRequest;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProto;
import com.tsemkalo.businesscards.generatedProtos.SafeUserProtoList;
import com.tsemkalo.businesscards.generatedProtos.Token;
import com.tsemkalo.businesscards.generatedProtos.UserIdProtoList;
import com.tsemkalo.businesscards.generatedProtos.UserProto;
import com.tsemkalo.businesscards.generatedProtos.UserServiceOuterClass;
import com.tsemkalo.businesscards.generatedProtos.UsernameProto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: UserService.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tsemkalo.businesscards.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UsernameProto,
          UserProto> METHOD_GET_USER_BY_USERNAME =
      io.grpc.MethodDescriptor.<UsernameProto, UserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "getUserByUsername"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UsernameProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UsernameProto,
          SafeUserProto> METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME =
      io.grpc.MethodDescriptor.<UsernameProto, SafeUserProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "getNonActivatedUserByUsername"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UsernameProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SafeUserProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UsernameProto,
      com.google.protobuf.Empty> METHOD_DELETE_NON_ACTIVATED_ACCOUNT =
      io.grpc.MethodDescriptor.<UsernameProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "deleteNonActivatedAccount"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UsernameProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserProto,
      com.google.protobuf.Empty> METHOD_SAVE_USER =
      io.grpc.MethodDescriptor.<UserProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "saveUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChangePasswordRequest,
          ChangePasswordResponse> METHOD_CHANGE_PASSWORD =
      io.grpc.MethodDescriptor.<ChangePasswordRequest, ChangePasswordResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "changePassword"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangePasswordRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangePasswordResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Token,
          UsernameProto> METHOD_ACTIVATE_ACCOUNT =
      io.grpc.MethodDescriptor.<Token, UsernameProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "activateAccount"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Token.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UsernameProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ForgotPasswordRequest,
          ChangePasswordResponse> METHOD_RESET_PASSWORD =
      io.grpc.MethodDescriptor.<ForgotPasswordRequest, ChangePasswordResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "resetPassword"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ForgotPasswordRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangePasswordResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditInfoRequest,
      com.google.protobuf.Empty> METHOD_EDIT_INFO =
      io.grpc.MethodDescriptor.<EditInfoRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "editInfo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditInfoRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserIdProtoList,
          SafeUserProtoList> METHOD_GET_USERS_BY_THEIR_ID =
      io.grpc.MethodDescriptor.<UserIdProtoList, SafeUserProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.UserService", "getUsersByTheirId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserIdProtoList.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SafeUserProtoList.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserByUsername(UsernameProto request,
                                  io.grpc.stub.StreamObserver<UserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_BY_USERNAME, responseObserver);
    }

    /**
     */
    public void getNonActivatedUserByUsername(UsernameProto request,
                                              io.grpc.stub.StreamObserver<SafeUserProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME, responseObserver);
    }

    /**
     */
    public void deleteNonActivatedAccount(UsernameProto request,
                                          io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_NON_ACTIVATED_ACCOUNT, responseObserver);
    }

    /**
     */
    public void saveUser(UserProto request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE_USER, responseObserver);
    }

    /**
     */
    public void changePassword(ChangePasswordRequest request,
                               io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_PASSWORD, responseObserver);
    }

    /**
     */
    public void activateAccount(Token request,
                                io.grpc.stub.StreamObserver<UsernameProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACTIVATE_ACCOUNT, responseObserver);
    }

    /**
     */
    public void resetPassword(ForgotPasswordRequest request,
                              io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RESET_PASSWORD, responseObserver);
    }

    /**
     */
    public void editInfo(EditInfoRequest request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_INFO, responseObserver);
    }

    /**
     */
    public void getUsersByTheirId(UserIdProtoList request,
                                  io.grpc.stub.StreamObserver<SafeUserProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USERS_BY_THEIR_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_BY_USERNAME,
            asyncUnaryCall(
              new MethodHandlers<
                      UsernameProto,
                      UserProto>(
                  this, METHODID_GET_USER_BY_USERNAME)))
          .addMethod(
            METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME,
            asyncUnaryCall(
              new MethodHandlers<
                      UsernameProto,
                      SafeUserProto>(
                  this, METHODID_GET_NON_ACTIVATED_USER_BY_USERNAME)))
          .addMethod(
            METHOD_DELETE_NON_ACTIVATED_ACCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                      UsernameProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NON_ACTIVATED_ACCOUNT)))
          .addMethod(
            METHOD_SAVE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                      UserProto,
                com.google.protobuf.Empty>(
                  this, METHODID_SAVE_USER)))
          .addMethod(
            METHOD_CHANGE_PASSWORD,
            asyncUnaryCall(
              new MethodHandlers<
                      ChangePasswordRequest,
                      ChangePasswordResponse>(
                  this, METHODID_CHANGE_PASSWORD)))
          .addMethod(
            METHOD_ACTIVATE_ACCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                      Token,
                      UsernameProto>(
                  this, METHODID_ACTIVATE_ACCOUNT)))
          .addMethod(
            METHOD_RESET_PASSWORD,
            asyncUnaryCall(
              new MethodHandlers<
                      ForgotPasswordRequest,
                      ChangePasswordResponse>(
                  this, METHODID_RESET_PASSWORD)))
          .addMethod(
            METHOD_EDIT_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                      EditInfoRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_INFO)))
          .addMethod(
            METHOD_GET_USERS_BY_THEIR_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      UserIdProtoList,
                      SafeUserProtoList>(
                  this, METHODID_GET_USERS_BY_THEIR_ID)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserByUsername(UsernameProto request,
                                  io.grpc.stub.StreamObserver<UserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_BY_USERNAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNonActivatedUserByUsername(UsernameProto request,
                                              io.grpc.stub.StreamObserver<SafeUserProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteNonActivatedAccount(UsernameProto request,
                                          io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_NON_ACTIVATED_ACCOUNT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveUser(UserProto request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changePassword(ChangePasswordRequest request,
                               io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PASSWORD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void activateAccount(Token request,
                                io.grpc.stub.StreamObserver<UsernameProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACTIVATE_ACCOUNT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resetPassword(ForgotPasswordRequest request,
                              io.grpc.stub.StreamObserver<ChangePasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RESET_PASSWORD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editInfo(EditInfoRequest request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsersByTheirId(UserIdProtoList request,
                                  io.grpc.stub.StreamObserver<SafeUserProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USERS_BY_THEIR_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public UserProto getUserByUsername(UsernameProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_BY_USERNAME, getCallOptions(), request);
    }

    /**
     */
    public SafeUserProto getNonActivatedUserByUsername(UsernameProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteNonActivatedAccount(UsernameProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_NON_ACTIVATED_ACCOUNT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty saveUser(UserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE_USER, getCallOptions(), request);
    }

    /**
     */
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_PASSWORD, getCallOptions(), request);
    }

    /**
     */
    public UsernameProto activateAccount(Token request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACTIVATE_ACCOUNT, getCallOptions(), request);
    }

    /**
     */
    public ChangePasswordResponse resetPassword(ForgotPasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_RESET_PASSWORD, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editInfo(EditInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_INFO, getCallOptions(), request);
    }

    /**
     */
    public SafeUserProtoList getUsersByTheirId(UserIdProtoList request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USERS_BY_THEIR_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UserProto> getUserByUsername(
        UsernameProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_BY_USERNAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SafeUserProto> getNonActivatedUserByUsername(
        UsernameProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNonActivatedAccount(
        UsernameProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_NON_ACTIVATED_ACCOUNT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> saveUser(
        UserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChangePasswordResponse> changePassword(
        ChangePasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_PASSWORD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<UsernameProto> activateAccount(
        Token request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACTIVATE_ACCOUNT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChangePasswordResponse> resetPassword(
        ForgotPasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_RESET_PASSWORD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editInfo(
        EditInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SafeUserProtoList> getUsersByTheirId(
        UserIdProtoList request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USERS_BY_THEIR_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_BY_USERNAME = 0;
  private static final int METHODID_GET_NON_ACTIVATED_USER_BY_USERNAME = 1;
  private static final int METHODID_DELETE_NON_ACTIVATED_ACCOUNT = 2;
  private static final int METHODID_SAVE_USER = 3;
  private static final int METHODID_CHANGE_PASSWORD = 4;
  private static final int METHODID_ACTIVATE_ACCOUNT = 5;
  private static final int METHODID_RESET_PASSWORD = 6;
  private static final int METHODID_EDIT_INFO = 7;
  private static final int METHODID_GET_USERS_BY_THEIR_ID = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_BY_USERNAME:
          serviceImpl.getUserByUsername((UsernameProto) request,
              (io.grpc.stub.StreamObserver<UserProto>) responseObserver);
          break;
        case METHODID_GET_NON_ACTIVATED_USER_BY_USERNAME:
          serviceImpl.getNonActivatedUserByUsername((UsernameProto) request,
              (io.grpc.stub.StreamObserver<SafeUserProto>) responseObserver);
          break;
        case METHODID_DELETE_NON_ACTIVATED_ACCOUNT:
          serviceImpl.deleteNonActivatedAccount((UsernameProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SAVE_USER:
          serviceImpl.saveUser((UserProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHANGE_PASSWORD:
          serviceImpl.changePassword((ChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<ChangePasswordResponse>) responseObserver);
          break;
        case METHODID_ACTIVATE_ACCOUNT:
          serviceImpl.activateAccount((Token) request,
              (io.grpc.stub.StreamObserver<UsernameProto>) responseObserver);
          break;
        case METHODID_RESET_PASSWORD:
          serviceImpl.resetPassword((ForgotPasswordRequest) request,
              (io.grpc.stub.StreamObserver<ChangePasswordResponse>) responseObserver);
          break;
        case METHODID_EDIT_INFO:
          serviceImpl.editInfo((EditInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_USERS_BY_THEIR_ID:
          serviceImpl.getUsersByTheirId((UserIdProtoList) request,
              (io.grpc.stub.StreamObserver<SafeUserProtoList>) responseObserver);
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

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return UserServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
              .addMethod(METHOD_GET_USER_BY_USERNAME)
              .addMethod(METHOD_GET_NON_ACTIVATED_USER_BY_USERNAME)
              .addMethod(METHOD_DELETE_NON_ACTIVATED_ACCOUNT)
              .addMethod(METHOD_SAVE_USER)
              .addMethod(METHOD_CHANGE_PASSWORD)
              .addMethod(METHOD_ACTIVATE_ACCOUNT)
              .addMethod(METHOD_RESET_PASSWORD)
              .addMethod(METHOD_EDIT_INFO)
              .addMethod(METHOD_GET_USERS_BY_THEIR_ID)
              .build();
        }
      }
    }
    return result;
  }
}
