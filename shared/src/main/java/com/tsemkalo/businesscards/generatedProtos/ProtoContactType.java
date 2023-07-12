// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf enum {@code com.tsemkalo.businesscards.generated.ProtoContactType}
 */
public enum ProtoContactType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SOCIAL_NETWORK = 0;</code>
   */
  SOCIAL_NETWORK(0),
  /**
   * <code>PHONE_NUMBER = 1;</code>
   */
  PHONE_NUMBER(1),
  /**
   * <code>MAIL_ADDRESS = 2;</code>
   */
  MAIL_ADDRESS(2),
  /**
   * <code>WEB_SITE = 3;</code>
   */
  WEB_SITE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SOCIAL_NETWORK = 0;</code>
   */
  public static final int SOCIAL_NETWORK_VALUE = 0;
  /**
   * <code>PHONE_NUMBER = 1;</code>
   */
  public static final int PHONE_NUMBER_VALUE = 1;
  /**
   * <code>MAIL_ADDRESS = 2;</code>
   */
  public static final int MAIL_ADDRESS_VALUE = 2;
  /**
   * <code>WEB_SITE = 3;</code>
   */
  public static final int WEB_SITE_VALUE = 3;


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
  public static ProtoContactType valueOf(int value) {
    return forNumber(value);
  }

  public static ProtoContactType forNumber(int value) {
    switch (value) {
      case 0: return SOCIAL_NETWORK;
      case 1: return PHONE_NUMBER;
      case 2: return MAIL_ADDRESS;
      case 3: return WEB_SITE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ProtoContactType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ProtoContactType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ProtoContactType>() {
          public ProtoContactType findValueByNumber(int number) {
            return ProtoContactType.forNumber(number);
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
    return CardServiceOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final ProtoContactType[] VALUES = values();

  public static ProtoContactType valueOf(
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

  private ProtoContactType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tsemkalo.businesscards.generated.ProtoContactType)
}

