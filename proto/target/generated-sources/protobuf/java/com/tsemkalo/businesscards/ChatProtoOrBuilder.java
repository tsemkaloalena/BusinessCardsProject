// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

public interface ChatProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.ChatProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.com.tsemkalo.businesscards.ChatTypeProto chatType = 3;</code>
   */
  int getChatTypeValue();
  /**
   * <code>.com.tsemkalo.businesscards.ChatTypeProto chatType = 3;</code>
   */
  com.tsemkalo.businesscards.ChatTypeProto getChatType();
}
