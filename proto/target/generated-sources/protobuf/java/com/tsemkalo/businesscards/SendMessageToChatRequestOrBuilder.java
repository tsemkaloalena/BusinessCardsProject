// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

public interface SendMessageToChatRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.SendMessageToChatRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string text = 1;</code>
   */
  java.lang.String getText();
  /**
   * <code>string text = 1;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>int64 userId = 2;</code>
   */
  long getUserId();

  /**
   * <code>int64 chatId = 3;</code>
   */
  long getChatId();
}
