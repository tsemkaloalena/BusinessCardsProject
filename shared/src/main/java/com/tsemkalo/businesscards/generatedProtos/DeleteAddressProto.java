// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.DeleteAddressProto}
 */
public  final class DeleteAddressProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.DeleteAddressProto)
    DeleteAddressProtoOrBuilder {
  // Use DeleteAddressProto.newBuilder() to construct.
  private DeleteAddressProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteAddressProto() {
    addressId_ = 0L;
    currentUserId_ = 0L;
    admin_ = false;
    cardId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DeleteAddressProto(
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

            addressId_ = input.readInt64();
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
          case 32: {

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
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteAddressProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteAddressProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            DeleteAddressProto.class, DeleteAddressProto.Builder.class);
  }

  public static final int ADDRESSID_FIELD_NUMBER = 1;
  private long addressId_;
  /**
   * <code>int64 addressId = 1;</code>
   */
  public long getAddressId() {
    return addressId_;
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

  public static final int CARDID_FIELD_NUMBER = 4;
  private long cardId_;
  /**
   * <code>int64 cardId = 4;</code>
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
    if (addressId_ != 0L) {
      output.writeInt64(1, addressId_);
    }
    if (currentUserId_ != 0L) {
      output.writeInt64(2, currentUserId_);
    }
    if (admin_ != false) {
      output.writeBool(3, admin_);
    }
    if (cardId_ != 0L) {
      output.writeInt64(4, cardId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (addressId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, addressId_);
    }
    if (currentUserId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, currentUserId_);
    }
    if (admin_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, admin_);
    }
    if (cardId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, cardId_);
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
    if (!(obj instanceof DeleteAddressProto)) {
      return super.equals(obj);
    }
    DeleteAddressProto other = (DeleteAddressProto) obj;

    boolean result = true;
    result = result && (getAddressId()
        == other.getAddressId());
    result = result && (getCurrentUserId()
        == other.getCurrentUserId());
    result = result && (getAdmin()
        == other.getAdmin());
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
    hash = (37 * hash) + ADDRESSID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAddressId());
    hash = (37 * hash) + CURRENTUSERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCurrentUserId());
    hash = (37 * hash) + ADMIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAdmin());
    hash = (37 * hash) + CARDID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCardId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static DeleteAddressProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteAddressProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteAddressProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteAddressProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteAddressProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteAddressProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteAddressProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteAddressProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteAddressProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static DeleteAddressProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteAddressProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteAddressProto parseFrom(
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
  public static Builder newBuilder(DeleteAddressProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.DeleteAddressProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.DeleteAddressProto)
          DeleteAddressProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteAddressProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteAddressProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DeleteAddressProto.class, DeleteAddressProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.DeleteAddressProto.newBuilder()
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
      addressId_ = 0L;

      currentUserId_ = 0L;

      admin_ = false;

      cardId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_DeleteAddressProto_descriptor;
    }

    public DeleteAddressProto getDefaultInstanceForType() {
      return DeleteAddressProto.getDefaultInstance();
    }

    public DeleteAddressProto build() {
      DeleteAddressProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public DeleteAddressProto buildPartial() {
      DeleteAddressProto result = new DeleteAddressProto(this);
      result.addressId_ = addressId_;
      result.currentUserId_ = currentUserId_;
      result.admin_ = admin_;
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
      if (other instanceof DeleteAddressProto) {
        return mergeFrom((DeleteAddressProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(DeleteAddressProto other) {
      if (other == DeleteAddressProto.getDefaultInstance()) return this;
      if (other.getAddressId() != 0L) {
        setAddressId(other.getAddressId());
      }
      if (other.getCurrentUserId() != 0L) {
        setCurrentUserId(other.getCurrentUserId());
      }
      if (other.getAdmin() != false) {
        setAdmin(other.getAdmin());
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
      DeleteAddressProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (DeleteAddressProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long addressId_ ;
    /**
     * <code>int64 addressId = 1;</code>
     */
    public long getAddressId() {
      return addressId_;
    }
    /**
     * <code>int64 addressId = 1;</code>
     */
    public Builder setAddressId(long value) {
      
      addressId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 addressId = 1;</code>
     */
    public Builder clearAddressId() {
      
      addressId_ = 0L;
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

    private long cardId_ ;
    /**
     * <code>int64 cardId = 4;</code>
     */
    public long getCardId() {
      return cardId_;
    }
    /**
     * <code>int64 cardId = 4;</code>
     */
    public Builder setCardId(long value) {
      
      cardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 cardId = 4;</code>
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.DeleteAddressProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.DeleteAddressProto)
  private static final DeleteAddressProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new DeleteAddressProto();
  }

  public static DeleteAddressProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeleteAddressProto>
      PARSER = new com.google.protobuf.AbstractParser<DeleteAddressProto>() {
    public DeleteAddressProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeleteAddressProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeleteAddressProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteAddressProto> getParserForType() {
    return PARSER;
  }

  public DeleteAddressProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

