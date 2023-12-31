// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.ChangePasswordRequest}
 */
public  final class ChangePasswordRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.ChangePasswordRequest)
    ChangePasswordRequestOrBuilder {
  // Use ChangePasswordRequest.newBuilder() to construct.
  private ChangePasswordRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChangePasswordRequest() {
    currentUsername_ = "";
    oldPassword_ = "";
    newPassword_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ChangePasswordRequest(
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

            currentUsername_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            oldPassword_ = s;
            break;
          }
          case 26: {
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
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ChangePasswordRequest.class, ChangePasswordRequest.Builder.class);
  }

  public static final int CURRENTUSERNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object currentUsername_;
  /**
   * <code>string currentUsername = 1;</code>
   */
  public java.lang.String getCurrentUsername() {
    java.lang.Object ref = currentUsername_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      currentUsername_ = s;
      return s;
    }
  }
  /**
   * <code>string currentUsername = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCurrentUsernameBytes() {
    java.lang.Object ref = currentUsername_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      currentUsername_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OLDPASSWORD_FIELD_NUMBER = 2;
  private volatile java.lang.Object oldPassword_;
  /**
   * <code>string oldPassword = 2;</code>
   */
  public java.lang.String getOldPassword() {
    java.lang.Object ref = oldPassword_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      oldPassword_ = s;
      return s;
    }
  }
  /**
   * <code>string oldPassword = 2;</code>
   */
  public com.google.protobuf.ByteString
      getOldPasswordBytes() {
    java.lang.Object ref = oldPassword_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      oldPassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NEWPASSWORD_FIELD_NUMBER = 3;
  private volatile java.lang.Object newPassword_;
  /**
   * <code>string newPassword = 3;</code>
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
   * <code>string newPassword = 3;</code>
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
    if (!getCurrentUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, currentUsername_);
    }
    if (!getOldPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, oldPassword_);
    }
    if (!getNewPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, newPassword_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCurrentUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, currentUsername_);
    }
    if (!getOldPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, oldPassword_);
    }
    if (!getNewPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, newPassword_);
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
    if (!(obj instanceof ChangePasswordRequest)) {
      return super.equals(obj);
    }
    ChangePasswordRequest other = (ChangePasswordRequest) obj;

    boolean result = true;
    result = result && getCurrentUsername()
        .equals(other.getCurrentUsername());
    result = result && getOldPassword()
        .equals(other.getOldPassword());
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
    hash = (37 * hash) + CURRENTUSERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getCurrentUsername().hashCode();
    hash = (37 * hash) + OLDPASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getOldPassword().hashCode();
    hash = (37 * hash) + NEWPASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getNewPassword().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ChangePasswordRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangePasswordRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangePasswordRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangePasswordRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangePasswordRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ChangePasswordRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ChangePasswordRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ChangePasswordRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ChangePasswordRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ChangePasswordRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ChangePasswordRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ChangePasswordRequest parseFrom(
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
  public static Builder newBuilder(ChangePasswordRequest prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.ChangePasswordRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.ChangePasswordRequest)
          ChangePasswordRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ChangePasswordRequest.class, ChangePasswordRequest.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.ChangePasswordRequest.newBuilder()
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
      currentUsername_ = "";

      oldPassword_ = "";

      newPassword_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor;
    }

    public ChangePasswordRequest getDefaultInstanceForType() {
      return ChangePasswordRequest.getDefaultInstance();
    }

    public ChangePasswordRequest build() {
      ChangePasswordRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ChangePasswordRequest buildPartial() {
      ChangePasswordRequest result = new ChangePasswordRequest(this);
      result.currentUsername_ = currentUsername_;
      result.oldPassword_ = oldPassword_;
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
      if (other instanceof ChangePasswordRequest) {
        return mergeFrom((ChangePasswordRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ChangePasswordRequest other) {
      if (other == ChangePasswordRequest.getDefaultInstance()) return this;
      if (!other.getCurrentUsername().isEmpty()) {
        currentUsername_ = other.currentUsername_;
        onChanged();
      }
      if (!other.getOldPassword().isEmpty()) {
        oldPassword_ = other.oldPassword_;
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
      ChangePasswordRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ChangePasswordRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object currentUsername_ = "";
    /**
     * <code>string currentUsername = 1;</code>
     */
    public java.lang.String getCurrentUsername() {
      java.lang.Object ref = currentUsername_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        currentUsername_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string currentUsername = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCurrentUsernameBytes() {
      java.lang.Object ref = currentUsername_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        currentUsername_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string currentUsername = 1;</code>
     */
    public Builder setCurrentUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      currentUsername_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string currentUsername = 1;</code>
     */
    public Builder clearCurrentUsername() {
      
      currentUsername_ = getDefaultInstance().getCurrentUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string currentUsername = 1;</code>
     */
    public Builder setCurrentUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      currentUsername_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object oldPassword_ = "";
    /**
     * <code>string oldPassword = 2;</code>
     */
    public java.lang.String getOldPassword() {
      java.lang.Object ref = oldPassword_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        oldPassword_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string oldPassword = 2;</code>
     */
    public com.google.protobuf.ByteString
        getOldPasswordBytes() {
      java.lang.Object ref = oldPassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        oldPassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string oldPassword = 2;</code>
     */
    public Builder setOldPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      oldPassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string oldPassword = 2;</code>
     */
    public Builder clearOldPassword() {
      
      oldPassword_ = getDefaultInstance().getOldPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string oldPassword = 2;</code>
     */
    public Builder setOldPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      oldPassword_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object newPassword_ = "";
    /**
     * <code>string newPassword = 3;</code>
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
     * <code>string newPassword = 3;</code>
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
     * <code>string newPassword = 3;</code>
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
     * <code>string newPassword = 3;</code>
     */
    public Builder clearNewPassword() {
      
      newPassword_ = getDefaultInstance().getNewPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string newPassword = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.ChangePasswordRequest)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.ChangePasswordRequest)
  private static final ChangePasswordRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ChangePasswordRequest();
  }

  public static ChangePasswordRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChangePasswordRequest>
      PARSER = new com.google.protobuf.AbstractParser<ChangePasswordRequest>() {
    public ChangePasswordRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChangePasswordRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChangePasswordRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChangePasswordRequest> getParserForType() {
    return PARSER;
  }

  public ChangePasswordRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

