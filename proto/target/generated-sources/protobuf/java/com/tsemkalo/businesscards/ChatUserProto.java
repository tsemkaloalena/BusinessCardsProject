// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.ChatUserProto}
 */
public  final class ChatUserProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.ChatUserProto)
    ChatUserProtoOrBuilder {
  // Use ChatUserProto.newBuilder() to construct.
  private ChatUserProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatUserProto() {
    chatId_ = 0L;
    userId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ChatUserProto(
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

            chatId_ = input.readInt64();
            break;
          }
          case 16: {

            userId_ = input.readInt64();
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
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.ChatUserProto.class, com.tsemkalo.businesscards.ChatUserProto.Builder.class);
  }

  public static final int CHATID_FIELD_NUMBER = 1;
  private long chatId_;
  /**
   * <code>int64 chatId = 1;</code>
   */
  public long getChatId() {
    return chatId_;
  }

  public static final int USERID_FIELD_NUMBER = 2;
  private long userId_;
  /**
   * <code>int64 userId = 2;</code>
   */
  public long getUserId() {
    return userId_;
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
    if (chatId_ != 0L) {
      output.writeInt64(1, chatId_);
    }
    if (userId_ != 0L) {
      output.writeInt64(2, userId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (chatId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, chatId_);
    }
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, userId_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.ChatUserProto)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.ChatUserProto other = (com.tsemkalo.businesscards.ChatUserProto) obj;

    boolean result = true;
    result = result && (getChatId()
        == other.getChatId());
    result = result && (getUserId()
        == other.getUserId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getChatId());
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserProto parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.ChatUserProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.ChatUserProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.ChatUserProto)
      com.tsemkalo.businesscards.ChatUserProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.ChatUserProto.class, com.tsemkalo.businesscards.ChatUserProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.ChatUserProto.newBuilder()
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
      chatId_ = 0L;

      userId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserProto_descriptor;
    }

    public com.tsemkalo.businesscards.ChatUserProto getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.ChatUserProto.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.ChatUserProto build() {
      com.tsemkalo.businesscards.ChatUserProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.ChatUserProto buildPartial() {
      com.tsemkalo.businesscards.ChatUserProto result = new com.tsemkalo.businesscards.ChatUserProto(this);
      result.chatId_ = chatId_;
      result.userId_ = userId_;
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
      if (other instanceof com.tsemkalo.businesscards.ChatUserProto) {
        return mergeFrom((com.tsemkalo.businesscards.ChatUserProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.ChatUserProto other) {
      if (other == com.tsemkalo.businesscards.ChatUserProto.getDefaultInstance()) return this;
      if (other.getChatId() != 0L) {
        setChatId(other.getChatId());
      }
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
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
      com.tsemkalo.businesscards.ChatUserProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.ChatUserProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long chatId_ ;
    /**
     * <code>int64 chatId = 1;</code>
     */
    public long getChatId() {
      return chatId_;
    }
    /**
     * <code>int64 chatId = 1;</code>
     */
    public Builder setChatId(long value) {
      
      chatId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 chatId = 1;</code>
     */
    public Builder clearChatId() {
      
      chatId_ = 0L;
      onChanged();
      return this;
    }

    private long userId_ ;
    /**
     * <code>int64 userId = 2;</code>
     */
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>int64 userId = 2;</code>
     */
    public Builder setUserId(long value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 userId = 2;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.ChatUserProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.ChatUserProto)
  private static final com.tsemkalo.businesscards.ChatUserProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.ChatUserProto();
  }

  public static com.tsemkalo.businesscards.ChatUserProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatUserProto>
      PARSER = new com.google.protobuf.AbstractParser<ChatUserProto>() {
    public ChatUserProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChatUserProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatUserProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatUserProto> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.ChatUserProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

