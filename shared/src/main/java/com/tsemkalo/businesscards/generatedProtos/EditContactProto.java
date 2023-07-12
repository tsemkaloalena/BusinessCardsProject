// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.generated.EditContactProto}
 */
public  final class EditContactProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.generated.EditContactProto)
    EditContactProtoOrBuilder {
  // Use EditContactProto.newBuilder() to construct.
  private EditContactProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EditContactProto() {
    currentUserId_ = 0L;
    admin_ = false;
    cardId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private EditContactProto(
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
            ContactProto.Builder subBuilder = null;
            if (contactProto_ != null) {
              subBuilder = contactProto_.toBuilder();
            }
            contactProto_ = input.readMessage(ContactProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(contactProto_);
              contactProto_ = subBuilder.buildPartial();
            }

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
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_EditContactProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_EditContactProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            EditContactProto.class, EditContactProto.Builder.class);
  }

  public static final int CONTACTPROTO_FIELD_NUMBER = 1;
  private ContactProto contactProto_;
  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  public boolean hasContactProto() {
    return contactProto_ != null;
  }
  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  public ContactProto getContactProto() {
    return contactProto_ == null ? ContactProto.getDefaultInstance() : contactProto_;
  }
  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  public ContactProtoOrBuilder getContactProtoOrBuilder() {
    return getContactProto();
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
    if (contactProto_ != null) {
      output.writeMessage(1, getContactProto());
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
    if (contactProto_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getContactProto());
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
    if (!(obj instanceof EditContactProto)) {
      return super.equals(obj);
    }
    EditContactProto other = (EditContactProto) obj;

    boolean result = true;
    result = result && (hasContactProto() == other.hasContactProto());
    if (hasContactProto()) {
      result = result && getContactProto()
          .equals(other.getContactProto());
    }
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
    if (hasContactProto()) {
      hash = (37 * hash) + CONTACTPROTO_FIELD_NUMBER;
      hash = (53 * hash) + getContactProto().hashCode();
    }
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

  public static EditContactProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static EditContactProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static EditContactProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static EditContactProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static EditContactProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static EditContactProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static EditContactProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static EditContactProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static EditContactProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static EditContactProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static EditContactProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static EditContactProto parseFrom(
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
  public static Builder newBuilder(EditContactProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.generated.EditContactProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.generated.EditContactProto)
          EditContactProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_EditContactProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_EditContactProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              EditContactProto.class, EditContactProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.generated.EditContactProto.newBuilder()
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
      if (contactProtoBuilder_ == null) {
        contactProto_ = null;
      } else {
        contactProto_ = null;
        contactProtoBuilder_ = null;
      }
      currentUserId_ = 0L;

      admin_ = false;

      cardId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CardServiceOuterClass.internal_static_com_tsemkalo_businesscards_EditContactProto_descriptor;
    }

    public EditContactProto getDefaultInstanceForType() {
      return EditContactProto.getDefaultInstance();
    }

    public EditContactProto build() {
      EditContactProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public EditContactProto buildPartial() {
      EditContactProto result = new EditContactProto(this);
      if (contactProtoBuilder_ == null) {
        result.contactProto_ = contactProto_;
      } else {
        result.contactProto_ = contactProtoBuilder_.build();
      }
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
      if (other instanceof EditContactProto) {
        return mergeFrom((EditContactProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(EditContactProto other) {
      if (other == EditContactProto.getDefaultInstance()) return this;
      if (other.hasContactProto()) {
        mergeContactProto(other.getContactProto());
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
      EditContactProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (EditContactProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ContactProto contactProto_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
            ContactProto, ContactProto.Builder, ContactProtoOrBuilder> contactProtoBuilder_;
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public boolean hasContactProto() {
      return contactProtoBuilder_ != null || contactProto_ != null;
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public ContactProto getContactProto() {
      if (contactProtoBuilder_ == null) {
        return contactProto_ == null ? ContactProto.getDefaultInstance() : contactProto_;
      } else {
        return contactProtoBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public Builder setContactProto(ContactProto value) {
      if (contactProtoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        contactProto_ = value;
        onChanged();
      } else {
        contactProtoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public Builder setContactProto(
        ContactProto.Builder builderForValue) {
      if (contactProtoBuilder_ == null) {
        contactProto_ = builderForValue.build();
        onChanged();
      } else {
        contactProtoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public Builder mergeContactProto(ContactProto value) {
      if (contactProtoBuilder_ == null) {
        if (contactProto_ != null) {
          contactProto_ =
            ContactProto.newBuilder(contactProto_).mergeFrom(value).buildPartial();
        } else {
          contactProto_ = value;
        }
        onChanged();
      } else {
        contactProtoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public Builder clearContactProto() {
      if (contactProtoBuilder_ == null) {
        contactProto_ = null;
        onChanged();
      } else {
        contactProto_ = null;
        contactProtoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public ContactProto.Builder getContactProtoBuilder() {
      
      onChanged();
      return getContactProtoFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    public ContactProtoOrBuilder getContactProtoOrBuilder() {
      if (contactProtoBuilder_ != null) {
        return contactProtoBuilder_.getMessageOrBuilder();
      } else {
        return contactProto_ == null ?
            ContactProto.getDefaultInstance() : contactProto_;
      }
    }
    /**
     * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            ContactProto, ContactProto.Builder, ContactProtoOrBuilder>
        getContactProtoFieldBuilder() {
      if (contactProtoBuilder_ == null) {
        contactProtoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                ContactProto, ContactProto.Builder, ContactProtoOrBuilder>(
                getContactProto(),
                getParentForChildren(),
                isClean());
        contactProto_ = null;
      }
      return contactProtoBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.generated.EditContactProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.generated.EditContactProto)
  private static final EditContactProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new EditContactProto();
  }

  public static EditContactProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EditContactProto>
      PARSER = new com.google.protobuf.AbstractParser<EditContactProto>() {
    public EditContactProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new EditContactProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EditContactProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EditContactProto> getParserForType() {
    return PARSER;
  }

  public EditContactProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
