// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

public interface EditContactProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.generated.EditContactProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  boolean hasContactProto();
  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  ContactProto getContactProto();
  /**
   * <code>.com.tsemkalo.businesscards.generated.ContactProto contactProto = 1;</code>
   */
  ContactProtoOrBuilder getContactProtoOrBuilder();

  /**
   * <code>int64 currentUserId = 2;</code>
   */
  long getCurrentUserId();

  /**
   * <code>bool admin = 3;</code>
   */
  boolean getAdmin();

  /**
   * <code>int64 cardId = 4;</code>
   */
  long getCardId();
}
