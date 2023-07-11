// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.SendMessageToUserRequest}
 */
public  final class SendMessageToUserRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.SendMessageToUserRequest)
    SendMessageToUserRequestOrBuilder {
  // Use SendMessageToUserRequest.newBuilder() to construct.
  private SendMessageToUserRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SendMessageToUserRequest() {
    text_ = "";
    senderId_ = 0L;
    recipientId_ = 0L;
    senderName_ = "";
    recipientName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SendMessageToUserRequest(
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

            text_ = s;
            break;
          }
          case 16: {

            senderId_ = input.readInt64();
            break;
          }
          case 24: {

            recipientId_ = input.readInt64();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            senderName_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            recipientName_ = s;
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
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_SendMessageToUserRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_SendMessageToUserRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.SendMessageToUserRequest.class, com.tsemkalo.businesscards.SendMessageToUserRequest.Builder.class);
  }

  public static final int TEXT_FIELD_NUMBER = 1;
  private volatile java.lang.Object text_;
  /**
   * <code>string text = 1;</code>
   */
  public java.lang.String getText() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      text_ = s;
      return s;
    }
  }
  /**
   * <code>string text = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      text_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SENDERID_FIELD_NUMBER = 2;
  private long senderId_;
  /**
   * <code>int64 senderId = 2;</code>
   */
  public long getSenderId() {
    return senderId_;
  }

  public static final int RECIPIENTID_FIELD_NUMBER = 3;
  private long recipientId_;
  /**
   * <code>int64 recipientId = 3;</code>
   */
  public long getRecipientId() {
    return recipientId_;
  }

  public static final int SENDERNAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object senderName_;
  /**
   * <code>string senderName = 4;</code>
   */
  public java.lang.String getSenderName() {
    java.lang.Object ref = senderName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      senderName_ = s;
      return s;
    }
  }
  /**
   * <code>string senderName = 4;</code>
   */
  public com.google.protobuf.ByteString
      getSenderNameBytes() {
    java.lang.Object ref = senderName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      senderName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RECIPIENTNAME_FIELD_NUMBER = 5;
  private volatile java.lang.Object recipientName_;
  /**
   * <code>string recipientName = 5;</code>
   */
  public java.lang.String getRecipientName() {
    java.lang.Object ref = recipientName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      recipientName_ = s;
      return s;
    }
  }
  /**
   * <code>string recipientName = 5;</code>
   */
  public com.google.protobuf.ByteString
      getRecipientNameBytes() {
    java.lang.Object ref = recipientName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      recipientName_ = b;
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
    if (!getTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, text_);
    }
    if (senderId_ != 0L) {
      output.writeInt64(2, senderId_);
    }
    if (recipientId_ != 0L) {
      output.writeInt64(3, recipientId_);
    }
    if (!getSenderNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, senderName_);
    }
    if (!getRecipientNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, recipientName_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, text_);
    }
    if (senderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, senderId_);
    }
    if (recipientId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, recipientId_);
    }
    if (!getSenderNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, senderName_);
    }
    if (!getRecipientNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, recipientName_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.SendMessageToUserRequest)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.SendMessageToUserRequest other = (com.tsemkalo.businesscards.SendMessageToUserRequest) obj;

    boolean result = true;
    result = result && getText()
        .equals(other.getText());
    result = result && (getSenderId()
        == other.getSenderId());
    result = result && (getRecipientId()
        == other.getRecipientId());
    result = result && getSenderName()
        .equals(other.getSenderName());
    result = result && getRecipientName()
        .equals(other.getRecipientName());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TEXT_FIELD_NUMBER;
    hash = (53 * hash) + getText().hashCode();
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSenderId());
    hash = (37 * hash) + RECIPIENTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRecipientId());
    hash = (37 * hash) + SENDERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getSenderName().hashCode();
    hash = (37 * hash) + RECIPIENTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getRecipientName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SendMessageToUserRequest parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.SendMessageToUserRequest prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.SendMessageToUserRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.SendMessageToUserRequest)
      com.tsemkalo.businesscards.SendMessageToUserRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_SendMessageToUserRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_SendMessageToUserRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.SendMessageToUserRequest.class, com.tsemkalo.businesscards.SendMessageToUserRequest.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.SendMessageToUserRequest.newBuilder()
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
      text_ = "";

      senderId_ = 0L;

      recipientId_ = 0L;

      senderName_ = "";

      recipientName_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_SendMessageToUserRequest_descriptor;
    }

    public com.tsemkalo.businesscards.SendMessageToUserRequest getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.SendMessageToUserRequest.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.SendMessageToUserRequest build() {
      com.tsemkalo.businesscards.SendMessageToUserRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.SendMessageToUserRequest buildPartial() {
      com.tsemkalo.businesscards.SendMessageToUserRequest result = new com.tsemkalo.businesscards.SendMessageToUserRequest(this);
      result.text_ = text_;
      result.senderId_ = senderId_;
      result.recipientId_ = recipientId_;
      result.senderName_ = senderName_;
      result.recipientName_ = recipientName_;
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
      if (other instanceof com.tsemkalo.businesscards.SendMessageToUserRequest) {
        return mergeFrom((com.tsemkalo.businesscards.SendMessageToUserRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.SendMessageToUserRequest other) {
      if (other == com.tsemkalo.businesscards.SendMessageToUserRequest.getDefaultInstance()) return this;
      if (!other.getText().isEmpty()) {
        text_ = other.text_;
        onChanged();
      }
      if (other.getSenderId() != 0L) {
        setSenderId(other.getSenderId());
      }
      if (other.getRecipientId() != 0L) {
        setRecipientId(other.getRecipientId());
      }
      if (!other.getSenderName().isEmpty()) {
        senderName_ = other.senderName_;
        onChanged();
      }
      if (!other.getRecipientName().isEmpty()) {
        recipientName_ = other.recipientName_;
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
      com.tsemkalo.businesscards.SendMessageToUserRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.SendMessageToUserRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object text_ = "";
    /**
     * <code>string text = 1;</code>
     */
    public java.lang.String getText() {
      java.lang.Object ref = text_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        text_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string text = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      java.lang.Object ref = text_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        text_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder setText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      text_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder clearText() {
      
      text_ = getDefaultInstance().getText();
      onChanged();
      return this;
    }
    /**
     * <code>string text = 1;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      text_ = value;
      onChanged();
      return this;
    }

    private long senderId_ ;
    /**
     * <code>int64 senderId = 2;</code>
     */
    public long getSenderId() {
      return senderId_;
    }
    /**
     * <code>int64 senderId = 2;</code>
     */
    public Builder setSenderId(long value) {
      
      senderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 senderId = 2;</code>
     */
    public Builder clearSenderId() {
      
      senderId_ = 0L;
      onChanged();
      return this;
    }

    private long recipientId_ ;
    /**
     * <code>int64 recipientId = 3;</code>
     */
    public long getRecipientId() {
      return recipientId_;
    }
    /**
     * <code>int64 recipientId = 3;</code>
     */
    public Builder setRecipientId(long value) {
      
      recipientId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 recipientId = 3;</code>
     */
    public Builder clearRecipientId() {
      
      recipientId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object senderName_ = "";
    /**
     * <code>string senderName = 4;</code>
     */
    public java.lang.String getSenderName() {
      java.lang.Object ref = senderName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        senderName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string senderName = 4;</code>
     */
    public com.google.protobuf.ByteString
        getSenderNameBytes() {
      java.lang.Object ref = senderName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        senderName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string senderName = 4;</code>
     */
    public Builder setSenderName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      senderName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string senderName = 4;</code>
     */
    public Builder clearSenderName() {
      
      senderName_ = getDefaultInstance().getSenderName();
      onChanged();
      return this;
    }
    /**
     * <code>string senderName = 4;</code>
     */
    public Builder setSenderNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      senderName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object recipientName_ = "";
    /**
     * <code>string recipientName = 5;</code>
     */
    public java.lang.String getRecipientName() {
      java.lang.Object ref = recipientName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        recipientName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string recipientName = 5;</code>
     */
    public com.google.protobuf.ByteString
        getRecipientNameBytes() {
      java.lang.Object ref = recipientName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        recipientName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string recipientName = 5;</code>
     */
    public Builder setRecipientName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      recipientName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string recipientName = 5;</code>
     */
    public Builder clearRecipientName() {
      
      recipientName_ = getDefaultInstance().getRecipientName();
      onChanged();
      return this;
    }
    /**
     * <code>string recipientName = 5;</code>
     */
    public Builder setRecipientNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      recipientName_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.SendMessageToUserRequest)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.SendMessageToUserRequest)
  private static final com.tsemkalo.businesscards.SendMessageToUserRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.SendMessageToUserRequest();
  }

  public static com.tsemkalo.businesscards.SendMessageToUserRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SendMessageToUserRequest>
      PARSER = new com.google.protobuf.AbstractParser<SendMessageToUserRequest>() {
    public SendMessageToUserRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SendMessageToUserRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SendMessageToUserRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SendMessageToUserRequest> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.SendMessageToUserRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
