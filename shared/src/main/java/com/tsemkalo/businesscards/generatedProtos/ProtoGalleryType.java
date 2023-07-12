// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

/**
 * Protobuf enum {@code com.tsemkalo.businesscards.generated.ProtoGalleryType}
 */
public enum ProtoGalleryType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>COLLAGE = 0;</code>
   */
  COLLAGE(0),
  /**
   * <code>GRID = 1;</code>
   */
  GRID(1),
  /**
   * <code>CAROUSEL = 2;</code>
   */
  CAROUSEL(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>COLLAGE = 0;</code>
   */
  public static final int COLLAGE_VALUE = 0;
  /**
   * <code>GRID = 1;</code>
   */
  public static final int GRID_VALUE = 1;
  /**
   * <code>CAROUSEL = 2;</code>
   */
  public static final int CAROUSEL_VALUE = 2;


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
  public static ProtoGalleryType valueOf(int value) {
    return forNumber(value);
  }

  public static ProtoGalleryType forNumber(int value) {
    switch (value) {
      case 0: return COLLAGE;
      case 1: return GRID;
      case 2: return CAROUSEL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ProtoGalleryType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ProtoGalleryType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ProtoGalleryType>() {
          public ProtoGalleryType findValueByNumber(int number) {
            return ProtoGalleryType.forNumber(number);
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
    return CardServiceOuterClass.getDescriptor().getEnumTypes().get(2);
  }

  private static final ProtoGalleryType[] VALUES = values();

  public static ProtoGalleryType valueOf(
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

  private ProtoGalleryType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tsemkalo.businesscards.generated.ProtoGalleryType)
}
