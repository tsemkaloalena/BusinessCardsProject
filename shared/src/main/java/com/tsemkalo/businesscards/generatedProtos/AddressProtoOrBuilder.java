// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

public interface AddressProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.generated.AddressProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>string address = 2;</code>
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 2;</code>
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>bool showOnMap = 3;</code>
   */
  boolean getShowOnMap();

  /**
   * <code>int64 cardId = 4;</code>
   */
  long getCardId();
}
