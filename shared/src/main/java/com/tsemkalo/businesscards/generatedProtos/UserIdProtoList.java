// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.UserIdProtoList}
 */
public  final class UserIdProtoList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.UserIdProtoList)
    UserIdProtoListOrBuilder {
  // Use UserIdProtoList.newBuilder() to construct.
  private UserIdProtoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserIdProtoList() {
    userIds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UserIdProtoList(
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
              userIds_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            userIds_.add(input.readInt64());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              userIds_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              userIds_.add(input.readInt64());
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
        userIds_ = java.util.Collections.unmodifiableList(userIds_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_UserIdProtoList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            UserIdProtoList.class, UserIdProtoList.Builder.class);
  }

  public static final int USERIDS_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Long> userIds_;
  /**
   * <code>repeated int64 userIds = 1;</code>
   */
  public java.util.List<java.lang.Long>
      getUserIdsList() {
    return userIds_;
  }
  /**
   * <code>repeated int64 userIds = 1;</code>
   */
  public int getUserIdsCount() {
    return userIds_.size();
  }
  /**
   * <code>repeated int64 userIds = 1;</code>
   */
  public long getUserIds(int index) {
    return userIds_.get(index);
  }
  private int userIdsMemoizedSerializedSize = -1;

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
    if (getUserIdsList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(userIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < userIds_.size(); i++) {
      output.writeInt64NoTag(userIds_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < userIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(userIds_.get(i));
      }
      size += dataSize;
      if (!getUserIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      userIdsMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof UserIdProtoList)) {
      return super.equals(obj);
    }
    UserIdProtoList other = (UserIdProtoList) obj;

    boolean result = true;
    result = result && getUserIdsList()
        .equals(other.getUserIdsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getUserIdsCount() > 0) {
      hash = (37 * hash) + USERIDS_FIELD_NUMBER;
      hash = (53 * hash) + getUserIdsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static UserIdProtoList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserIdProtoList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserIdProtoList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserIdProtoList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserIdProtoList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserIdProtoList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserIdProtoList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UserIdProtoList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static UserIdProtoList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static UserIdProtoList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static UserIdProtoList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UserIdProtoList parseFrom(
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
  public static Builder newBuilder(UserIdProtoList prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.UserIdProtoList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.UserIdProtoList)
          UserIdProtoListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_UserIdProtoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UserIdProtoList.class, UserIdProtoList.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.UserIdProtoList.newBuilder()
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
      userIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor;
    }

    public UserIdProtoList getDefaultInstanceForType() {
      return UserIdProtoList.getDefaultInstance();
    }

    public UserIdProtoList build() {
      UserIdProtoList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public UserIdProtoList buildPartial() {
      UserIdProtoList result = new UserIdProtoList(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        userIds_ = java.util.Collections.unmodifiableList(userIds_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.userIds_ = userIds_;
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
      if (other instanceof UserIdProtoList) {
        return mergeFrom((UserIdProtoList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UserIdProtoList other) {
      if (other == UserIdProtoList.getDefaultInstance()) return this;
      if (!other.userIds_.isEmpty()) {
        if (userIds_.isEmpty()) {
          userIds_ = other.userIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureUserIdsIsMutable();
          userIds_.addAll(other.userIds_);
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
      UserIdProtoList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UserIdProtoList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Long> userIds_ = java.util.Collections.emptyList();
    private void ensureUserIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        userIds_ = new java.util.ArrayList<java.lang.Long>(userIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public java.util.List<java.lang.Long>
        getUserIdsList() {
      return java.util.Collections.unmodifiableList(userIds_);
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public int getUserIdsCount() {
      return userIds_.size();
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public long getUserIds(int index) {
      return userIds_.get(index);
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public Builder setUserIds(
        int index, long value) {
      ensureUserIdsIsMutable();
      userIds_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public Builder addUserIds(long value) {
      ensureUserIdsIsMutable();
      userIds_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public Builder addAllUserIds(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureUserIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, userIds_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 userIds = 1;</code>
     */
    public Builder clearUserIds() {
      userIds_ = java.util.Collections.emptyList();
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.UserIdProtoList)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.UserIdProtoList)
  private static final UserIdProtoList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new UserIdProtoList();
  }

  public static UserIdProtoList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserIdProtoList>
      PARSER = new com.google.protobuf.AbstractParser<UserIdProtoList>() {
    public UserIdProtoList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserIdProtoList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserIdProtoList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserIdProtoList> getParserForType() {
    return PARSER;
  }

  public UserIdProtoList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
