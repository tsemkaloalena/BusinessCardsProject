// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.MessageProtoList}
 */
public  final class MessageProtoList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.MessageProtoList)
    MessageProtoListOrBuilder {
  // Use MessageProtoList.newBuilder() to construct.
  private MessageProtoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageProtoList() {
    message_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MessageProtoList(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              message_ = new java.util.ArrayList<MessageProto>();
              mutable_bitField0_ |= 0x00000001;
            }
            message_.add(
                input.readMessage(MessageProto.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        message_ = java.util.Collections.unmodifiableList(message_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProtoList_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProtoList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MessageProtoList.class, MessageProtoList.Builder.class);
  }

  public static final int MESSAGE_FIELD_NUMBER = 1;
  private java.util.List<MessageProto> message_;
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
   */
  public java.util.List<MessageProto> getMessageList() {
    return message_;
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
   */
  public java.util.List<? extends MessageProtoOrBuilder>
      getMessageOrBuilderList() {
    return message_;
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
   */
  public int getMessageCount() {
    return message_.size();
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
   */
  public MessageProto getMessage(int index) {
    return message_.get(index);
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
   */
  public MessageProtoOrBuilder getMessageOrBuilder(
      int index) {
    return message_.get(index);
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
    for (int i = 0; i < message_.size(); i++) {
      output.writeMessage(1, message_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < message_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, message_.get(i));
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
    if (!(obj instanceof MessageProtoList)) {
      return super.equals(obj);
    }
    MessageProtoList other = (MessageProtoList) obj;

    boolean result = true;
    result = result && getMessageList()
        .equals(other.getMessageList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMessageCount() > 0) {
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MessageProtoList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProtoList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProtoList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProtoList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProtoList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProtoList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProtoList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MessageProtoList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MessageProtoList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MessageProtoList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MessageProtoList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MessageProtoList parseFrom(
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
  public static Builder newBuilder(MessageProtoList prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.MessageProtoList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.MessageProtoList)
          MessageProtoListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProtoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProtoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MessageProtoList.class, MessageProtoList.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.MessageProtoList.newBuilder()
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
        getMessageFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (messageBuilder_ == null) {
        message_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        messageBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_MessageProtoList_descriptor;
    }

    public MessageProtoList getDefaultInstanceForType() {
      return MessageProtoList.getDefaultInstance();
    }

    public MessageProtoList build() {
      MessageProtoList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public MessageProtoList buildPartial() {
      MessageProtoList result = new MessageProtoList(this);
      int from_bitField0_ = bitField0_;
      if (messageBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          message_ = java.util.Collections.unmodifiableList(message_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.message_ = message_;
      } else {
        result.message_ = messageBuilder_.build();
      }
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
      if (other instanceof MessageProtoList) {
        return mergeFrom((MessageProtoList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MessageProtoList other) {
      if (other == MessageProtoList.getDefaultInstance()) return this;
      if (messageBuilder_ == null) {
        if (!other.message_.isEmpty()) {
          if (message_.isEmpty()) {
            message_ = other.message_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMessageIsMutable();
            message_.addAll(other.message_);
          }
          onChanged();
        }
      } else {
        if (!other.message_.isEmpty()) {
          if (messageBuilder_.isEmpty()) {
            messageBuilder_.dispose();
            messageBuilder_ = null;
            message_ = other.message_;
            bitField0_ = (bitField0_ & ~0x00000001);
            messageBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMessageFieldBuilder() : null;
          } else {
            messageBuilder_.addAllMessages(other.message_);
          }
        }
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
      MessageProtoList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MessageProtoList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<MessageProto> message_ =
      java.util.Collections.emptyList();
    private void ensureMessageIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        message_ = new java.util.ArrayList<MessageProto>(message_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            MessageProto, MessageProto.Builder, MessageProtoOrBuilder> messageBuilder_;

    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public java.util.List<MessageProto> getMessageList() {
      if (messageBuilder_ == null) {
        return java.util.Collections.unmodifiableList(message_);
      } else {
        return messageBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public int getMessageCount() {
      if (messageBuilder_ == null) {
        return message_.size();
      } else {
        return messageBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public MessageProto getMessage(int index) {
      if (messageBuilder_ == null) {
        return message_.get(index);
      } else {
        return messageBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder setMessage(
        int index, MessageProto value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageIsMutable();
        message_.set(index, value);
        onChanged();
      } else {
        messageBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder setMessage(
        int index, MessageProto.Builder builderForValue) {
      if (messageBuilder_ == null) {
        ensureMessageIsMutable();
        message_.set(index, builderForValue.build());
        onChanged();
      } else {
        messageBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder addMessage(MessageProto value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageIsMutable();
        message_.add(value);
        onChanged();
      } else {
        messageBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder addMessage(
        int index, MessageProto value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessageIsMutable();
        message_.add(index, value);
        onChanged();
      } else {
        messageBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder addMessage(
        MessageProto.Builder builderForValue) {
      if (messageBuilder_ == null) {
        ensureMessageIsMutable();
        message_.add(builderForValue.build());
        onChanged();
      } else {
        messageBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder addMessage(
        int index, MessageProto.Builder builderForValue) {
      if (messageBuilder_ == null) {
        ensureMessageIsMutable();
        message_.add(index, builderForValue.build());
        onChanged();
      } else {
        messageBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder addAllMessage(
        java.lang.Iterable<? extends MessageProto> values) {
      if (messageBuilder_ == null) {
        ensureMessageIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, message_);
        onChanged();
      } else {
        messageBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder clearMessage() {
      if (messageBuilder_ == null) {
        message_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        messageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public Builder removeMessage(int index) {
      if (messageBuilder_ == null) {
        ensureMessageIsMutable();
        message_.remove(index);
        onChanged();
      } else {
        messageBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public MessageProto.Builder getMessageBuilder(
        int index) {
      return getMessageFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public MessageProtoOrBuilder getMessageOrBuilder(
        int index) {
      if (messageBuilder_ == null) {
        return message_.get(index);  } else {
        return messageBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public java.util.List<? extends MessageProtoOrBuilder>
         getMessageOrBuilderList() {
      if (messageBuilder_ != null) {
        return messageBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(message_);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public MessageProto.Builder addMessageBuilder() {
      return getMessageFieldBuilder().addBuilder(
          MessageProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public MessageProto.Builder addMessageBuilder(
        int index) {
      return getMessageFieldBuilder().addBuilder(
          index, MessageProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.generated.MessageProto message = 1;</code>
     */
    public java.util.List<MessageProto.Builder>
         getMessageBuilderList() {
      return getMessageFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
            MessageProto, MessageProto.Builder, MessageProtoOrBuilder>
        getMessageFieldBuilder() {
      if (messageBuilder_ == null) {
        messageBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                MessageProto, MessageProto.Builder, MessageProtoOrBuilder>(
                message_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        message_ = null;
      }
      return messageBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.MessageProtoList)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.MessageProtoList)
  private static final MessageProtoList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MessageProtoList();
  }

  public static MessageProtoList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageProtoList>
      PARSER = new com.google.protobuf.AbstractParser<MessageProtoList>() {
    public MessageProtoList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageProtoList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageProtoList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageProtoList> getParserForType() {
    return PARSER;
  }

  public MessageProtoList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
