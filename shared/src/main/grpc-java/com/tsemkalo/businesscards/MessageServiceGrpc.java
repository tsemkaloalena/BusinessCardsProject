package com.tsemkalo.businesscards;

import com.tsemkalo.businesscards.generatedProtos.AssignSupportChatRequest;
import com.tsemkalo.businesscards.generatedProtos.ChangeNameRequest;
import com.tsemkalo.businesscards.generatedProtos.ChangeSendingNotificationsRequest;
import com.tsemkalo.businesscards.generatedProtos.ChatProtoList;
import com.tsemkalo.businesscards.generatedProtos.ChatUserIdList;
import com.tsemkalo.businesscards.generatedProtos.ChatUserProto;
import com.tsemkalo.businesscards.generatedProtos.CloseQuestionRequest;
import com.tsemkalo.businesscards.generatedProtos.IdMessageServiceValue;
import com.tsemkalo.businesscards.generatedProtos.InviteMemberRequest;
import com.tsemkalo.businesscards.generatedProtos.MessageProtoList;
import com.tsemkalo.businesscards.generatedProtos.MessageServiceOuterClass;
import com.tsemkalo.businesscards.generatedProtos.SendMessageToChatRequest;
import com.tsemkalo.businesscards.generatedProtos.SendMessageToSupportRequest;
import com.tsemkalo.businesscards.generatedProtos.SendMessageToUserRequest;

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
    comments = "Source: MessageService.proto")
public final class MessageServiceGrpc {

  private MessageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tsemkalo.businesscards.MessageService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<IdMessageServiceValue,
          ChatProtoList> METHOD_GET_USER_CHATS =
      io.grpc.MethodDescriptor.<IdMessageServiceValue, ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getUserChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdMessageServiceValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChatUserProto,
          MessageProtoList> METHOD_GET_CHAT_MESSAGES =
      io.grpc.MethodDescriptor.<ChatUserProto, MessageProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getChatMessages"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MessageProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChatUserProto,
          ChatUserIdList> METHOD_GET_CHAT_USERS_IDS =
      io.grpc.MethodDescriptor.<ChatUserProto, ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getChatUsersIds"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatUserProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChangeNameRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_MEMBER_NAME =
      io.grpc.MethodDescriptor.<ChangeNameRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeMemberName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangeNameRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChangeNameRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_CHAT_NAME =
      io.grpc.MethodDescriptor.<ChangeNameRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeChatName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangeNameRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<SendMessageToChatRequest,
          ChatUserIdList> METHOD_SEND_MESSAGE_TO_CHAT =
      io.grpc.MethodDescriptor.<SendMessageToChatRequest, ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendMessageToChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SendMessageToChatRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<SendMessageToUserRequest,
          IdMessageServiceValue> METHOD_SEND_MESSAGE_TO_USER =
      io.grpc.MethodDescriptor.<SendMessageToUserRequest, IdMessageServiceValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendMessageToUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SendMessageToUserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdMessageServiceValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<InviteMemberRequest,
          IdMessageServiceValue> METHOD_INVITE_MEMBER_TO_CHAT =
      io.grpc.MethodDescriptor.<InviteMemberRequest, IdMessageServiceValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "inviteMemberToChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              InviteMemberRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdMessageServiceValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<SendMessageToSupportRequest,
      com.google.protobuf.Empty> METHOD_SEND_TO_SUPPORT =
      io.grpc.MethodDescriptor.<SendMessageToSupportRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "sendToSupport"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              SendMessageToSupportRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
          ChatProtoList> METHOD_GET_UNASSIGNED_SUPPORT_CHATS =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getUnassignedSupportChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<AssignSupportChatRequest,
      com.google.protobuf.Empty> METHOD_ASSIGN_SUPPORT_CHAT =
      io.grpc.MethodDescriptor.<AssignSupportChatRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "assignSupportChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              AssignSupportChatRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CloseQuestionRequest,
          ChatUserIdList> METHOD_CLOSE_QUESTION =
      io.grpc.MethodDescriptor.<CloseQuestionRequest, ChatUserIdList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "closeQuestion"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CloseQuestionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatUserIdList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<IdMessageServiceValue,
          ChatProtoList> METHOD_GET_SUPPORT_CHATS =
      io.grpc.MethodDescriptor.<IdMessageServiceValue, ChatProtoList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "getSupportChats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdMessageServiceValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChatProtoList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ChangeSendingNotificationsRequest,
      com.google.protobuf.Empty> METHOD_CHANGE_SENDING_NOTIFICATIONS =
      io.grpc.MethodDescriptor.<ChangeSendingNotificationsRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.MessageService", "changeSendingNotifications"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ChangeSendingNotificationsRequest.getDefaultInstance()))
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
    public void getUserChats(IdMessageServiceValue request,
                             io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_CHATS, responseObserver);
    }

    /**
     */
    public void getChatMessages(ChatUserProto request,
                                io.grpc.stub.StreamObserver<MessageProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_MESSAGES, responseObserver);
    }

    /**
     */
    public void getChatUsersIds(ChatUserProto request,
                                io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAT_USERS_IDS, responseObserver);
    }

    /**
     */
    public void changeMemberName(ChangeNameRequest request,
                                 io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_MEMBER_NAME, responseObserver);
    }

    /**
     */
    public void changeChatName(ChangeNameRequest request,
                               io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_CHAT_NAME, responseObserver);
    }

    /**
     */
    public void sendMessageToChat(SendMessageToChatRequest request,
                                  io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_TO_CHAT, responseObserver);
    }

    /**
     */
    public void sendMessageToUser(SendMessageToUserRequest request,
                                  io.grpc.stub.StreamObserver<IdMessageServiceValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_TO_USER, responseObserver);
    }

    /**
     */
    public void inviteMemberToChat(InviteMemberRequest request,
                                   io.grpc.stub.StreamObserver<IdMessageServiceValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INVITE_MEMBER_TO_CHAT, responseObserver);
    }

    /**
     */
    public void sendToSupport(SendMessageToSupportRequest request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_TO_SUPPORT, responseObserver);
    }

    /**
     */
    public void getUnassignedSupportChats(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, responseObserver);
    }

    /**
     */
    public void assignSupportChat(AssignSupportChatRequest request,
                                  io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ASSIGN_SUPPORT_CHAT, responseObserver);
    }

    /**
     */
    public void closeQuestion(CloseQuestionRequest request,
                              io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CLOSE_QUESTION, responseObserver);
    }

    /**
     */
    public void getSupportChats(IdMessageServiceValue request,
                                io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SUPPORT_CHATS, responseObserver);
    }

    /**
     */
    public void changeSendingNotifications(ChangeSendingNotificationsRequest request,
                                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_SENDING_NOTIFICATIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                      IdMessageServiceValue,
                      ChatProtoList>(
                  this, METHODID_GET_USER_CHATS)))
          .addMethod(
            METHOD_GET_CHAT_MESSAGES,
            asyncUnaryCall(
              new MethodHandlers<
                      ChatUserProto,
                      MessageProtoList>(
                  this, METHODID_GET_CHAT_MESSAGES)))
          .addMethod(
            METHOD_GET_CHAT_USERS_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                      ChatUserProto,
                      ChatUserIdList>(
                  this, METHODID_GET_CHAT_USERS_IDS)))
          .addMethod(
            METHOD_CHANGE_MEMBER_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                      ChangeNameRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_MEMBER_NAME)))
          .addMethod(
            METHOD_CHANGE_CHAT_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                      ChangeNameRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CHANGE_CHAT_NAME)))
          .addMethod(
            METHOD_SEND_MESSAGE_TO_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                      SendMessageToChatRequest,
                      ChatUserIdList>(
                  this, METHODID_SEND_MESSAGE_TO_CHAT)))
          .addMethod(
            METHOD_SEND_MESSAGE_TO_USER,
            asyncUnaryCall(
              new MethodHandlers<
                      SendMessageToUserRequest,
                      IdMessageServiceValue>(
                  this, METHODID_SEND_MESSAGE_TO_USER)))
          .addMethod(
            METHOD_INVITE_MEMBER_TO_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                      InviteMemberRequest,
                      IdMessageServiceValue>(
                  this, METHODID_INVITE_MEMBER_TO_CHAT)))
          .addMethod(
            METHOD_SEND_TO_SUPPORT,
            asyncUnaryCall(
              new MethodHandlers<
                      SendMessageToSupportRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND_TO_SUPPORT)))
          .addMethod(
            METHOD_GET_UNASSIGNED_SUPPORT_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                      ChatProtoList>(
                  this, METHODID_GET_UNASSIGNED_SUPPORT_CHATS)))
          .addMethod(
            METHOD_ASSIGN_SUPPORT_CHAT,
            asyncUnaryCall(
              new MethodHandlers<
                      AssignSupportChatRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ASSIGN_SUPPORT_CHAT)))
          .addMethod(
            METHOD_CLOSE_QUESTION,
            asyncUnaryCall(
              new MethodHandlers<
                      CloseQuestionRequest,
                      ChatUserIdList>(
                  this, METHODID_CLOSE_QUESTION)))
          .addMethod(
            METHOD_GET_SUPPORT_CHATS,
            asyncUnaryCall(
              new MethodHandlers<
                      IdMessageServiceValue,
                      ChatProtoList>(
                  this, METHODID_GET_SUPPORT_CHATS)))
          .addMethod(
            METHOD_CHANGE_SENDING_NOTIFICATIONS,
            asyncUnaryCall(
              new MethodHandlers<
                      ChangeSendingNotificationsRequest,
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
    public void getUserChats(IdMessageServiceValue request,
                             io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatMessages(ChatUserProto request,
                                io.grpc.stub.StreamObserver<MessageProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_MESSAGES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChatUsersIds(ChatUserProto request,
                                io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_USERS_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeMemberName(ChangeNameRequest request,
                                 io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_MEMBER_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeChatName(ChangeNameRequest request,
                               io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_CHAT_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageToChat(SendMessageToChatRequest request,
                                  io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageToUser(SendMessageToUserRequest request,
                                  io.grpc.stub.StreamObserver<IdMessageServiceValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inviteMemberToChat(InviteMemberRequest request,
                                   io.grpc.stub.StreamObserver<IdMessageServiceValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToSupport(SendMessageToSupportRequest request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_SUPPORT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUnassignedSupportChats(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignSupportChat(AssignSupportChatRequest request,
                                  io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeQuestion(CloseQuestionRequest request,
                              io.grpc.stub.StreamObserver<ChatUserIdList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CLOSE_QUESTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSupportChats(IdMessageServiceValue request,
                                io.grpc.stub.StreamObserver<ChatProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SUPPORT_CHATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeSendingNotifications(ChangeSendingNotificationsRequest request,
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
    public ChatProtoList getUserChats(IdMessageServiceValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_CHATS, getCallOptions(), request);
    }

    /**
     */
    public MessageProtoList getChatMessages(ChatUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_MESSAGES, getCallOptions(), request);
    }

    /**
     */
    public ChatUserIdList getChatUsersIds(ChatUserProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAT_USERS_IDS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changeMemberName(ChangeNameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_MEMBER_NAME, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changeChatName(ChangeNameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_CHAT_NAME, getCallOptions(), request);
    }

    /**
     */
    public ChatUserIdList sendMessageToChat(SendMessageToChatRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions(), request);
    }

    /**
     */
    public IdMessageServiceValue sendMessageToUser(SendMessageToUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE_TO_USER, getCallOptions(), request);
    }

    /**
     */
    public IdMessageServiceValue inviteMemberToChat(InviteMemberRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty sendToSupport(SendMessageToSupportRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_TO_SUPPORT, getCallOptions(), request);
    }

    /**
     */
    public ChatProtoList getUnassignedSupportChats(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignSupportChat(AssignSupportChatRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions(), request);
    }

    /**
     */
    public ChatUserIdList closeQuestion(CloseQuestionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CLOSE_QUESTION, getCallOptions(), request);
    }

    /**
     */
    public ChatProtoList getSupportChats(IdMessageServiceValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SUPPORT_CHATS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty changeSendingNotifications(ChangeSendingNotificationsRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<ChatProtoList> getUserChats(
        IdMessageServiceValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_CHATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MessageProtoList> getChatMessages(
        ChatUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_MESSAGES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatUserIdList> getChatUsersIds(
        ChatUserProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAT_USERS_IDS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeMemberName(
        ChangeNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_MEMBER_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeChatName(
        ChangeNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_CHAT_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatUserIdList> sendMessageToChat(
        SendMessageToChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<IdMessageServiceValue> sendMessageToUser(
        SendMessageToUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_TO_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<IdMessageServiceValue> inviteMemberToChat(
        InviteMemberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INVITE_MEMBER_TO_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendToSupport(
        SendMessageToSupportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_SUPPORT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatProtoList> getUnassignedSupportChats(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_UNASSIGNED_SUPPORT_CHATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> assignSupportChat(
        AssignSupportChatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ASSIGN_SUPPORT_CHAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatUserIdList> closeQuestion(
        CloseQuestionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CLOSE_QUESTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ChatProtoList> getSupportChats(
        IdMessageServiceValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SUPPORT_CHATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> changeSendingNotifications(
        ChangeSendingNotificationsRequest request) {
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
          serviceImpl.getUserChats((IdMessageServiceValue) request,
              (io.grpc.stub.StreamObserver<ChatProtoList>) responseObserver);
          break;
        case METHODID_GET_CHAT_MESSAGES:
          serviceImpl.getChatMessages((ChatUserProto) request,
              (io.grpc.stub.StreamObserver<MessageProtoList>) responseObserver);
          break;
        case METHODID_GET_CHAT_USERS_IDS:
          serviceImpl.getChatUsersIds((ChatUserProto) request,
              (io.grpc.stub.StreamObserver<ChatUserIdList>) responseObserver);
          break;
        case METHODID_CHANGE_MEMBER_NAME:
          serviceImpl.changeMemberName((ChangeNameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHANGE_CHAT_NAME:
          serviceImpl.changeChatName((ChangeNameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TO_CHAT:
          serviceImpl.sendMessageToChat((SendMessageToChatRequest) request,
              (io.grpc.stub.StreamObserver<ChatUserIdList>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TO_USER:
          serviceImpl.sendMessageToUser((SendMessageToUserRequest) request,
              (io.grpc.stub.StreamObserver<IdMessageServiceValue>) responseObserver);
          break;
        case METHODID_INVITE_MEMBER_TO_CHAT:
          serviceImpl.inviteMemberToChat((InviteMemberRequest) request,
              (io.grpc.stub.StreamObserver<IdMessageServiceValue>) responseObserver);
          break;
        case METHODID_SEND_TO_SUPPORT:
          serviceImpl.sendToSupport((SendMessageToSupportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_UNASSIGNED_SUPPORT_CHATS:
          serviceImpl.getUnassignedSupportChats((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ChatProtoList>) responseObserver);
          break;
        case METHODID_ASSIGN_SUPPORT_CHAT:
          serviceImpl.assignSupportChat((AssignSupportChatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CLOSE_QUESTION:
          serviceImpl.closeQuestion((CloseQuestionRequest) request,
              (io.grpc.stub.StreamObserver<ChatUserIdList>) responseObserver);
          break;
        case METHODID_GET_SUPPORT_CHATS:
          serviceImpl.getSupportChats((IdMessageServiceValue) request,
              (io.grpc.stub.StreamObserver<ChatProtoList>) responseObserver);
          break;
        case METHODID_CHANGE_SENDING_NOTIFICATIONS:
          serviceImpl.changeSendingNotifications((ChangeSendingNotificationsRequest) request,
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
      return MessageServiceOuterClass.getDescriptor();
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
