// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf enum {@code com.tsemkalo.businesscards.generated.ChatTypeProto}
 */
public enum ChatTypeProto
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ERROR = 0;</code>
   */
  ERROR(0),
  /**
   * <code>SUPPORT_UNASSIGNED = 1;</code>
   */
  SUPPORT_UNASSIGNED(1),
  /**
   * <code>SUPPORT_QUESTION = 2;</code>
   */
  SUPPORT_QUESTION(2),
  /**
   * <code>SUPPORT_CLOSED = 3;</code>
   */
  SUPPORT_CLOSED(3),
  /**
   * <code>GROUP = 4;</code>
   */
  GROUP(4),
  /**
   * <code>PRIVATE = 5;</code>
   */
  PRIVATE(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>ERROR = 0;</code>
   */
  public static final int ERROR_VALUE = 0;
  /**
   * <code>SUPPORT_UNASSIGNED = 1;</code>
   */
  public static final int SUPPORT_UNASSIGNED_VALUE = 1;
  /**
   * <code>SUPPORT_QUESTION = 2;</code>
   */
  public static final int SUPPORT_QUESTION_VALUE = 2;
  /**
   * <code>SUPPORT_CLOSED = 3;</code>
   */
  public static final int SUPPORT_CLOSED_VALUE = 3;
  /**
   * <code>GROUP = 4;</code>
   */
  public static final int GROUP_VALUE = 4;
  /**
   * <code>PRIVATE = 5;</code>
   */
  public static final int PRIVATE_VALUE = 5;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ChatTypeProto valueOf(int value) {
    return forNumber(value);
  }

  public static ChatTypeProto forNumber(int value) {
    switch (value) {
      case 0: return ERROR;
      case 1: return SUPPORT_UNASSIGNED;
      case 2: return SUPPORT_QUESTION;
      case 3: return SUPPORT_CLOSED;
      case 4: return GROUP;
      case 5: return PRIVATE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ChatTypeProto>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ChatTypeProto> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ChatTypeProto>() {
          public ChatTypeProto findValueByNumber(int number) {
            return ChatTypeProto.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return MessageServiceOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final ChatTypeProto[] VALUES = values();

  public static ChatTypeProto valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ChatTypeProto(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tsemkalo.businesscards.generated.ChatTypeProto)
}
