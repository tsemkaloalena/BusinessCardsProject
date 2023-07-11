// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.FollowProto}
 */
public  final class FollowProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.FollowProto)
    FollowProtoOrBuilder {
  // Use FollowProto.newBuilder() to construct.
  private FollowProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FollowProto() {
    id_ = 0L;
    userId_ = 0L;
    cardId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private FollowProto(
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

            userId_ = input.readInt64();
            break;
          }
          case 24: {

            cardId_ = input.readInt64();
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
    return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_FollowProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_FollowProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.FollowProto.class, com.tsemkalo.businesscards.FollowProto.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int USERID_FIELD_NUMBER = 2;
  private long userId_;
  /**
   * <code>int64 userId = 2;</code>
   */
  public long getUserId() {
    return userId_;
  }

  public static final int CARDID_FIELD_NUMBER = 3;
  private long cardId_;
  /**
   * <code>int64 cardId = 3;</code>
   */
  public long getCardId() {
    return cardId_;
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
    if (userId_ != 0L) {
      output.writeInt64(2, userId_);
    }
    if (cardId_ != 0L) {
      output.writeInt64(3, cardId_);
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
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, userId_);
    }
    if (cardId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, cardId_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.FollowProto)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.FollowProto other = (com.tsemkalo.businesscards.FollowProto) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (getUserId()
        == other.getUserId());
    result = result && (getCardId()
        == other.getCardId());
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
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (37 * hash) + CARDID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCardId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.FollowProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.FollowProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.FollowProto parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.FollowProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.FollowProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.FollowProto)
      com.tsemkalo.businesscards.FollowProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_FollowProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_FollowProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.FollowProto.class, com.tsemkalo.businesscards.FollowProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.FollowProto.newBuilder()
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

      userId_ = 0L;

      cardId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_FollowProto_descriptor;
    }

    public com.tsemkalo.businesscards.FollowProto getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.FollowProto.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.FollowProto build() {
      com.tsemkalo.businesscards.FollowProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.FollowProto buildPartial() {
      com.tsemkalo.businesscards.FollowProto result = new com.tsemkalo.businesscards.FollowProto(this);
      result.id_ = id_;
      result.userId_ = userId_;
      result.cardId_ = cardId_;
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
      if (other instanceof com.tsemkalo.businesscards.FollowProto) {
        return mergeFrom((com.tsemkalo.businesscards.FollowProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.FollowProto other) {
      if (other == com.tsemkalo.businesscards.FollowProto.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      if (other.getCardId() != 0L) {
        setCardId(other.getCardId());
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
      com.tsemkalo.businesscards.FollowProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.FollowProto) e.getUnfinishedMessage();
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

    private long cardId_ ;
    /**
     * <code>int64 cardId = 3;</code>
     */
    public long getCardId() {
      return cardId_;
    }
    /**
     * <code>int64 cardId = 3;</code>
     */
    public Builder setCardId(long value) {
      
      cardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 cardId = 3;</code>
     */
    public Builder clearCardId() {
      
      cardId_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.FollowProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.FollowProto)
  private static final com.tsemkalo.businesscards.FollowProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.FollowProto();
  }

  public static com.tsemkalo.businesscards.FollowProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FollowProto>
      PARSER = new com.google.protobuf.AbstractParser<FollowProto>() {
    public FollowProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FollowProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FollowProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FollowProto> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.FollowProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

