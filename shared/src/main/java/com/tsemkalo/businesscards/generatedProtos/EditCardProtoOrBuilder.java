// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

public interface EditCardProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.generated.EditCardProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tsemkalo.businesscards.generated.CardProto cardProto = 1;</code>
   */
  boolean hasCardProto();
  /**
   * <code>.com.tsemkalo.businesscards.generated.CardProto cardProto = 1;</code>
   */
  CardProto getCardProto();
  /**
   * <code>.com.tsemkalo.businesscards.generated.CardProto cardProto = 1;</code>
   */
  CardProtoOrBuilder getCardProtoOrBuilder();

  /**
   * <code>int64 currentUserId = 2;</code>
   */
  long getCurrentUserId();

  /**
   * <code>bool admin = 3;</code>
   */
  boolean getAdmin();
}
