// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.ForgotPasswordRequest}
 */
public  final class ForgotPasswordRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.ForgotPasswordRequest)
    ForgotPasswordRequestOrBuilder {
  // Use ForgotPasswordRequest.newBuilder() to construct.
  private ForgotPasswordRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ForgotPasswordRequest() {
    resetPasswordToken_ = "";
    newPassword_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ForgotPasswordRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            resetPasswordToken_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            newPassword_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ForgotPasswordRequest.class, ForgotPasswordRequest.Builder.class);
  }

  public static final int RESETPASSWORDTOKEN_FIELD_NUMBER = 1;
  private volatile java.lang.Object resetPasswordToken_;
  /**
   * <code>string resetPasswordToken = 1;</code>
   */
  public java.lang.String getResetPasswordToken() {
    java.lang.Object ref = resetPasswordToken_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      resetPasswordToken_ = s;
      return s;
    }
  }
  /**
   * <code>string resetPasswordToken = 1;</code>
   */
  public com.google.protobuf.ByteString
      getResetPasswordTokenBytes() {
    java.lang.Object ref = resetPasswordToken_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      resetPasswordToken_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NEWPASSWORD_FIELD_NUMBER = 2;
  private volatile java.lang.Object newPassword_;
  /**
   * <code>string newPassword = 2;</code>
   */
  public java.lang.String getNewPassword() {
    java.lang.Object ref = newPassword_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      newPassword_ = s;
      return s;
    }
  }
  /**
   * <code>string newPassword = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNewPasswordBytes() {
    java.lang.Object ref = newPassword_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      newPassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getResetPasswordTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, resetPasswordToken_);
    }
    if (!getNewPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, newPassword_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getResetPasswordTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, resetPasswordToken_);
    }
    if (!getNewPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, newPassword_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ForgotPasswordRequest)) {
      return super.equals(obj);
    }
    ForgotPasswordRequest other = (ForgotPasswordRequest) obj;

    boolean result = true;
    result = result && getResetPasswordToken()
        .equals(other.getResetPasswordToken());
    result = result && getNewPassword()
        .equals(other.getNewPassword());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESETPASSWORDTOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getResetPasswordToken().hashCode();
    hash = (37 * hash) + NEWPASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getNewPassword().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ForgotPasswordRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ForgotPasswordRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ForgotPasswordRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ForgotPasswordRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ForgotPasswordRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ForgotPasswordRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ForgotPasswordRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ForgotPasswordRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ForgotPasswordRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ForgotPasswordRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ForgotPasswordRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ForgotPasswordRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ForgotPasswordRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.tsemkalo.businesscards.generated.ForgotPasswordRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.ForgotPasswordRequest)
          ForgotPasswordRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ForgotPasswordRequest.class, ForgotPasswordRequest.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.ForgotPasswordRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      resetPasswordToken_ = "";

      newPassword_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor;
    }

    public ForgotPasswordRequest getDefaultInstanceForType() {
      return ForgotPasswordRequest.getDefaultInstance();
    }

    public ForgotPasswordRequest build() {
      ForgotPasswordRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ForgotPasswordRequest buildPartial() {
      ForgotPasswordRequest result = new ForgotPasswordRequest(this);
      result.resetPasswordToken_ = resetPasswordToken_;
      result.newPassword_ = newPassword_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ForgotPasswordRequest) {
        return mergeFrom((ForgotPasswordRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ForgotPasswordRequest other) {
      if (other == ForgotPasswordRequest.getDefaultInstance()) return this;
      if (!other.getResetPasswordToken().isEmpty()) {
        resetPasswordToken_ = other.resetPasswordToken_;
        onChanged();
      }
      if (!other.getNewPassword().isEmpty()) {
        newPassword_ = other.newPassword_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ForgotPasswordRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ForgotPasswordRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object resetPasswordToken_ = "";
    /**
     * <code>string resetPasswordToken = 1;</code>
     */
    public java.lang.String getResetPasswordToken() {
      java.lang.Object ref = resetPasswordToken_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        resetPasswordToken_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string resetPasswordToken = 1;</code>
     */
    public com.google.protobuf.ByteString
        getResetPasswordTokenBytes() {
      java.lang.Object ref = resetPasswordToken_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        resetPasswordToken_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string resetPasswordToken = 1;</code>
     */
    public Builder setResetPasswordToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      resetPasswordToken_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string resetPasswordToken = 1;</code>
     */
    public Builder clearResetPasswordToken() {
      
      resetPasswordToken_ = getDefaultInstance().getResetPasswordToken();
      onChanged();
      return this;
    }
    /**
     * <code>string resetPasswordToken = 1;</code>
     */
    public Builder setResetPasswordTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      resetPasswordToken_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object newPassword_ = "";
    /**
     * <code>string newPassword = 2;</code>
     */
    public java.lang.String getNewPassword() {
      java.lang.Object ref = newPassword_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        newPassword_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string newPassword = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNewPasswordBytes() {
      java.lang.Object ref = newPassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        newPassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string newPassword = 2;</code>
     */
    public Builder setNewPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      newPassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string newPassword = 2;</code>
     */
    public Builder clearNewPassword() {
      
      newPassword_ = getDefaultInstance().getNewPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string newPassword = 2;</code>
     */
    public Builder setNewPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      newPassword_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.ForgotPasswordRequest)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.ForgotPasswordRequest)
  private static final ForgotPasswordRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ForgotPasswordRequest();
  }

  public static ForgotPasswordRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ForgotPasswordRequest>
      PARSER = new com.google.protobuf.AbstractParser<ForgotPasswordRequest>() {
    public ForgotPasswordRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ForgotPasswordRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ForgotPasswordRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ForgotPasswordRequest> getParserForType() {
    return PARSER;
  }

  public ForgotPasswordRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

