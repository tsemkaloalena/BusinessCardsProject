// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards.generatedProtos;

public interface MessageProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.generated.MessageProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>int64 memberId = 2;</code>
   */
  long getMemberId();

  /**
   * <code>int64 chatId = 3;</code>
   */
  long getChatId();

  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  boolean hasSendingTime();
  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  com.google.protobuf.Timestamp getSendingTime();
  /**
   * <code>.google.protobuf.Timestamp sendingTime = 4;</code>
   */
  com.google.protobuf.TimestampOrBuilder getSendingTimeOrBuilder();

  /**
   * <code>string text = 5;</code>
   */
  java.lang.String getText();
  /**
   * <code>string text = 5;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>bool read = 6;</code>
   */
  boolean getRead();
}
