// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards;

public interface RoleProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.RoleProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>.com.tsemkalo.businesscards.ProtoRoleType name = 2;</code>
   */
  int getNameValue();
  /**
   * <code>.com.tsemkalo.businesscards.ProtoRoleType name = 2;</code>
   */
  com.tsemkalo.businesscards.ProtoRoleType getName();

  /**
   * <code>repeated .com.tsemkalo.businesscards.PermissionProto permission = 3;</code>
   */
  java.util.List<com.tsemkalo.businesscards.PermissionProto> 
      getPermissionList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.PermissionProto permission = 3;</code>
   */
  com.tsemkalo.businesscards.PermissionProto getPermission(int index);
  /**
   * <code>repeated .com.tsemkalo.businesscards.PermissionProto permission = 3;</code>
   */
  int getPermissionCount();
  /**
   * <code>repeated .com.tsemkalo.businesscards.PermissionProto permission = 3;</code>
   */
  java.util.List<? extends com.tsemkalo.businesscards.PermissionProtoOrBuilder> 
      getPermissionOrBuilderList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.PermissionProto permission = 3;</code>
   */
  com.tsemkalo.businesscards.PermissionProtoOrBuilder getPermissionOrBuilder(
      int index);
}
