// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.DeleteCardProto}
 */
public  final class DeleteCardProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.DeleteCardProto)
    DeleteCardProtoOrBuilder {
  // Use DeleteCardProto.newBuilder() to construct.
  private DeleteCardProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteCardProto() {
    cardId_ = 0L;
    currentUserId_ = 0L;
    admin_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DeleteCardProto(
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

            cardId_ = input.readInt64();
            break;
          }
          case 16: {

            currentUserId_ = input.readInt64();
            break;
          }
          case 24: {

            admin_ = input.readBool();
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
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteCardProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteCardProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            DeleteCardProto.class, DeleteCardProto.Builder.class);
  }

  public static final int CARDID_FIELD_NUMBER = 1;
  private long cardId_;
  /**
   * <code>int64 cardId = 1;</code>
   */
  public long getCardId() {
    return cardId_;
  }

  public static final int CURRENTUSERID_FIELD_NUMBER = 2;
  private long currentUserId_;
  /**
   * <code>int64 currentUserId = 2;</code>
   */
  public long getCurrentUserId() {
    return currentUserId_;
  }

  public static final int ADMIN_FIELD_NUMBER = 3;
  private boolean admin_;
  /**
   * <code>bool admin = 3;</code>
   */
  public boolean getAdmin() {
    return admin_;
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
    if (cardId_ != 0L) {
      output.writeInt64(1, cardId_);
    }
    if (currentUserId_ != 0L) {
      output.writeInt64(2, currentUserId_);
    }
    if (admin_ != false) {
      output.writeBool(3, admin_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cardId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, cardId_);
    }
    if (currentUserId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, currentUserId_);
    }
    if (admin_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, admin_);
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
    if (!(obj instanceof DeleteCardProto)) {
      return super.equals(obj);
    }
    DeleteCardProto other = (DeleteCardProto) obj;

    boolean result = true;
    result = result && (getCardId()
        == other.getCardId());
    result = result && (getCurrentUserId()
        == other.getCurrentUserId());
    result = result && (getAdmin()
        == other.getAdmin());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CARDID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCardId());
    hash = (37 * hash) + CURRENTUSERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCurrentUserId());
    hash = (37 * hash) + ADMIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAdmin());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static DeleteCardProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteCardProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteCardProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteCardProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteCardProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteCardProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteCardProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteCardProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteCardProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static DeleteCardProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteCardProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteCardProto parseFrom(
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
  public static Builder newBuilder(DeleteCardProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.DeleteCardProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.DeleteCardProto)
          DeleteCardProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteCardProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteCardProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DeleteCardProto.class, DeleteCardProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.DeleteCardProto.newBuilder()
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
      cardId_ = 0L;

      currentUserId_ = 0L;

      admin_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteCardProto_descriptor;
    }

    public DeleteCardProto getDefaultInstanceForType() {
      return DeleteCardProto.getDefaultInstance();
    }

    public DeleteCardProto build() {
      DeleteCardProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public DeleteCardProto buildPartial() {
      DeleteCardProto result = new DeleteCardProto(this);
      result.cardId_ = cardId_;
      result.currentUserId_ = currentUserId_;
      result.admin_ = admin_;
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
      if (other instanceof DeleteCardProto) {
        return mergeFrom((DeleteCardProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(DeleteCardProto other) {
      if (other == DeleteCardProto.getDefaultInstance()) return this;
      if (other.getCardId() != 0L) {
        setCardId(other.getCardId());
      }
      if (other.getCurrentUserId() != 0L) {
        setCurrentUserId(other.getCurrentUserId());
      }
      if (other.getAdmin() != false) {
        setAdmin(other.getAdmin());
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
      DeleteCardProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (DeleteCardProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long cardId_ ;
    /**
     * <code>int64 cardId = 1;</code>
     */
    public long getCardId() {
      return cardId_;
    }
    /**
     * <code>int64 cardId = 1;</code>
     */
    public Builder setCardId(long value) {
      
      cardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 cardId = 1;</code>
     */
    public Builder clearCardId() {
      
      cardId_ = 0L;
      onChanged();
      return this;
    }

    private long currentUserId_ ;
    /**
     * <code>int64 currentUserId = 2;</code>
     */
    public long getCurrentUserId() {
      return currentUserId_;
    }
    /**
     * <code>int64 currentUserId = 2;</code>
     */
    public Builder setCurrentUserId(long value) {
      
      currentUserId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 currentUserId = 2;</code>
     */
    public Builder clearCurrentUserId() {
      
      currentUserId_ = 0L;
      onChanged();
      return this;
    }

    private boolean admin_ ;
    /**
     * <code>bool admin = 3;</code>
     */
    public boolean getAdmin() {
      return admin_;
    }
    /**
     * <code>bool admin = 3;</code>
     */
    public Builder setAdmin(boolean value) {
      
      admin_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool admin = 3;</code>
     */
    public Builder clearAdmin() {
      
      admin_ = false;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.DeleteCardProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.DeleteCardProto)
  private static final DeleteCardProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new DeleteCardProto();
  }

  public static DeleteCardProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeleteCardProto>
      PARSER = new com.google.protobuf.AbstractParser<DeleteCardProto>() {
    public DeleteCardProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeleteCardProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeleteCardProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteCardProto> getParserForType() {
    return PARSER;
  }

  public DeleteCardProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

