// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards;

public interface EditGalleryPhotoProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.EditGalleryPhotoProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tsemkalo.businesscards.GalleryPhotoProto galleryPhotoProto = 1;</code>
   */
  boolean hasGalleryPhotoProto();
  /**
   * <code>.com.tsemkalo.businesscards.GalleryPhotoProto galleryPhotoProto = 1;</code>
   */
  com.tsemkalo.businesscards.GalleryPhotoProto getGalleryPhotoProto();
  /**
   * <code>.com.tsemkalo.businesscards.GalleryPhotoProto galleryPhotoProto = 1;</code>
   */
  com.tsemkalo.businesscards.GalleryPhotoProtoOrBuilder getGalleryPhotoProtoOrBuilder();

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
