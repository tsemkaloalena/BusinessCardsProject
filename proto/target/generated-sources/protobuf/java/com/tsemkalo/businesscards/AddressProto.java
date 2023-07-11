// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.AddressProto}
 */
public  final class AddressProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.AddressProto)
    AddressProtoOrBuilder {
  // Use AddressProto.newBuilder() to construct.
  private AddressProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddressProto() {
    id_ = 0L;
    address_ = "";
    showOnMap_ = false;
    cardId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AddressProto(
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
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            address_ = s;
            break;
          }
          case 24: {

            showOnMap_ = input.readBool();
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
    return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddressProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddressProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.AddressProto.class, com.tsemkalo.businesscards.AddressProto.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int ADDRESS_FIELD_NUMBER = 2;
  private volatile java.lang.Object address_;
  /**
   * <code>string address = 2;</code>
   */
  public java.lang.String getAddress() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      address_ = s;
      return s;
    }
  }
  /**
   * <code>string address = 2;</code>
   */
  public com.google.protobuf.ByteString
      getAddressBytes() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      address_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SHOWONMAP_FIELD_NUMBER = 3;
  private boolean showOnMap_;
  /**
   * <code>bool showOnMap = 3;</code>
   */
  public boolean getShowOnMap() {
    return showOnMap_;
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
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (!getAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, address_);
    }
    if (showOnMap_ != false) {
      output.writeBool(3, showOnMap_);
    }
    if (cardId_ != 0L) {
      output.writeInt64(4, cardId_);
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
    if (!getAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, address_);
    }
    if (showOnMap_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, showOnMap_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.AddressProto)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.AddressProto other = (com.tsemkalo.businesscards.AddressProto) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getAddress()
        .equals(other.getAddress());
    result = result && (getShowOnMap()
        == other.getShowOnMap());
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
    hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getAddress().hashCode();
    hash = (37 * hash) + SHOWONMAP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getShowOnMap());
    hash = (37 * hash) + CARDID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCardId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddressProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddressProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddressProto parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.AddressProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.AddressProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.AddressProto)
      com.tsemkalo.businesscards.AddressProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddressProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddressProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.AddressProto.class, com.tsemkalo.businesscards.AddressProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.AddressProto.newBuilder()
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

      address_ = "";

      showOnMap_ = false;

      cardId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddressProto_descriptor;
    }

    public com.tsemkalo.businesscards.AddressProto getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.AddressProto.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.AddressProto build() {
      com.tsemkalo.businesscards.AddressProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.AddressProto buildPartial() {
      com.tsemkalo.businesscards.AddressProto result = new com.tsemkalo.businesscards.AddressProto(this);
      result.id_ = id_;
      result.address_ = address_;
      result.showOnMap_ = showOnMap_;
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
      if (other instanceof com.tsemkalo.businesscards.AddressProto) {
        return mergeFrom((com.tsemkalo.businesscards.AddressProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.AddressProto other) {
      if (other == com.tsemkalo.businesscards.AddressProto.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getAddress().isEmpty()) {
        address_ = other.address_;
        onChanged();
      }
      if (other.getShowOnMap() != false) {
        setShowOnMap(other.getShowOnMap());
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
      com.tsemkalo.businesscards.AddressProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.AddressProto) e.getUnfinishedMessage();
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

    private java.lang.Object address_ = "";
    /**
     * <code>string address = 2;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string address = 2;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string address = 2;</code>
     */
    public Builder setAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      address_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string address = 2;</code>
     */
    public Builder clearAddress() {
      
      address_ = getDefaultInstance().getAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string address = 2;</code>
     */
    public Builder setAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      address_ = value;
      onChanged();
      return this;
    }

    private boolean showOnMap_ ;
    /**
     * <code>bool showOnMap = 3;</code>
     */
    public boolean getShowOnMap() {
      return showOnMap_;
    }
    /**
     * <code>bool showOnMap = 3;</code>
     */
    public Builder setShowOnMap(boolean value) {
      
      showOnMap_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool showOnMap = 3;</code>
     */
    public Builder clearShowOnMap() {
      
      showOnMap_ = false;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.AddressProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.AddressProto)
  private static final com.tsemkalo.businesscards.AddressProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.AddressProto();
  }

  public static com.tsemkalo.businesscards.AddressProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddressProto>
      PARSER = new com.google.protobuf.AbstractParser<AddressProto>() {
    public AddressProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AddressProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddressProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddressProto> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.AddressProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

