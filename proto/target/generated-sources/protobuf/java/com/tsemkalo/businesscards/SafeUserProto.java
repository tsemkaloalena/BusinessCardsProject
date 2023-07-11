// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.SafeUserProto}
 */
public  final class SafeUserProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.SafeUserProto)
    SafeUserProtoOrBuilder {
  // Use SafeUserProto.newBuilder() to construct.
  private SafeUserProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SafeUserProto() {
    id_ = 0L;
    username_ = "";
    name_ = "";
    surname_ = "";
    email_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SafeUserProto(
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

            username_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            surname_ = s;
            break;
          }
          case 42: {
            com.tsemkalo.businesscards.RoleProto.Builder subBuilder = null;
            if (role_ != null) {
              subBuilder = role_.toBuilder();
            }
            role_ = input.readMessage(com.tsemkalo.businesscards.RoleProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(role_);
              role_ = subBuilder.buildPartial();
            }

            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            email_ = s;
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
    return com.tsemkalo.businesscards.UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_SafeUserProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.SafeUserProto.class, com.tsemkalo.businesscards.SafeUserProto.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int USERNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object username_;
  /**
   * <code>string username = 2;</code>
   */
  public java.lang.String getUsername() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>string username = 2;</code>
   */
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 3;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SURNAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object surname_;
  /**
   * <code>string surname = 4;</code>
   */
  public java.lang.String getSurname() {
    java.lang.Object ref = surname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      surname_ = s;
      return s;
    }
  }
  /**
   * <code>string surname = 4;</code>
   */
  public com.google.protobuf.ByteString
      getSurnameBytes() {
    java.lang.Object ref = surname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      surname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROLE_FIELD_NUMBER = 5;
  private com.tsemkalo.businesscards.RoleProto role_;
  /**
   * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
   */
  public boolean hasRole() {
    return role_ != null;
  }
  /**
   * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
   */
  public com.tsemkalo.businesscards.RoleProto getRole() {
    return role_ == null ? com.tsemkalo.businesscards.RoleProto.getDefaultInstance() : role_;
  }
  /**
   * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
   */
  public com.tsemkalo.businesscards.RoleProtoOrBuilder getRoleOrBuilder() {
    return getRole();
  }

  public static final int EMAIL_FIELD_NUMBER = 6;
  private volatile java.lang.Object email_;
  /**
   * <code>string email = 6;</code>
   */
  public java.lang.String getEmail() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      email_ = s;
      return s;
    }
  }
  /**
   * <code>string email = 6;</code>
   */
  public com.google.protobuf.ByteString
      getEmailBytes() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      email_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, username_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, name_);
    }
    if (!getSurnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, surname_);
    }
    if (role_ != null) {
      output.writeMessage(5, getRole());
    }
    if (!getEmailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, email_);
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
    if (!getUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, username_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, name_);
    }
    if (!getSurnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, surname_);
    }
    if (role_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getRole());
    }
    if (!getEmailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, email_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.SafeUserProto)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.SafeUserProto other = (com.tsemkalo.businesscards.SafeUserProto) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getUsername()
        .equals(other.getUsername());
    result = result && getName()
        .equals(other.getName());
    result = result && getSurname()
        .equals(other.getSurname());
    result = result && (hasRole() == other.hasRole());
    if (hasRole()) {
      result = result && getRole()
          .equals(other.getRole());
    }
    result = result && getEmail()
        .equals(other.getEmail());
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
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUsername().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + SURNAME_FIELD_NUMBER;
    hash = (53 * hash) + getSurname().hashCode();
    if (hasRole()) {
      hash = (37 * hash) + ROLE_FIELD_NUMBER;
      hash = (53 * hash) + getRole().hashCode();
    }
    hash = (37 * hash) + EMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getEmail().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.SafeUserProto parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.SafeUserProto prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.SafeUserProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.SafeUserProto)
      com.tsemkalo.businesscards.SafeUserProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_SafeUserProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.SafeUserProto.class, com.tsemkalo.businesscards.SafeUserProto.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.SafeUserProto.newBuilder()
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

      username_ = "";

      name_ = "";

      surname_ = "";

      if (roleBuilder_ == null) {
        role_ = null;
      } else {
        role_ = null;
        roleBuilder_ = null;
      }
      email_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.UserServiceOuterClass.internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor;
    }

    public com.tsemkalo.businesscards.SafeUserProto getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.SafeUserProto.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.SafeUserProto build() {
      com.tsemkalo.businesscards.SafeUserProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.SafeUserProto buildPartial() {
      com.tsemkalo.businesscards.SafeUserProto result = new com.tsemkalo.businesscards.SafeUserProto(this);
      result.id_ = id_;
      result.username_ = username_;
      result.name_ = name_;
      result.surname_ = surname_;
      if (roleBuilder_ == null) {
        result.role_ = role_;
      } else {
        result.role_ = roleBuilder_.build();
      }
      result.email_ = email_;
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
      if (other instanceof com.tsemkalo.businesscards.SafeUserProto) {
        return mergeFrom((com.tsemkalo.businesscards.SafeUserProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.SafeUserProto other) {
      if (other == com.tsemkalo.businesscards.SafeUserProto.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getSurname().isEmpty()) {
        surname_ = other.surname_;
        onChanged();
      }
      if (other.hasRole()) {
        mergeRole(other.getRole());
      }
      if (!other.getEmail().isEmpty()) {
        email_ = other.email_;
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
      com.tsemkalo.businesscards.SafeUserProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.SafeUserProto) e.getUnfinishedMessage();
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

    private java.lang.Object username_ = "";
    /**
     * <code>string username = 2;</code>
     */
    public java.lang.String getUsername() {
      java.lang.Object ref = username_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string username = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      java.lang.Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder setUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      username_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder clearUsername() {
      
      username_ = getDefaultInstance().getUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      username_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 3;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object surname_ = "";
    /**
     * <code>string surname = 4;</code>
     */
    public java.lang.String getSurname() {
      java.lang.Object ref = surname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        surname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string surname = 4;</code>
     */
    public com.google.protobuf.ByteString
        getSurnameBytes() {
      java.lang.Object ref = surname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        surname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string surname = 4;</code>
     */
    public Builder setSurname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      surname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string surname = 4;</code>
     */
    public Builder clearSurname() {
      
      surname_ = getDefaultInstance().getSurname();
      onChanged();
      return this;
    }
    /**
     * <code>string surname = 4;</code>
     */
    public Builder setSurnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      surname_ = value;
      onChanged();
      return this;
    }

    private com.tsemkalo.businesscards.RoleProto role_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tsemkalo.businesscards.RoleProto, com.tsemkalo.businesscards.RoleProto.Builder, com.tsemkalo.businesscards.RoleProtoOrBuilder> roleBuilder_;
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public boolean hasRole() {
      return roleBuilder_ != null || role_ != null;
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public com.tsemkalo.businesscards.RoleProto getRole() {
      if (roleBuilder_ == null) {
        return role_ == null ? com.tsemkalo.businesscards.RoleProto.getDefaultInstance() : role_;
      } else {
        return roleBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public Builder setRole(com.tsemkalo.businesscards.RoleProto value) {
      if (roleBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        role_ = value;
        onChanged();
      } else {
        roleBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public Builder setRole(
        com.tsemkalo.businesscards.RoleProto.Builder builderForValue) {
      if (roleBuilder_ == null) {
        role_ = builderForValue.build();
        onChanged();
      } else {
        roleBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public Builder mergeRole(com.tsemkalo.businesscards.RoleProto value) {
      if (roleBuilder_ == null) {
        if (role_ != null) {
          role_ =
            com.tsemkalo.businesscards.RoleProto.newBuilder(role_).mergeFrom(value).buildPartial();
        } else {
          role_ = value;
        }
        onChanged();
      } else {
        roleBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public Builder clearRole() {
      if (roleBuilder_ == null) {
        role_ = null;
        onChanged();
      } else {
        role_ = null;
        roleBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public com.tsemkalo.businesscards.RoleProto.Builder getRoleBuilder() {
      
      onChanged();
      return getRoleFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    public com.tsemkalo.businesscards.RoleProtoOrBuilder getRoleOrBuilder() {
      if (roleBuilder_ != null) {
        return roleBuilder_.getMessageOrBuilder();
      } else {
        return role_ == null ?
            com.tsemkalo.businesscards.RoleProto.getDefaultInstance() : role_;
      }
    }
    /**
     * <code>.com.tsemkalo.businesscards.RoleProto role = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tsemkalo.businesscards.RoleProto, com.tsemkalo.businesscards.RoleProto.Builder, com.tsemkalo.businesscards.RoleProtoOrBuilder> 
        getRoleFieldBuilder() {
      if (roleBuilder_ == null) {
        roleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tsemkalo.businesscards.RoleProto, com.tsemkalo.businesscards.RoleProto.Builder, com.tsemkalo.businesscards.RoleProtoOrBuilder>(
                getRole(),
                getParentForChildren(),
                isClean());
        role_ = null;
      }
      return roleBuilder_;
    }

    private java.lang.Object email_ = "";
    /**
     * <code>string email = 6;</code>
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string email = 6;</code>
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string email = 6;</code>
     */
    public Builder setEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      email_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string email = 6;</code>
     */
    public Builder clearEmail() {
      
      email_ = getDefaultInstance().getEmail();
      onChanged();
      return this;
    }
    /**
     * <code>string email = 6;</code>
     */
    public Builder setEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      email_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.SafeUserProto)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.SafeUserProto)
  private static final com.tsemkalo.businesscards.SafeUserProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.SafeUserProto();
  }

  public static com.tsemkalo.businesscards.SafeUserProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SafeUserProto>
      PARSER = new com.google.protobuf.AbstractParser<SafeUserProto>() {
    public SafeUserProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SafeUserProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SafeUserProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SafeUserProto> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.SafeUserProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

