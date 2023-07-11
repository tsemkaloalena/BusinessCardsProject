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
    comments = "Source: MessageService.proto")
public final class MessageServiceGrpc {

  private MessageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tsemkalo.businesscards.MessageService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.IdMessageServiceValue,
      com.tsemkalo.businesscards.ChatProtoList> METHOD_GET_USER_CHATS =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.IdMessageServiceValue, com.tsemkalo.businesscards.ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getUserChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.IdMessageServiceValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.ChatUserProto,
      com.tsemkalo.businesscards.MessageProtoList> METHOD_GET_CHAT_MESSAGES =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.ChatUserProto, com.tsemkalo.businesscards.MessageProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getChatMessages"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.MessageProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.ChatUserProto,
      com.tsemkalo.businesscards.ChatUserIdList> METHOD_GET_CHAT_USERS_IDS =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.ChatUserProto, com.tsemkalo.businesscards.ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getChatUsersIds"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.ChangeNameRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_MEMBER_NAME =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.ChangeNameRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeMemberName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChangeNameRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.ChangeNameRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_CHAT_NAME =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.ChangeNameRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeChatName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChangeNameRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.SendMessageToChatRequest,
      com.tsemkalo.businesscards.ChatUserIdList> METHOD_SEND_MESSAGE_TO_CHAT =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.SendMessageToChatRequest, com.tsemkalo.businesscards.ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendMessageToChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.SendMessageToChatRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.SendMessageToUserRequest,
      com.tsemkalo.businesscards.IdMessageServiceValue> METHOD_SEND_MESSAGE_TO_USER =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.SendMessageToUserRequest, com.tsemkalo.businesscards.IdMessageServiceValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendMessageToUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.SendMessageToUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.IdMessageServiceValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.InviteMemberRequest,
      com.tsemkalo.businesscards.IdMessageServiceValue> METHOD_INVITE_MEMBER_TO_CHAT =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.InviteMemberRequest, com.tsemkalo.businesscards.IdMessageServiceValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "inviteMemberToChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.InviteMemberRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.IdMessageServiceValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.SendMessageToSupportRequest,
      com.google.protobuf.Empty> METHOD_SEND_TO_SUPPORT =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.SendMessageToSupportRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendToSupport"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.SendMessageToSupportRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.tsemkalo.businesscards.ChatProtoList> METHOD_GET_UNASSIGNED_SUPPORT_CHATS =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.tsemkalo.businesscards.ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getUnassignedSupportChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.AssignSupportChatRequest,
      com.google.protobuf.Empty> METHOD_ASSIGN_SUPPORT_CHAT =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.AssignSupportChatRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "assignSupportChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.AssignSupportChatRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.CloseQuestionRequest,
      com.tsemkalo.businesscards.ChatUserIdList> METHOD_CLOSE_QUESTION =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.CloseQuestionRequest, com.tsemkalo.businesscards.ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "closeQuestion"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.CloseQuestionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.IdMessageServiceValue,
      com.tsemkalo.businesscards.ChatProtoList> METHOD_GET_SUPPORT_CHATS =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.IdMessageServiceValue, com.tsemkalo.businesscards.ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getSupportChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.IdMessageServiceValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tsemkalo.businesscards.ChangeSendingNotificationsRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_SENDING_NOTIFICATIONS =
      io.grpc.MethodDescriptor.<com.tsemkalo.businesscards.ChangeSendingNotificationsRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeSendingNotifications"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tsemkalo.businesscards.ChangeSendingNotificationsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageServiceStub newStub(io.grpc.Channel channel) {
    return new MessageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MessageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserChats(com.tsemkalo.businesscards.IdMessageServiceValue request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_CHATS, responseObserver);
    }

    /**
     */
    public void getChatMessages(com.tsemkalo.businesscards.ChatUserProto request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.MessageProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_MESSAGES, responseObserver);
    }

    /**
     */
    public void getChatUsersIds(com.tsemkalo.businesscards.ChatUserProto request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_USERS_IDS, responseObserver);
    }

    /**
     */
    public void changeMemberName(com.tsemkalo.businesscards.ChangeNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_MEMBER_NAME, responseObserver);
    }

    /**
     */
    public void changeChatName(com.tsemkalo.businesscards.ChangeNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_CHAT_NAME, responseObserver);
    }

    /**
     */
    public void sendMessageToChat(com.tsemkalo.businesscards.SendMessageToChatRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_TO_CHAT, responseObserver);
    }

    /**
     */
    public void sendMessageToUser(com.tsemkalo.businesscards.SendMessageToUserRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_TO_USER, responseObserver);
    }

    /**
     */
    public void inviteMemberToChat(com.tsemkalo.businesscards.InviteMemberRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INVITE_MEMBER_TO_CHAT, responseObserver);
    }

    /**
     */
    public void sendToSupport(com.tsemkalo.businesscards.SendMessageToSupportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_TO_SUPPORT, responseObserver);
    }

    /**
     */
    public void getUnassignedSupportChats(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, responseObserver);
    }

    /**
     */
    public void assignSupportChat(com.tsemkalo.businesscards.AssignSupportChatRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ASSIGN_SUPPORT_CHAT, responseObserver);
    }

    /**
     */
    public void closeQuestion(com.tsemkalo.businesscards.CloseQuestionRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CLOSE_QUESTION, responseObserver);
    }

    /**
     */
    public void getSupportChats(com.tsemkalo.businesscards.IdMessageServiceValue request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SUPPORT_CHATS, responseObserver);
    }

    /**
     * <pre>
     *  rpc sendToAdmin() returns ();
     *  rpc getErrorChats() returns ();
     * </pre>
     */
    public void changeSendingNotifications(com.tsemkalo.businesscards.ChangeSendingNotificationsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_SENDING_NOTIFICATIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.IdMessageServiceValue,
                com.tsemkalo.businesscards.ChatProtoList>(
                  this, METHODID_GET_USER_CHATS)))
          .addMethod(
            METHOD_GET_CHAT_MESSAGES,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.ChatUserProto,
                com.tsemkalo.businesscards.MessageProtoList>(
                  this, METHODID_GET_CHAT_MESSAGES)))
          .addMethod(
            METHOD_GET_CHAT_USERS_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.ChatUserProto,
                com.tsemkalo.businesscards.ChatUserIdList>(
                  this, METHODID_GET_CHAT_USERS_IDS)))
          .addMethod(
            METHOD_CHANGE_MEMBER_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.ChangeNameRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_MEMBER_NAME)))
          .addMethod(
            METHOD_CHANGE_CHAT_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.ChangeNameRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_CHAT_NAME)))
          .addMethod(
            METHOD_SEND_MESSAGE_TO_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.SendMessageToChatRequest,
                com.tsemkalo.businesscards.ChatUserIdList>(
                  this, METHODID_SEND_MESSAGE_TO_CHAT)))
          .addMethod(
            METHOD_SEND_MESSAGE_TO_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.SendMessageToUserRequest,
                com.tsemkalo.businesscards.IdMessageServiceValue>(
                  this, METHODID_SEND_MESSAGE_TO_USER)))
          .addMethod(
            METHOD_INVITE_MEMBER_TO_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.InviteMemberRequest,
                com.tsemkalo.businesscards.IdMessageServiceValue>(
                  this, METHODID_INVITE_MEMBER_TO_CHAT)))
          .addMethod(
            METHOD_SEND_TO_SUPPORT,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.SendMessageToSupportRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND_TO_SUPPORT)))
          .addMethod(
            METHOD_GET_UNASSIGNED_SUPPORT_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.tsemkalo.businesscards.ChatProtoList>(
                  this, METHODID_GET_UNASSIGNED_SUPPORT_CHATS)))
          .addMethod(
            METHOD_ASSIGN_SUPPORT_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.AssignSupportChatRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ASSIGN_SUPPORT_CHAT)))
          .addMethod(
            METHOD_CLOSE_QUESTION,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.CloseQuestionRequest,
                com.tsemkalo.businesscards.ChatUserIdList>(
                  this, METHODID_CLOSE_QUESTION)))
          .addMethod(
            METHOD_GET_SUPPORT_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.IdMessageServiceValue,
                com.tsemkalo.businesscards.ChatProtoList>(
                  this, METHODID_GET_SUPPORT_CHATS)))
          .addMethod(
            METHOD_CHANGE_SENDING_NOTIFICATIONS,
            asyncUnaryCall(
              new MethodHandlers<
                com.tsemkalo.businesscards.ChangeSendingNotificationsRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_SENDING_NOTIFICATIONS)))
          .build();
    }
  }

  /**
   */
  public static final class MessageServiceStub extends io.grpc.stub.AbstractStub<MessageServiceStub> {
    private MessageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserChats(com.tsemkalo.businesscards.IdMessageServiceValue request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatMessages(com.tsemkalo.businesscards.ChatUserProto request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.MessageProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_MESSAGES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatUsersIds(com.tsemkalo.businesscards.ChatUserProto request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_USERS_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeMemberName(com.tsemkalo.businesscards.ChangeNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_MEMBER_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeChatName(com.tsemkalo.businesscards.ChangeNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_CHAT_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageToChat(com.tsemkalo.businesscards.SendMessageToChatRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageToUser(com.tsemkalo.businesscards.SendMessageToUserRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inviteMemberToChat(com.tsemkalo.businesscards.InviteMemberRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToSupport(com.tsemkalo.businesscards.SendMessageToSupportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_SUPPORT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUnassignedSupportChats(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignSupportChat(com.tsemkalo.businesscards.AssignSupportChatRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeQuestion(com.tsemkalo.businesscards.CloseQuestionRequest request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CLOSE_QUESTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSupportChats(com.tsemkalo.businesscards.IdMessageServiceValue request,
        io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SUPPORT_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *  rpc sendToAdmin() returns ();
     *  rpc getErrorChats() returns ();
     * </pre>
     */
    public void changeSendingNotifications(com.tsemkalo.businesscards.ChangeSendingNotificationsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_SENDING_NOTIFICATIONS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageServiceBlockingStub extends io.grpc.stub.AbstractStub<MessageServiceBlockingStub> {
    private MessageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatProtoList getUserChats(com.tsemkalo.businesscards.IdMessageServiceValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_CHATS, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.MessageProtoList getChatMessages(com.tsemkalo.businesscards.ChatUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_MESSAGES, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatUserIdList getChatUsersIds(com.tsemkalo.businesscards.ChatUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_USERS_IDS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changeMemberName(com.tsemkalo.businesscards.ChangeNameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_MEMBER_NAME, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changeChatName(com.tsemkalo.businesscards.ChangeNameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_CHAT_NAME, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatUserIdList sendMessageToChat(com.tsemkalo.businesscards.SendMessageToChatRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.IdMessageServiceValue sendMessageToUser(com.tsemkalo.businesscards.SendMessageToUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE_TO_USER, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.IdMessageServiceValue inviteMemberToChat(com.tsemkalo.businesscards.InviteMemberRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty sendToSupport(com.tsemkalo.businesscards.SendMessageToSupportRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_TO_SUPPORT, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatProtoList getUnassignedSupportChats(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignSupportChat(com.tsemkalo.businesscards.AssignSupportChatRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatUserIdList closeQuestion(com.tsemkalo.businesscards.CloseQuestionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CLOSE_QUESTION, getCallOptions(), request);
    }

    /**
     */
    public com.tsemkalo.businesscards.ChatProtoList getSupportChats(com.tsemkalo.businesscards.IdMessageServiceValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SUPPORT_CHATS, getCallOptions(), request);
    }

    /**
     * <pre>
     *  rpc sendToAdmin() returns ();
     *  rpc getErrorChats() returns ();
     * </pre>
     */
    public com.google.protobuf.Empty changeSendingNotifications(com.tsemkalo.businesscards.ChangeSendingNotificationsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_SENDING_NOTIFICATIONS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageServiceFutureStub extends io.grpc.stub.AbstractStub<MessageServiceFutureStub> {
    private MessageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatProtoList> getUserChats(
        com.tsemkalo.businesscards.IdMessageServiceValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_CHATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.MessageProtoList> getChatMessages(
        com.tsemkalo.businesscards.ChatUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_MESSAGES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatUserIdList> getChatUsersIds(
        com.tsemkalo.businesscards.ChatUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_USERS_IDS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeMemberName(
        com.tsemkalo.businesscards.ChangeNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_MEMBER_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeChatName(
        com.tsemkalo.businesscards.ChangeNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_CHAT_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatUserIdList> sendMessageToChat(
        com.tsemkalo.businesscards.SendMessageToChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.IdMessageServiceValue> sendMessageToUser(
        com.tsemkalo.businesscards.SendMessageToUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.IdMessageServiceValue> inviteMemberToChat(
        com.tsemkalo.businesscards.InviteMemberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendToSupport(
        com.tsemkalo.businesscards.SendMessageToSupportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_SUPPORT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatProtoList> getUnassignedSupportChats(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> assignSupportChat(
        com.tsemkalo.businesscards.AssignSupportChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatUserIdList> closeQuestion(
        com.tsemkalo.businesscards.CloseQuestionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CLOSE_QUESTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tsemkalo.businesscards.ChatProtoList> getSupportChats(
        com.tsemkalo.businesscards.IdMessageServiceValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SUPPORT_CHATS, getCallOptions()), request);
    }

    /**
     * <pre>
     *  rpc sendToAdmin() returns ();
     *  rpc getErrorChats() returns ();
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeSendingNotifications(
        com.tsemkalo.businesscards.ChangeSendingNotificationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_SENDING_NOTIFICATIONS, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_CHATS = 0;
  private static final int METHODID_GET_CHAT_MESSAGES = 1;
  private static final int METHODID_GET_CHAT_USERS_IDS = 2;
  private static final int METHODID_CHANGE_MEMBER_NAME = 3;
  private static final int METHODID_CHANGE_CHAT_NAME = 4;
  private static final int METHODID_SEND_MESSAGE_TO_CHAT = 5;
  private static final int METHODID_SEND_MESSAGE_TO_USER = 6;
  private static final int METHODID_INVITE_MEMBER_TO_CHAT = 7;
  private static final int METHODID_SEND_TO_SUPPORT = 8;
  private static final int METHODID_GET_UNASSIGNED_SUPPORT_CHATS = 9;
  private static final int METHODID_ASSIGN_SUPPORT_CHAT = 10;
  private static final int METHODID_CLOSE_QUESTION = 11;
  private static final int METHODID_GET_SUPPORT_CHATS = 12;
  private static final int METHODID_CHANGE_SENDING_NOTIFICATIONS = 13;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_CHATS:
          serviceImpl.getUserChats((com.tsemkalo.businesscards.IdMessageServiceValue) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList>) responseObserver);
          break;
        case METHODID_GET_CHAT_MESSAGES:
          serviceImpl.getChatMessages((com.tsemkalo.businesscards.ChatUserProto) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.MessageProtoList>) responseObserver);
          break;
        case METHODID_GET_CHAT_USERS_IDS:
          serviceImpl.getChatUsersIds((com.tsemkalo.businesscards.ChatUserProto) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList>) responseObserver);
          break;
        case METHODID_CHANGE_MEMBER_NAME:
          serviceImpl.changeMemberName((com.tsemkalo.businesscards.ChangeNameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHANGE_CHAT_NAME:
          serviceImpl.changeChatName((com.tsemkalo.businesscards.ChangeNameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TO_CHAT:
          serviceImpl.sendMessageToChat((com.tsemkalo.businesscards.SendMessageToChatRequest) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TO_USER:
          serviceImpl.sendMessageToUser((com.tsemkalo.businesscards.SendMessageToUserRequest) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue>) responseObserver);
          break;
        case METHODID_INVITE_MEMBER_TO_CHAT:
          serviceImpl.inviteMemberToChat((com.tsemkalo.businesscards.InviteMemberRequest) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.IdMessageServiceValue>) responseObserver);
          break;
        case METHODID_SEND_TO_SUPPORT:
          serviceImpl.sendToSupport((com.tsemkalo.businesscards.SendMessageToSupportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_UNASSIGNED_SUPPORT_CHATS:
          serviceImpl.getUnassignedSupportChats((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList>) responseObserver);
          break;
        case METHODID_ASSIGN_SUPPORT_CHAT:
          serviceImpl.assignSupportChat((com.tsemkalo.businesscards.AssignSupportChatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CLOSE_QUESTION:
          serviceImpl.closeQuestion((com.tsemkalo.businesscards.CloseQuestionRequest) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatUserIdList>) responseObserver);
          break;
        case METHODID_GET_SUPPORT_CHATS:
          serviceImpl.getSupportChats((com.tsemkalo.businesscards.IdMessageServiceValue) request,
              (io.grpc.stub.StreamObserver<com.tsemkalo.businesscards.ChatProtoList>) responseObserver);
          break;
        case METHODID_CHANGE_SENDING_NOTIFICATIONS:
          serviceImpl.changeSendingNotifications((com.tsemkalo.businesscards.ChangeSendingNotificationsRequest) request,
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

  private static final class MessageServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageServiceDescriptorSupplier())
              .addMethod(METHOD_GET_USER_CHATS)
              .addMethod(METHOD_GET_CHAT_MESSAGES)
              .addMethod(METHOD_GET_CHAT_USERS_IDS)
              .addMethod(METHOD_CHANGE_MEMBER_NAME)
              .addMethod(METHOD_CHANGE_CHAT_NAME)
              .addMethod(METHOD_SEND_MESSAGE_TO_CHAT)
              .addMethod(METHOD_SEND_MESSAGE_TO_USER)
              .addMethod(METHOD_INVITE_MEMBER_TO_CHAT)
              .addMethod(METHOD_SEND_TO_SUPPORT)
              .addMethod(METHOD_GET_UNASSIGNED_SUPPORT_CHATS)
              .addMethod(METHOD_ASSIGN_SUPPORT_CHAT)
              .addMethod(METHOD_CLOSE_QUESTION)
              .addMethod(METHOD_GET_SUPPORT_CHATS)
              .addMethod(METHOD_CHANGE_SENDING_NOTIFICATIONS)
              .build();
        }
      }
    }
    return result;
  }
}
