// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AdminService.proto

package com.tsemkalo.businesscards;

/**
 * Protobuf type {@code com.tsemkalo.businesscards.AddSupporterRequestProtoList}
 */
public  final class AddSupporterRequestProtoList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tsemkalo.businesscards.AddSupporterRequestProtoList)
    AddSupporterRequestProtoListOrBuilder {
  // Use AddSupporterRequestProtoList.newBuilder() to construct.
  private AddSupporterRequestProtoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddSupporterRequestProtoList() {
    requests_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AddSupporterRequestProtoList(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              requests_ = new java.util.ArrayList<com.tsemkalo.businesscards.AddSupporterRequestProto>();
              mutable_bitField0_ |= 0x00000001;
            }
            requests_.add(
                input.readMessage(com.tsemkalo.businesscards.AddSupporterRequestProto.parser(), extensionRegistry));
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
        requests_ = java.util.Collections.unmodifiableList(requests_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tsemkalo.businesscards.AdminServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddSupporterRequestProtoList_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tsemkalo.businesscards.AdminServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddSupporterRequestProtoList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tsemkalo.businesscards.AddSupporterRequestProtoList.class, com.tsemkalo.businesscards.AddSupporterRequestProtoList.Builder.class);
  }

  public static final int REQUESTS_FIELD_NUMBER = 1;
  private java.util.List<com.tsemkalo.businesscards.AddSupporterRequestProto> requests_;
  /**
   * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
   */
  public java.util.List<com.tsemkalo.businesscards.AddSupporterRequestProto> getRequestsList() {
    return requests_;
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
   */
  public java.util.List<? extends com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder> 
      getRequestsOrBuilderList() {
    return requests_;
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
   */
  public int getRequestsCount() {
    return requests_.size();
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
   */
  public com.tsemkalo.businesscards.AddSupporterRequestProto getRequests(int index) {
    return requests_.get(index);
  }
  /**
   * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
   */
  public com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder getRequestsOrBuilder(
      int index) {
    return requests_.get(index);
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
    for (int i = 0; i < requests_.size(); i++) {
      output.writeMessage(1, requests_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < requests_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, requests_.get(i));
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
    if (!(obj instanceof com.tsemkalo.businesscards.AddSupporterRequestProtoList)) {
      return super.equals(obj);
    }
    com.tsemkalo.businesscards.AddSupporterRequestProtoList other = (com.tsemkalo.businesscards.AddSupporterRequestProtoList) obj;

    boolean result = true;
    result = result && getRequestsList()
        .equals(other.getRequestsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRequestsCount() > 0) {
      hash = (37 * hash) + REQUESTS_FIELD_NUMBER;
      hash = (53 * hash) + getRequestsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList parseFrom(
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
  public static Builder newBuilder(com.tsemkalo.businesscards.AddSupporterRequestProtoList prototype) {
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
   * Protobuf type {@code com.tsemkalo.businesscards.AddSupporterRequestProtoList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tsemkalo.businesscards.AddSupporterRequestProtoList)
      com.tsemkalo.businesscards.AddSupporterRequestProtoListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tsemkalo.businesscards.AdminServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddSupporterRequestProtoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tsemkalo.businesscards.AdminServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddSupporterRequestProtoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tsemkalo.businesscards.AddSupporterRequestProtoList.class, com.tsemkalo.businesscards.AddSupporterRequestProtoList.Builder.class);
    }

    // Construct using com.tsemkalo.businesscards.AddSupporterRequestProtoList.newBuilder()
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
        getRequestsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (requestsBuilder_ == null) {
        requests_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        requestsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tsemkalo.businesscards.AdminServiceOuterClass.internal_static_com_tsemkalo_businesscards_AddSupporterRequestProtoList_descriptor;
    }

    public com.tsemkalo.businesscards.AddSupporterRequestProtoList getDefaultInstanceForType() {
      return com.tsemkalo.businesscards.AddSupporterRequestProtoList.getDefaultInstance();
    }

    public com.tsemkalo.businesscards.AddSupporterRequestProtoList build() {
      com.tsemkalo.businesscards.AddSupporterRequestProtoList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tsemkalo.businesscards.AddSupporterRequestProtoList buildPartial() {
      com.tsemkalo.businesscards.AddSupporterRequestProtoList result = new com.tsemkalo.businesscards.AddSupporterRequestProtoList(this);
      int from_bitField0_ = bitField0_;
      if (requestsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          requests_ = java.util.Collections.unmodifiableList(requests_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.requests_ = requests_;
      } else {
        result.requests_ = requestsBuilder_.build();
      }
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
      if (other instanceof com.tsemkalo.businesscards.AddSupporterRequestProtoList) {
        return mergeFrom((com.tsemkalo.businesscards.AddSupporterRequestProtoList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tsemkalo.businesscards.AddSupporterRequestProtoList other) {
      if (other == com.tsemkalo.businesscards.AddSupporterRequestProtoList.getDefaultInstance()) return this;
      if (requestsBuilder_ == null) {
        if (!other.requests_.isEmpty()) {
          if (requests_.isEmpty()) {
            requests_ = other.requests_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRequestsIsMutable();
            requests_.addAll(other.requests_);
          }
          onChanged();
        }
      } else {
        if (!other.requests_.isEmpty()) {
          if (requestsBuilder_.isEmpty()) {
            requestsBuilder_.dispose();
            requestsBuilder_ = null;
            requests_ = other.requests_;
            bitField0_ = (bitField0_ & ~0x00000001);
            requestsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRequestsFieldBuilder() : null;
          } else {
            requestsBuilder_.addAllMessages(other.requests_);
          }
        }
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
      com.tsemkalo.businesscards.AddSupporterRequestProtoList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tsemkalo.businesscards.AddSupporterRequestProtoList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.tsemkalo.businesscards.AddSupporterRequestProto> requests_ =
      java.util.Collections.emptyList();
    private void ensureRequestsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        requests_ = new java.util.ArrayList<com.tsemkalo.businesscards.AddSupporterRequestProto>(requests_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tsemkalo.businesscards.AddSupporterRequestProto, com.tsemkalo.businesscards.AddSupporterRequestProto.Builder, com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder> requestsBuilder_;

    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public java.util.List<com.tsemkalo.businesscards.AddSupporterRequestProto> getRequestsList() {
      if (requestsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(requests_);
      } else {
        return requestsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public int getRequestsCount() {
      if (requestsBuilder_ == null) {
        return requests_.size();
      } else {
        return requestsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProto getRequests(int index) {
      if (requestsBuilder_ == null) {
        return requests_.get(index);
      } else {
        return requestsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder setRequests(
        int index, com.tsemkalo.businesscards.AddSupporterRequestProto value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.set(index, value);
        onChanged();
      } else {
        requestsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder setRequests(
        int index, com.tsemkalo.businesscards.AddSupporterRequestProto.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.set(index, builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder addRequests(com.tsemkalo.businesscards.AddSupporterRequestProto value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.add(value);
        onChanged();
      } else {
        requestsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder addRequests(
        int index, com.tsemkalo.businesscards.AddSupporterRequestProto value) {
      if (requestsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestsIsMutable();
        requests_.add(index, value);
        onChanged();
      } else {
        requestsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder addRequests(
        com.tsemkalo.businesscards.AddSupporterRequestProto.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.add(builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder addRequests(
        int index, com.tsemkalo.businesscards.AddSupporterRequestProto.Builder builderForValue) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.add(index, builderForValue.build());
        onChanged();
      } else {
        requestsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder addAllRequests(
        java.lang.Iterable<? extends com.tsemkalo.businesscards.AddSupporterRequestProto> values) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, requests_);
        onChanged();
      } else {
        requestsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder clearRequests() {
      if (requestsBuilder_ == null) {
        requests_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        requestsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public Builder removeRequests(int index) {
      if (requestsBuilder_ == null) {
        ensureRequestsIsMutable();
        requests_.remove(index);
        onChanged();
      } else {
        requestsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProto.Builder getRequestsBuilder(
        int index) {
      return getRequestsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder getRequestsOrBuilder(
        int index) {
      if (requestsBuilder_ == null) {
        return requests_.get(index);  } else {
        return requestsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public java.util.List<? extends com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder> 
         getRequestsOrBuilderList() {
      if (requestsBuilder_ != null) {
        return requestsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(requests_);
      }
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProto.Builder addRequestsBuilder() {
      return getRequestsFieldBuilder().addBuilder(
          com.tsemkalo.businesscards.AddSupporterRequestProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public com.tsemkalo.businesscards.AddSupporterRequestProto.Builder addRequestsBuilder(
        int index) {
      return getRequestsFieldBuilder().addBuilder(
          index, com.tsemkalo.businesscards.AddSupporterRequestProto.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tsemkalo.businesscards.AddSupporterRequestProto requests = 1;</code>
     */
    public java.util.List<com.tsemkalo.businesscards.AddSupporterRequestProto.Builder> 
         getRequestsBuilderList() {
      return getRequestsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tsemkalo.businesscards.AddSupporterRequestProto, com.tsemkalo.businesscards.AddSupporterRequestProto.Builder, com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder> 
        getRequestsFieldBuilder() {
      if (requestsBuilder_ == null) {
        requestsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.tsemkalo.businesscards.AddSupporterRequestProto, com.tsemkalo.businesscards.AddSupporterRequestProto.Builder, com.tsemkalo.businesscards.AddSupporterRequestProtoOrBuilder>(
                requests_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        requests_ = null;
      }
      return requestsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.tsemkalo.businesscards.AddSupporterRequestProtoList)
  }

  // @@protoc_insertion_point(class_scope:com.tsemkalo.businesscards.AddSupporterRequestProtoList)
  private static final com.tsemkalo.businesscards.AddSupporterRequestProtoList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tsemkalo.businesscards.AddSupporterRequestProtoList();
  }

  public static com.tsemkalo.businesscards.AddSupporterRequestProtoList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddSupporterRequestProtoList>
      PARSER = new com.google.protobuf.AbstractParser<AddSupporterRequestProtoList>() {
    public AddSupporterRequestProtoList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AddSupporterRequestProtoList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddSupporterRequestProtoList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddSupporterRequestProtoList> getParserForType() {
    return PARSER;
  }

  public com.tsemkalo.businesscards.AddSupporterRequestProtoList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

