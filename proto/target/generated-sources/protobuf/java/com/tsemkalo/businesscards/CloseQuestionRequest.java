// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.CloseQuestionRequest}
 */
public  final class CloseQuestionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.CloseQuestionRequest)
    CloseQuestionRequestOrBuilder {
  // Use CloseQuestionRequest.newBuilder() to construct.
  private CloseQuestionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CloseQuestionRequest() {
    userId_ = 0L;
    chatId_ = 0L;
    isAdmin_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CloseQuestionRequest(
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
          case 8: {

            userId_ = input.readInt64();
            break;
          }
          case 16: {

            chatId_ = input.readInt64();
            break;
          }
          case 24: {

            isAdmin_ = input.readBool();
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
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_CloseQuestionRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_CloseQuestionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.CloseQuestionRequest.class, com.tsemkalo.businesscards.CloseQuestionRequest.Builder.class);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private long userId_;
  /**
   * <code>int64 userId = 1;</code>
   */
  public long getUserId() {
    return userId_;
  }

  public static final int CHATID_FIELD_NUMBER = 2;
  private long chatId_;
  /**
   * <code>int64 chatId = 2;</code>
   */
  public long getChatId() {
    return chatId_;
  }

  public static final int ISADMIN_FIELD_NUMBER = 3;
  private boolean isAdmin_;
  /**
   * <code>bool isAdmin = 3;</code>
   */
  public boolean getIsAdmin() {
    return isAdmin_;
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
    if (userId_ != 0L) {
      output.writeInt64(1, userId_);
    }
    if (chatId_ != 0L) {
      output.writeInt64(2, chatId_);
    }
    if (isAdmin_ != false) {
      output.writeBool(3, isAdmin_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, userId_);
    }
    if (chatId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, chatId_);
    }
    if (isAdmin_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, isAdmin_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.CloseQuestionRequest)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.CloseQuestionRequest other = (com.tsemkalo.businesscards.CloseQuestionRequest) obj;

    boolean result = true;
    result = result && (getUserId()
        == other.getUserId());
    result = result && (getChatId()
        == other.getChatId());
    result = result && (getIsAdmin()
        == other.getIsAdmin());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getChatId());
    hash = (37 * hash) + ISADMIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsAdmin());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.CloseQuestionRequest parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.CloseQuestionRequest prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.CloseQuestionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.CloseQuestionRequest)
      com.tsemkalo.businesscards.CloseQuestionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_CloseQuestionRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_CloseQuestionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.CloseQuestionRequest.class, com.tsemkalo.businesscards.CloseQuestionRequest.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.CloseQuestionRequest.newBuilder()
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
      userId_ = 0L;

      chatId_ = 0L;

      isAdmin_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_CloseQuestionRequest_descriptor;
    }

    public com.tsemkalo.businesscards.CloseQuestionRequest getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.CloseQuestionRequest.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.CloseQuestionRequest build() {
      com.tsemkalo.businesscards.CloseQuestionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.CloseQuestionRequest buildPartial() {
      com.tsemkalo.businesscards.CloseQuestionRequest result = new com.tsemkalo.businesscards.CloseQuestionRequest(this);
      result.userId_ = userId_;
      result.chatId_ = chatId_;
      result.isAdmin_ = isAdmin_;
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
      if (other instanceof com.tsemkalo.businesscards.CloseQuestionRequest) {
        return mergeFrom((com.tsemkalo.businesscards.CloseQuestionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.CloseQuestionRequest other) {
      if (other == com.tsemkalo.businesscards.CloseQuestionRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      if (other.getChatId() != 0L) {
        setChatId(other.getChatId());
      }
      if (other.getIsAdmin() != false) {
        setIsAdmin(other.getIsAdmin());
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
      com.tsemkalo.businesscards.CloseQuestionRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.CloseQuestionRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long userId_ ;
    /**
     * <code>int64 userId = 1;</code>
     */
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>int64 userId = 1;</code>
     */
    public Builder setUserId(long value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0L;
      onChanged();
      return this;
    }

    private long chatId_ ;
    /**
     * <code>int64 chatId = 2;</code>
     */
    public long getChatId() {
      return chatId_;
    }
    /**
     * <code>int64 chatId = 2;</code>
     */
    public Builder setChatId(long value) {
      
      chatId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 chatId = 2;</code>
     */
    public Builder clearChatId() {
      
      chatId_ = 0L;
      onChanged();
      return this;
    }

    private boolean isAdmin_ ;
    /**
     * <code>bool isAdmin = 3;</code>
     */
    public boolean getIsAdmin() {
      return isAdmin_;
    }
    /**
     * <code>bool isAdmin = 3;</code>
     */
    public Builder setIsAdmin(boolean value) {
      
      isAdmin_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isAdmin = 3;</code>
     */
    public Builder clearIsAdmin() {
      
      isAdmin_ = false;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.CloseQuestionRequest)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.CloseQuestionRequest)
  private static final com.tsemkalo.businesscards.CloseQuestionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.CloseQuestionRequest();
  }

  public static com.tsemkalo.businesscards.CloseQuestionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CloseQuestionRequest>
      PARSER = new com.google.protobuf.AbstractParser<CloseQuestionRequest>() {
    public CloseQuestionRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CloseQuestionRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CloseQuestionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CloseQuestionRequest> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.CloseQuestionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

