// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.ChatUserIdList}
 */
public  final class ChatUserIdList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.ChatUserIdList)
    ChatUserIdListOrBuilder {
  // Use ChatUserIdList.newBuilder() to construct.
  private ChatUserIdList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatUserIdList() {
    userId_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ChatUserIdList(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              userId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            userId_.add(input.readInt64());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              userId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              userId_.add(input.readInt64());
            }
            input.popLimit(limit);
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
        userId_ = java.util.Collections.unmodifiableList(userId_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserIdList_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserIdList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.ChatUserIdList.class, com.tsemkalo.businesscards.ChatUserIdList.Builder.class);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Long> userId_;
  /**
   * <code>repeated int64 userId = 1;</code>
   */
  public java.util.List<java.lang.Long>
      getUserIdList() {
    return userId_;
  }
  /**
   * <code>repeated int64 userId = 1;</code>
   */
  public int getUserIdCount() {
    return userId_.size();
  }
  /**
   * <code>repeated int64 userId = 1;</code>
   */
  public long getUserId(int index) {
    return userId_.get(index);
  }
  private int userIdMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (getUserIdList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(userIdMemoizedSerializedSize);
    }
    for (int i = 0; i < userId_.size(); i++) {
      output.writeInt64NoTag(userId_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < userId_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(userId_.get(i));
      }
      size += dataSize;
      if (!getUserIdList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      userIdMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof com.tsemkalo.businesscards.ChatUserIdList)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.ChatUserIdList other = (com.tsemkalo.businesscards.ChatUserIdList) obj;

    boolean result = true;
    result = result && getUserIdList()
        .equals(other.getUserIdList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getUserIdCount() > 0) {
      hash = (37 * hash) + USERID_FIELD_NUMBER;
      hash = (53 * hash) + getUserIdList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.ChatUserIdList parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.ChatUserIdList prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.ChatUserIdList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.ChatUserIdList)
      com.tsemkalo.businesscards.ChatUserIdListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserIdList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserIdList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.ChatUserIdList.class, com.tsemkalo.businesscards.ChatUserIdList.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.ChatUserIdList.newBuilder()
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
      userId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_ChatUserIdList_descriptor;
    }

    public com.tsemkalo.businesscards.ChatUserIdList getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.ChatUserIdList.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.ChatUserIdList build() {
      com.tsemkalo.businesscards.ChatUserIdList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.ChatUserIdList buildPartial() {
      com.tsemkalo.businesscards.ChatUserIdList result = new com.tsemkalo.businesscards.ChatUserIdList(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        userId_ = java.util.Collections.unmodifiableList(userId_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
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
      if (other instanceof com.tsemkalo.businesscards.ChatUserIdList) {
        return mergeFrom((com.tsemkalo.businesscards.ChatUserIdList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.ChatUserIdList other) {
      if (other == com.tsemkalo.businesscards.ChatUserIdList.getDefaultInstance()) return this;
      if (!other.userId_.isEmpty()) {
        if (userId_.isEmpty()) {
          userId_ = other.userId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureUserIdIsMutable();
          userId_.addAll(other.userId_);
        }
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
      com.tsemkalo.businesscards.ChatUserIdList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.ChatUserIdList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Long> userId_ = java.util.Collections.emptyList();
    private void ensureUserIdIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        userId_ = new java.util.ArrayList<java.lang.Long>(userId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public java.util.List<java.lang.Long>
        getUserIdList() {
      return java.util.Collections.unmodifiableList(userId_);
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public int getUserIdCount() {
      return userId_.size();
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public long getUserId(int index) {
      return userId_.get(index);
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public Builder setUserId(
        int index, long value) {
      ensureUserIdIsMutable();
      userId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public Builder addUserId(long value) {
      ensureUserIdIsMutable();
      userId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public Builder addAllUserId(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureUserIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, userId_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userId = 1;</code>
     */
    public Builder clearUserId() {
      userId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.ChatUserIdList)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.ChatUserIdList)
  private static final com.tsemkalo.businesscards.ChatUserIdList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.ChatUserIdList();
  }

  public static com.tsemkalo.businesscards.ChatUserIdList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatUserIdList>
      PARSER = new com.google.protobuf.AbstractParser<ChatUserIdList>() {
    public ChatUserIdList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChatUserIdList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatUserIdList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatUserIdList> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.ChatUserIdList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
