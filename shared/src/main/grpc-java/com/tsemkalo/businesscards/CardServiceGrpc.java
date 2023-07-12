package com.tsemkalo.businesscards;

import com.tsemkalo.businesscards.generatedProtos.CardListProto;
import com.tsemkalo.businesscards.generatedProtos.CardProto;
import com.tsemkalo.businesscards.generatedProtos.CardServiceOuterClass;
import com.tsemkalo.businesscards.generatedProtos.DeleteAddressProto;
import com.tsemkalo.businesscards.generatedProtos.DeleteCardProto;
import com.tsemkalo.businesscards.generatedProtos.DeleteContactProto;
import com.tsemkalo.businesscards.generatedProtos.DeleteGalleryPhotoProto;
import com.tsemkalo.businesscards.generatedProtos.EditAddressProto;
import com.tsemkalo.businesscards.generatedProtos.EditAppearanceProto;
import com.tsemkalo.businesscards.generatedProtos.EditCardProto;
import com.tsemkalo.businesscards.generatedProtos.EditContactProto;
import com.tsemkalo.businesscards.generatedProtos.EditGalleryPhotoProto;
import com.tsemkalo.businesscards.generatedProtos.FollowProto;
import com.tsemkalo.businesscards.generatedProtos.IdValue;
import com.tsemkalo.businesscards.generatedProtos.LikeProto;

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
    comments = "Source: CardService.proto")
public final class CardServiceGrpc {

  private CardServiceGrpc() {}

  public static final String SERVICE_NAME = "com.tsemkalo.businesscards.CardService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditCardProto,
          IdValue> METHOD_ADD_CARD =
      io.grpc.MethodDescriptor.<EditCardProto, IdValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addCard"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditCardProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditCardProto,
      com.google.protobuf.Empty> METHOD_EDIT_CARD =
      io.grpc.MethodDescriptor.<EditCardProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "editCard"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditCardProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DeleteCardProto,
      com.google.protobuf.Empty> METHOD_DELETE_CARD =
      io.grpc.MethodDescriptor.<DeleteCardProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteCard"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DeleteCardProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<IdValue,
          CardProto> METHOD_GET_CARD_INFO_BY_ID =
      io.grpc.MethodDescriptor.<IdValue, CardProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "getCardInfoById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CardProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<IdValue,
          CardListProto> METHOD_GET_ALL_CARDS_INFO_BY_USER =
      io.grpc.MethodDescriptor.<IdValue, CardListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "getAllCardsInfoByUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CardListProto.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditAddressProto,
      com.google.protobuf.Empty> METHOD_ADD_ADDRESS =
      io.grpc.MethodDescriptor.<EditAddressProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addAddress"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditAddressProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DeleteAddressProto,
      com.google.protobuf.Empty> METHOD_DELETE_ADDRESS =
      io.grpc.MethodDescriptor.<DeleteAddressProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteAddress"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DeleteAddressProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditAddressProto,
      com.google.protobuf.Empty> METHOD_EDIT_ADDRESS =
      io.grpc.MethodDescriptor.<EditAddressProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "editAddress"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditAddressProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditContactProto,
      com.google.protobuf.Empty> METHOD_ADD_CONTACT =
      io.grpc.MethodDescriptor.<EditContactProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addContact"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditContactProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DeleteContactProto,
      com.google.protobuf.Empty> METHOD_DELETE_CONTACT =
      io.grpc.MethodDescriptor.<DeleteContactProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteContact"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DeleteContactProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditContactProto,
      com.google.protobuf.Empty> METHOD_EDIT_CONTACT =
      io.grpc.MethodDescriptor.<EditContactProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "editContact"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditContactProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditGalleryPhotoProto,
      com.google.protobuf.Empty> METHOD_ADD_GALLERY_PHOTO =
      io.grpc.MethodDescriptor.<EditGalleryPhotoProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addGalleryPhoto"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditGalleryPhotoProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditGalleryPhotoProto,
      com.google.protobuf.Empty> METHOD_EDIT_GALLERY_PHOTO =
      io.grpc.MethodDescriptor.<EditGalleryPhotoProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "editGalleryPhoto"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditGalleryPhotoProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DeleteGalleryPhotoProto,
      com.google.protobuf.Empty> METHOD_DELETE_GALLERY_PHOTO =
      io.grpc.MethodDescriptor.<DeleteGalleryPhotoProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteGalleryPhoto"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DeleteGalleryPhotoProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<FollowProto,
      com.google.protobuf.Empty> METHOD_ADD_FOLLOW =
      io.grpc.MethodDescriptor.<FollowProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addFollow"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              FollowProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<FollowProto,
      com.google.protobuf.Empty> METHOD_DELETE_FOLLOW =
      io.grpc.MethodDescriptor.<FollowProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteFollow"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              FollowProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<LikeProto,
      com.google.protobuf.Empty> METHOD_ADD_LIKE =
      io.grpc.MethodDescriptor.<LikeProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "addLike"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              LikeProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<LikeProto,
      com.google.protobuf.Empty> METHOD_DELETE_LIKE =
      io.grpc.MethodDescriptor.<LikeProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "deleteLike"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              LikeProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EditAppearanceProto,
      com.google.protobuf.Empty> METHOD_EDIT_APPEARANCE =
      io.grpc.MethodDescriptor.<EditAppearanceProto, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "editAppearance"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EditAppearanceProto.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<IdValue,
          CardListProto> METHOD_GET_USER_FOLLOWINGS =
      io.grpc.MethodDescriptor.<IdValue, CardListProto>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.tsemkalo.businesscards.CardService", "getUserFollowings"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              IdValue.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CardListProto.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CardServiceStub newStub(io.grpc.Channel channel) {
    return new CardServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CardServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CardServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addCard(EditCardProto request,
                        io.grpc.stub.StreamObserver<IdValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_CARD, responseObserver);
    }

    /**
     */
    public void editCard(EditCardProto request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_CARD, responseObserver);
    }

    /**
     */
    public void deleteCard(DeleteCardProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CARD, responseObserver);
    }

    /**
     */
    public void getCardInfoById(IdValue request,
                                io.grpc.stub.StreamObserver<CardProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CARD_INFO_BY_ID, responseObserver);
    }

    /**
     */
    public void getAllCardsInfoByUser(IdValue request,
                                      io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_CARDS_INFO_BY_USER, responseObserver);
    }

    /**
     */
    public void addAddress(EditAddressProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_ADDRESS, responseObserver);
    }

    /**
     */
    public void deleteAddress(DeleteAddressProto request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_ADDRESS, responseObserver);
    }

    /**
     */
    public void editAddress(EditAddressProto request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_ADDRESS, responseObserver);
    }

    /**
     */
    public void addContact(EditContactProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_CONTACT, responseObserver);
    }

    /**
     */
    public void deleteContact(DeleteContactProto request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CONTACT, responseObserver);
    }

    /**
     */
    public void editContact(EditContactProto request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_CONTACT, responseObserver);
    }

    /**
     */
    public void addGalleryPhoto(EditGalleryPhotoProto request,
                                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_GALLERY_PHOTO, responseObserver);
    }

    /**
     */
    public void editGalleryPhoto(EditGalleryPhotoProto request,
                                 io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_GALLERY_PHOTO, responseObserver);
    }

    /**
     */
    public void deleteGalleryPhoto(DeleteGalleryPhotoProto request,
                                   io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_GALLERY_PHOTO, responseObserver);
    }

    /**
     */
    public void addFollow(FollowProto request,
                          io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_FOLLOW, responseObserver);
    }

    /**
     */
    public void deleteFollow(FollowProto request,
                             io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_FOLLOW, responseObserver);
    }

    /**
     */
    public void addLike(LikeProto request,
                        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_LIKE, responseObserver);
    }

    /**
     */
    public void deleteLike(LikeProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_LIKE, responseObserver);
    }

    /**
     */
    public void editAppearance(EditAppearanceProto request,
                               io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_APPEARANCE, responseObserver);
    }

    /**
     */
    public void getUserFollowings(IdValue request,
                                  io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_FOLLOWINGS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_CARD,
            asyncUnaryCall(
              new MethodHandlers<
                      EditCardProto,
                      IdValue>(
                  this, METHODID_ADD_CARD)))
          .addMethod(
            METHOD_EDIT_CARD,
            asyncUnaryCall(
              new MethodHandlers<
                      EditCardProto,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_CARD)))
          .addMethod(
            METHOD_DELETE_CARD,
            asyncUnaryCall(
              new MethodHandlers<
                      DeleteCardProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CARD)))
          .addMethod(
            METHOD_GET_CARD_INFO_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      IdValue,
                      CardProto>(
                  this, METHODID_GET_CARD_INFO_BY_ID)))
          .addMethod(
            METHOD_GET_ALL_CARDS_INFO_BY_USER,
            asyncUnaryCall(
              new MethodHandlers<
                      IdValue,
                      CardListProto>(
                  this, METHODID_GET_ALL_CARDS_INFO_BY_USER)))
          .addMethod(
            METHOD_ADD_ADDRESS,
            asyncUnaryCall(
              new MethodHandlers<
                      EditAddressProto,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_ADDRESS)))
          .addMethod(
            METHOD_DELETE_ADDRESS,
            asyncUnaryCall(
              new MethodHandlers<
                      DeleteAddressProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ADDRESS)))
          .addMethod(
            METHOD_EDIT_ADDRESS,
            asyncUnaryCall(
              new MethodHandlers<
                      EditAddressProto,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_ADDRESS)))
          .addMethod(
            METHOD_ADD_CONTACT,
            asyncUnaryCall(
              new MethodHandlers<
                      EditContactProto,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_CONTACT)))
          .addMethod(
            METHOD_DELETE_CONTACT,
            asyncUnaryCall(
              new MethodHandlers<
                      DeleteContactProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CONTACT)))
          .addMethod(
            METHOD_EDIT_CONTACT,
            asyncUnaryCall(
              new MethodHandlers<
                      EditContactProto,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_CONTACT)))
          .addMethod(
            METHOD_ADD_GALLERY_PHOTO,
            asyncUnaryCall(
              new MethodHandlers<
                      EditGalleryPhotoProto,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_GALLERY_PHOTO)))
          .addMethod(
            METHOD_EDIT_GALLERY_PHOTO,
            asyncUnaryCall(
              new MethodHandlers<
                      EditGalleryPhotoProto,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_GALLERY_PHOTO)))
          .addMethod(
            METHOD_DELETE_GALLERY_PHOTO,
            asyncUnaryCall(
              new MethodHandlers<
                      DeleteGalleryPhotoProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_GALLERY_PHOTO)))
          .addMethod(
            METHOD_ADD_FOLLOW,
            asyncUnaryCall(
              new MethodHandlers<
                      FollowProto,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_FOLLOW)))
          .addMethod(
            METHOD_DELETE_FOLLOW,
            asyncUnaryCall(
              new MethodHandlers<
                      FollowProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_FOLLOW)))
          .addMethod(
            METHOD_ADD_LIKE,
            asyncUnaryCall(
              new MethodHandlers<
                      LikeProto,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_LIKE)))
          .addMethod(
            METHOD_DELETE_LIKE,
            asyncUnaryCall(
              new MethodHandlers<
                      LikeProto,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_LIKE)))
          .addMethod(
            METHOD_EDIT_APPEARANCE,
            asyncUnaryCall(
              new MethodHandlers<
                      EditAppearanceProto,
                com.google.protobuf.Empty>(
                  this, METHODID_EDIT_APPEARANCE)))
          .addMethod(
            METHOD_GET_USER_FOLLOWINGS,
            asyncUnaryCall(
              new MethodHandlers<
                      IdValue,
                      CardListProto>(
                  this, METHODID_GET_USER_FOLLOWINGS)))
          .build();
    }
  }

  /**
   */
  public static final class CardServiceStub extends io.grpc.stub.AbstractStub<CardServiceStub> {
    private CardServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CardServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CardServiceStub(channel, callOptions);
    }

    /**
     */
    public void addCard(EditCardProto request,
                        io.grpc.stub.StreamObserver<IdValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_CARD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editCard(EditCardProto request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_CARD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCard(DeleteCardProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CARD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCardInfoById(IdValue request,
                                io.grpc.stub.StreamObserver<CardProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CARD_INFO_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCardsInfoByUser(IdValue request,
                                      io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_CARDS_INFO_BY_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addAddress(EditAddressProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_ADDRESS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAddress(DeleteAddressProto request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_ADDRESS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editAddress(EditAddressProto request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_ADDRESS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addContact(EditContactProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_CONTACT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteContact(DeleteContactProto request,
                              io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CONTACT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editContact(EditContactProto request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_CONTACT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addGalleryPhoto(EditGalleryPhotoProto request,
                                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_GALLERY_PHOTO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editGalleryPhoto(EditGalleryPhotoProto request,
                                 io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_GALLERY_PHOTO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGalleryPhoto(DeleteGalleryPhotoProto request,
                                   io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_GALLERY_PHOTO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFollow(FollowProto request,
                          io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_FOLLOW, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFollow(FollowProto request,
                             io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_FOLLOW, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLike(LikeProto request,
                        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_LIKE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteLike(LikeProto request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LIKE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editAppearance(EditAppearanceProto request,
                               io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_APPEARANCE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserFollowings(IdValue request,
                                  io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_FOLLOWINGS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CardServiceBlockingStub extends io.grpc.stub.AbstractStub<CardServiceBlockingStub> {
    private CardServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CardServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public IdValue addCard(EditCardProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_CARD, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editCard(EditCardProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_CARD, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteCard(DeleteCardProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CARD, getCallOptions(), request);
    }

    /**
     */
    public CardProto getCardInfoById(IdValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CARD_INFO_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public CardListProto getAllCardsInfoByUser(IdValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_CARDS_INFO_BY_USER, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addAddress(EditAddressProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_ADDRESS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteAddress(DeleteAddressProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_ADDRESS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editAddress(EditAddressProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_ADDRESS, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addContact(EditContactProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_CONTACT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteContact(DeleteContactProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CONTACT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editContact(EditContactProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_CONTACT, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addGalleryPhoto(EditGalleryPhotoProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_GALLERY_PHOTO, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editGalleryPhoto(EditGalleryPhotoProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_GALLERY_PHOTO, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteGalleryPhoto(DeleteGalleryPhotoProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_GALLERY_PHOTO, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addFollow(FollowProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_FOLLOW, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteFollow(FollowProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_FOLLOW, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addLike(LikeProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_LIKE, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteLike(LikeProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_LIKE, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty editAppearance(EditAppearanceProto request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_APPEARANCE, getCallOptions(), request);
    }

    /**
     */
    public CardListProto getUserFollowings(IdValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_FOLLOWINGS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CardServiceFutureStub extends io.grpc.stub.AbstractStub<CardServiceFutureStub> {
    private CardServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CardServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CardServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<IdValue> addCard(
        EditCardProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_CARD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editCard(
        EditCardProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_CARD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteCard(
        DeleteCardProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CARD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CardProto> getCardInfoById(
        IdValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CARD_INFO_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CardListProto> getAllCardsInfoByUser(
        IdValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_CARDS_INFO_BY_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addAddress(
        EditAddressProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_ADDRESS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAddress(
        DeleteAddressProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_ADDRESS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editAddress(
        EditAddressProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_ADDRESS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addContact(
        EditContactProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_CONTACT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteContact(
        DeleteContactProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CONTACT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editContact(
        EditContactProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_CONTACT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addGalleryPhoto(
        EditGalleryPhotoProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_GALLERY_PHOTO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editGalleryPhoto(
        EditGalleryPhotoProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_GALLERY_PHOTO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteGalleryPhoto(
        DeleteGalleryPhotoProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_GALLERY_PHOTO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addFollow(
        FollowProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_FOLLOW, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteFollow(
        FollowProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_FOLLOW, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addLike(
        LikeProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_LIKE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLike(
        LikeProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LIKE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> editAppearance(
        EditAppearanceProto request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_APPEARANCE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CardListProto> getUserFollowings(
        IdValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_FOLLOWINGS, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CARD = 0;
  private static final int METHODID_EDIT_CARD = 1;
  private static final int METHODID_DELETE_CARD = 2;
  private static final int METHODID_GET_CARD_INFO_BY_ID = 3;
  private static final int METHODID_GET_ALL_CARDS_INFO_BY_USER = 4;
  private static final int METHODID_ADD_ADDRESS = 5;
  private static final int METHODID_DELETE_ADDRESS = 6;
  private static final int METHODID_EDIT_ADDRESS = 7;
  private static final int METHODID_ADD_CONTACT = 8;
  private static final int METHODID_DELETE_CONTACT = 9;
  private static final int METHODID_EDIT_CONTACT = 10;
  private static final int METHODID_ADD_GALLERY_PHOTO = 11;
  private static final int METHODID_EDIT_GALLERY_PHOTO = 12;
  private static final int METHODID_DELETE_GALLERY_PHOTO = 13;
  private static final int METHODID_ADD_FOLLOW = 14;
  private static final int METHODID_DELETE_FOLLOW = 15;
  private static final int METHODID_ADD_LIKE = 16;
  private static final int METHODID_DELETE_LIKE = 17;
  private static final int METHODID_EDIT_APPEARANCE = 18;
  private static final int METHODID_GET_USER_FOLLOWINGS = 19;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CARD:
          serviceImpl.addCard((EditCardProto) request,
              (io.grpc.stub.StreamObserver<IdValue>) responseObserver);
          break;
        case METHODID_EDIT_CARD:
          serviceImpl.editCard((EditCardProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_CARD:
          serviceImpl.deleteCard((DeleteCardProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CARD_INFO_BY_ID:
          serviceImpl.getCardInfoById((IdValue) request,
              (io.grpc.stub.StreamObserver<CardProto>) responseObserver);
          break;
        case METHODID_GET_ALL_CARDS_INFO_BY_USER:
          serviceImpl.getAllCardsInfoByUser((IdValue) request,
              (io.grpc.stub.StreamObserver<CardListProto>) responseObserver);
          break;
        case METHODID_ADD_ADDRESS:
          serviceImpl.addAddress((EditAddressProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_ADDRESS:
          serviceImpl.deleteAddress((DeleteAddressProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EDIT_ADDRESS:
          serviceImpl.editAddress((EditAddressProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ADD_CONTACT:
          serviceImpl.addContact((EditContactProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_CONTACT:
          serviceImpl.deleteContact((DeleteContactProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EDIT_CONTACT:
          serviceImpl.editContact((EditContactProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ADD_GALLERY_PHOTO:
          serviceImpl.addGalleryPhoto((EditGalleryPhotoProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EDIT_GALLERY_PHOTO:
          serviceImpl.editGalleryPhoto((EditGalleryPhotoProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_GALLERY_PHOTO:
          serviceImpl.deleteGalleryPhoto((DeleteGalleryPhotoProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ADD_FOLLOW:
          serviceImpl.addFollow((FollowProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_FOLLOW:
          serviceImpl.deleteFollow((FollowProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ADD_LIKE:
          serviceImpl.addLike((LikeProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_LIKE:
          serviceImpl.deleteLike((LikeProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_EDIT_APPEARANCE:
          serviceImpl.editAppearance((EditAppearanceProto) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_USER_FOLLOWINGS:
          serviceImpl.getUserFollowings((IdValue) request,
              (io.grpc.stub.StreamObserver<CardListProto>) responseObserver);
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

  private static final class CardServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CardServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CardServiceDescriptorSupplier())
              .addMethod(METHOD_ADD_CARD)
              .addMethod(METHOD_EDIT_CARD)
              .addMethod(METHOD_DELETE_CARD)
              .addMethod(METHOD_GET_CARD_INFO_BY_ID)
              .addMethod(METHOD_GET_ALL_CARDS_INFO_BY_USER)
              .addMethod(METHOD_ADD_ADDRESS)
              .addMethod(METHOD_DELETE_ADDRESS)
              .addMethod(METHOD_EDIT_ADDRESS)
              .addMethod(METHOD_ADD_CONTACT)
              .addMethod(METHOD_DELETE_CONTACT)
              .addMethod(METHOD_EDIT_CONTACT)
              .addMethod(METHOD_ADD_GALLERY_PHOTO)
              .addMethod(METHOD_EDIT_GALLERY_PHOTO)
              .addMethod(METHOD_DELETE_GALLERY_PHOTO)
              .addMethod(METHOD_ADD_FOLLOW)
              .addMethod(METHOD_DELETE_FOLLOW)
              .addMethod(METHOD_ADD_LIKE)
              .addMethod(METHOD_DELETE_LIKE)
              .addMethod(METHOD_EDIT_APPEARANCE)
              .addMethod(METHOD_GET_USER_FOLLOWINGS)
              .build();
        }
      }
    }
    return result;
  }
}
