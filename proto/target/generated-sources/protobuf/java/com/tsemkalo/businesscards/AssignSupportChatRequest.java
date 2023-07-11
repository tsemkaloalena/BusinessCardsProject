// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.AssignSupportChatRequest}
 */
public  final class AssignSupportChatRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.AssignSupportChatRequest)
    AssignSupportChatRequestOrBuilder {
  // Use AssignSupportChatRequest.newBuilder() to construct.
  private AssignSupportChatRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AssignSupportChatRequest() {
    supporterId_ = 0L;
    supporterName_ = "";
    chatId_ = 0L;
    oldSupporterId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AssignSupportChatRequest(
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

            supporterId_ = input.readInt64();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            supporterName_ = s;
            break;
          }
          case 24: {

            chatId_ = input.readInt64();
            break;
          }
          case 32: {

            oldSupporterId_ = input.readInt64();
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
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_AssignSupportChatRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_AssignSupportChatRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.AssignSupportChatRequest.class, com.tsemkalo.businesscards.AssignSupportChatRequest.Builder.class);
  }

  public static final int SUPPORTERID_FIELD_NUMBER = 1;
  private long supporterId_;
  /**
   * <code>int64 supporterId = 1;</code>
   */
  public long getSupporterId() {
    return supporterId_;
  }

  public static final int SUPPORTERNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object supporterName_;
  /**
   * <code>string supporterName = 2;</code>
   */
  public java.lang.String getSupporterName() {
    java.lang.Object ref = supporterName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      supporterName_ = s;
      return s;
    }
  }
  /**
   * <code>string supporterName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSupporterNameBytes() {
    java.lang.Object ref = supporterName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      supporterName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHATID_FIELD_NUMBER = 3;
  private long chatId_;
  /**
   * <code>int64 chatId = 3;</code>
   */
  public long getChatId() {
    return chatId_;
  }

  public static final int OLDSUPPORTERID_FIELD_NUMBER = 4;
  private long oldSupporterId_;
  /**
   * <code>int64 oldSupporterId = 4;</code>
   */
  public long getOldSupporterId() {
    return oldSupporterId_;
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
    if (supporterId_ != 0L) {
      output.writeInt64(1, supporterId_);
    }
    if (!getSupporterNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, supporterName_);
    }
    if (chatId_ != 0L) {
      output.writeInt64(3, chatId_);
    }
    if (oldSupporterId_ != 0L) {
      output.writeInt64(4, oldSupporterId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (supporterId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, supporterId_);
    }
    if (!getSupporterNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, supporterName_);
    }
    if (chatId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, chatId_);
    }
    if (oldSupporterId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, oldSupporterId_);
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
    if (!(obj instanceof com.tsemkalo.businesscards.AssignSupportChatRequest)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.AssignSupportChatRequest other = (com.tsemkalo.businesscards.AssignSupportChatRequest) obj;

    boolean result = true;
    result = result && (getSupporterId()
        == other.getSupporterId());
    result = result && getSupporterName()
        .equals(other.getSupporterName());
    result = result && (getChatId()
        == other.getChatId());
    result = result && (getOldSupporterId()
        == other.getOldSupporterId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SUPPORTERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSupporterId());
    hash = (37 * hash) + SUPPORTERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getSupporterName().hashCode();
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getChatId());
    hash = (37 * hash) + OLDSUPPORTERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getOldSupporterId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AssignSupportChatRequest parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.AssignSupportChatRequest prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.AssignSupportChatRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.AssignSupportChatRequest)
      com.tsemkalo.businesscards.AssignSupportChatRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_AssignSupportChatRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_AssignSupportChatRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.AssignSupportChatRequest.class, com.tsemkalo.businesscards.AssignSupportChatRequest.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.AssignSupportChatRequest.newBuilder()
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
      supporterId_ = 0L;

      supporterName_ = "";

      chatId_ = 0L;

      oldSupporterId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.MessageServiceOuterClass.internal_static_com_tsemkalo_businesscards_AssignSupportChatRequest_descriptor;
    }

    public com.tsemkalo.businesscards.AssignSupportChatRequest getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.AssignSupportChatRequest.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.AssignSupportChatRequest build() {
      com.tsemkalo.businesscards.AssignSupportChatRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.AssignSupportChatRequest buildPartial() {
      com.tsemkalo.businesscards.AssignSupportChatRequest result = new com.tsemkalo.businesscards.AssignSupportChatRequest(this);
      result.supporterId_ = supporterId_;
      result.supporterName_ = supporterName_;
      result.chatId_ = chatId_;
      result.oldSupporterId_ = oldSupporterId_;
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
      if (other instanceof com.tsemkalo.businesscards.AssignSupportChatRequest) {
        return mergeFrom((com.tsemkalo.businesscards.AssignSupportChatRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.AssignSupportChatRequest other) {
      if (other == com.tsemkalo.businesscards.AssignSupportChatRequest.getDefaultInstance()) return this;
      if (other.getSupporterId() != 0L) {
        setSupporterId(other.getSupporterId());
      }
      if (!other.getSupporterName().isEmpty()) {
        supporterName_ = other.supporterName_;
        onChanged();
      }
      if (other.getChatId() != 0L) {
        setChatId(other.getChatId());
      }
      if (other.getOldSupporterId() != 0L) {
        setOldSupporterId(other.getOldSupporterId());
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
      com.tsemkalo.businesscards.AssignSupportChatRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.AssignSupportChatRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long supporterId_ ;
    /**
     * <code>int64 supporterId = 1;</code>
     */
    public long getSupporterId() {
      return supporterId_;
    }
    /**
     * <code>int64 supporterId = 1;</code>
     */
    public Builder setSupporterId(long value) {
      
      supporterId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 supporterId = 1;</code>
     */
    public Builder clearSupporterId() {
      
      supporterId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object supporterName_ = "";
    /**
     * <code>string supporterName = 2;</code>
     */
    public java.lang.String getSupporterName() {
      java.lang.Object ref = supporterName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        supporterName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string supporterName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSupporterNameBytes() {
      java.lang.Object ref = supporterName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        supporterName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string supporterName = 2;</code>
     */
    public Builder setSupporterName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      supporterName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string supporterName = 2;</code>
     */
    public Builder clearSupporterName() {
      
      supporterName_ = getDefaultInstance().getSupporterName();
      onChanged();
      return this;
    }
    /**
     * <code>string supporterName = 2;</code>
     */
    public Builder setSupporterNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      supporterName_ = value;
      onChanged();
      return this;
    }

    private long chatId_ ;
    /**
     * <code>int64 chatId = 3;</code>
     */
    public long getChatId() {
      return chatId_;
    }
    /**
     * <code>int64 chatId = 3;</code>
     */
    public Builder setChatId(long value) {
      
      chatId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 chatId = 3;</code>
     */
    public Builder clearChatId() {
      
      chatId_ = 0L;
      onChanged();
      return this;
    }

    private long oldSupporterId_ ;
    /**
     * <code>int64 oldSupporterId = 4;</code>
     */
    public long getOldSupporterId() {
      return oldSupporterId_;
    }
    /**
     * <code>int64 oldSupporterId = 4;</code>
     */
    public Builder setOldSupporterId(long value) {
      
      oldSupporterId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 oldSupporterId = 4;</code>
     */
    public Builder clearOldSupporterId() {
      
      oldSupporterId_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.AssignSupportChatRequest)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.AssignSupportChatRequest)
  private static final com.tsemkalo.businesscards.AssignSupportChatRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.AssignSupportChatRequest();
  }

  public static com.tsemkalo.businesscards.AssignSupportChatRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AssignSupportChatRequest>
      PARSER = new com.google.protobuf.AbstractParser<AssignSupportChatRequest>() {
    public AssignSupportChatRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AssignSupportChatRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AssignSupportChatRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AssignSupportChatRequest> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.AssignSupportChatRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
