// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageService.proto

package com.tsemkalo.businesscards;

public interface CloseQuestionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.CloseQuestionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 userId = 1;</code>
   */
  long getUserId();

  /**
   * <code>int64 chatId = 2;</code>
   */
  long getChatId();

  /**
   * <code>bool isAdmin = 3;</code>
   */
  boolean getIsAdmin();
}