// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.MessageProto}
 */
public  final class MessageProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.MessageProto)
    MessageProtoOrBuilder {
  // Use MessageProto.newBuilder() to construct.
  private MessageProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageProto() {
    id_ = 0L;
    memberId_ = 0L;
    chatId_ = 0L;
    text_ = "";
    read_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MessageProto(
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

            id_ = input.readInt64();
            break;
          }
          case 16: {

            memberId_ = input.readInt64();
            break;
          }
          case 24: {

            chatId_ = input.readInt64();
            break;
          }
          case 34: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (sendingTime_ != null) {
              subBuilder = sendingTime_.toBuilder();
            }
            sendingTime_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(sendingTime_);
              sendingTime_ = subBuilder.buildPartial();
            }

            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            text_ = s;
            break;
          }
          case 48: {

            read_ = input.readBool();
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
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.MessageProto.class, com.tsemkalo.businesscards.MessageProto.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int MEMBERID_FIELD_NUMBER = 2;
  private long memberId_;
  /**
   * <code>int64 memberId = 2;</code>
   */
  public long getMemberId() {
    return memberId_;
  }

  public static final int CHATID_FIELD_NUMBER = 3;
  private long chatId_;
  /**
   * <code>int64 chatId = 3;</code>
   */
  public long getChatId() {
    return chatId_;
  }

  public static final int SENDINGTIME_FIELD_NUMBER = 4;
  private com.google.protobuf.Timestamp sendingTime_;
  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  public boolean hasSendingTime() {
    return sendingTime_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  public com.google.protobuf.Timestamp getSendingTime() {
    return sendingTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : sendingTime_;
  }
  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  public com.google.protobuf.TimestampOrBuilder getSendingTimeOrBuilder() {
    return getSendingTime();
  }

  public static final int TEXT_FIELD_NUMBER = 5;
  private volatile java.lang.Object text_;
  /**
   * <code>string text = 5;</code>
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
   * <code>string text = 5;</code>
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

  public static final int READ_FIELD_NUMBER = 6;
  private boolean read_;
  /**
   * <code>bool read = 6;</code>
   */
  public boolean getRead() {
    return read_;
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
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (memberId_ != 0L) {
      output.writeInt64(2, memberId_);
    }
    if (chatId_ != 0L) {
      output.writeInt64(3, chatId_);
    }
    if (sendingTime_ != null) {
      output.writeMessage(4, getSendingTime());
    }
    if (!getTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, text_);
    }
    if (read_ != false) {
      output.writeBool(6, read_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (memberId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, memberId_);
    }
    if (chatId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, chatId_);
    }
    if (sendingTime_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getSendingTime());
    }
    if (!getTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, text_);
    }
    if (read_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(6, read_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.MessageProto)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.MessageProto other = (com.tsemkalo.businesscards.MessageProto) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (getMemberId()
        == other.getMemberId());
    result = result && (getChatId()
        == other.getChatId());
    result = result && (hasSendingTime() == other.hasSendingTime());
    if (hasSendingTime()) {
      result = result && getSendingTime()
          .equals(other.getSendingTime());
    }
    result = result && getText()
        .equals(other.getText());
    result = result && (getRead()
        == other.getRead());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + MEMBERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMemberId());
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getChatId());
    if (hasSendingTime()) {
      hash = (37 * hash) + SENDINGTIME_FIELD_NUMBER;
      hash = (53 * hash) + getSendingTime().hashCode();
    }
    hash = (37 * hash) + TEXT_FIELD_NUMBER;
    hash = (53 * hash) + getText().hashCode();
    hash = (37 * hash) + READ_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getRead());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.MessageProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.MessageProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.MessageProto parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.MessageProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.MessageProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.MessageProto)
      com.tsemkalo.businesscards.MessageProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.MessageProto.class, com.tsemkalo.businesscards.MessageProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.MessageProto.newBuilder()
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
      id_ = 0L;

      memberId_ = 0L;

      chatId_ = 0L;

      if (sendingTimeBuilder_ == null) {
        sendingTime_ = null;
      } else {
        sendingTime_ = null;
        sendingTimeBuilder_ = null;
      }
      text_ = "";

      read_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProto_descriptor;
    }

    public com.tsemkalo.businesscards.MessageProto getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.MessageProto.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.MessageProto build() {
      com.tsemkalo.businesscards.MessageProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.MessageProto buildPartial() {
      com.tsemkalo.businesscards.MessageProto result = new com.tsemkalo.businesscards.MessageProto(this);
      result.id_ = id_;
      result.memberId_ = memberId_;
      result.chatId_ = chatId_;
      if (sendingTimeBuilder_ == null) {
        result.sendingTime_ = sendingTime_;
      } else {
        result.sendingTime_ = sendingTimeBuilder_.build();
      }
      result.text_ = text_;
      result.read_ = read_;
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
      if (other instanceof com.tsemkalo.businesscards.MessageProto) {
        return mergeFrom((com.tsemkalo.businesscards.MessageProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.MessageProto other) {
      if (other == com.tsemkalo.businesscards.MessageProto.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getMemberId() != 0L) {
        setMemberId(other.getMemberId());
      }
      if (other.getChatId() != 0L) {
        setChatId(other.getChatId());
      }
      if (other.hasSendingTime()) {
        mergeSendingTime(other.getSendingTime());
      }
      if (!other.getText().isEmpty()) {
        text_ = other.text_;
        onChanged();
      }
      if (other.getRead() != false) {
        setRead(other.getRead());
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
      com.tsemkalo.businesscards.MessageProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.MessageProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_ ;
    /**
     * <code>int64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 1;</code>
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private long memberId_ ;
    /**
     * <code>int64 memberId = 2;</code>
     */
    public long getMemberId() {
      return memberId_;
    }
    /**
     * <code>int64 memberId = 2;</code>
     */
    public Builder setMemberId(long value) {
      
      memberId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 memberId = 2;</code>
     */
    public Builder clearMemberId() {
      
      memberId_ = 0L;
      onChanged();
      return this;
    }

    private long chatId_ ;
    /**
     * <code>int64 chatId = 3;</code>
     */
    public long getChatId() {
      return chatId_;
    }
    /**
     * <code>int64 chatId = 3;</code>
     */
    public Builder setChatId(long value) {
      
      chatId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 chatId = 3;</code>
     */
    public Builder clearChatId() {
      
      chatId_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp sendingTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> sendingTimeBuilder_;
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public boolean hasSendingTime() {
      return sendingTimeBuilder_ != null || sendingTime_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public com.google.protobuf.Timestamp getSendingTime() {
      if (sendingTimeBuilder_ == null) {
        return sendingTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : sendingTime_;
      } else {
        return sendingTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public Builder setSendingTime(com.google.protobuf.Timestamp value) {
      if (sendingTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        sendingTime_ = value;
        onChanged();
      } else {
        sendingTimeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public Builder setSendingTime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (sendingTimeBuilder_ == null) {
        sendingTime_ = builderForValue.build();
        onChanged();
      } else {
        sendingTimeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public Builder mergeSendingTime(com.google.protobuf.Timestamp value) {
      if (sendingTimeBuilder_ == null) {
        if (sendingTime_ != null) {
          sendingTime_ =
            com.google.protobuf.Timestamp.newBuilder(sendingTime_).mergeFrom(value).buildPartial();
        } else {
          sendingTime_ = value;
        }
        onChanged();
      } else {
        sendingTimeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public Builder clearSendingTime() {
      if (sendingTimeBuilder_ == null) {
        sendingTime_ = null;
        onChanged();
      } else {
        sendingTime_ = null;
        sendingTimeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public com.google.protobuf.Timestamp.Builder getSendingTimeBuilder() {
      
      onChanged();
      return getSendingTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getSendingTimeOrBuilder() {
      if (sendingTimeBuilder_ != null) {
        return sendingTimeBuilder_.getMessageOrBuilder();
      } else {
        return sendingTime_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : sendingTime_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getSendingTimeFieldBuilder() {
      if (sendingTimeBuilder_ == null) {
        sendingTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getSendingTime(),
                getParentForChildren(),
                isClean());
        sendingTime_ = null;
      }
      return sendingTimeBuilder_;
    }

    private java.lang.Object text_ = "";
    /**
     * <code>string text = 5;</code>
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
     * <code>string text = 5;</code>
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
     * <code>string text = 5;</code>
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
     * <code>string text = 5;</code>
     */
    public Builder clearText() {
      
      text_ = getDefaultInstance().getText();
      onChanged();
      return this;
    }
    /**
     * <code>string text = 5;</code>
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

    private boolean read_ ;
    /**
     * <code>bool read = 6;</code>
     */
    public boolean getRead() {
      return read_;
    }
    /**
     * <code>bool read = 6;</code>
     */
    public Builder setRead(boolean value) {
      
      read_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool read = 6;</code>
     */
    public Builder clearRead() {
      
      read_ = false;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.MessageProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.MessageProto)
  private static final com.tsemkalo.businesscards.MessageProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.MessageProto();
  }

  public static com.tsemkalo.businesscards.MessageProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageProto>
      PARSER = new com.google.protobuf.AbstractParser<MessageProto>() {
    public MessageProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageProto> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.MessageProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
