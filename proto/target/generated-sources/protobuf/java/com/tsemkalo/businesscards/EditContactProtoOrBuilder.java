// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards;

public interface EditContactProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.EditContactProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tsemkalo.businesscards.ContactProto contactProto = 1;</code>
   */
  boolean hasContactProto();
  /**
   * <code>.com.tsemkalo.businesscards.ContactProto contactProto = 1;</code>
   */
  com.tsemkalo.businesscards.ContactProto getContactProto();
  /**
   * <code>.com.tsemkalo.businesscards.ContactProto contactProto = 1;</code>
   */
  com.tsemkalo.businesscards.ContactProtoOrBuilder getContactProtoOrBuilder();

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
