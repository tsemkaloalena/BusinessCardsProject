// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CardService.proto

package com.tsemkalo.businesscards.generatedProtos;

public interface CardProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tsemkalo.businesscards.generated.CardProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>int64 userId = 2;</code>
   */
  long getUserId();

  /**
   * <code>string title = 3;</code>
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 3;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string logoImgPath = 4;</code>
   */
  java.lang.String getLogoImgPath();
  /**
   * <code>string logoImgPath = 4;</code>
   */
  com.google.protobuf.ByteString
      getLogoImgPathBytes();

  /**
   * <code>string headline = 5;</code>
   */
  java.lang.String getHeadline();
  /**
   * <code>string headline = 5;</code>
   */
  com.google.protobuf.ByteString
      getHeadlineBytes();

  /**
   * <code>string description = 6;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 6;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.GalleryPhotoProto photos = 7;</code>
   */
  java.util.List<GalleryPhotoProto>
      getPhotosList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.GalleryPhotoProto photos = 7;</code>
   */
  GalleryPhotoProto getPhotos(int index);
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.GalleryPhotoProto photos = 7;</code>
   */
  int getPhotosCount();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.GalleryPhotoProto photos = 7;</code>
   */
  java.util.List<? extends GalleryPhotoProtoOrBuilder>
      getPhotosOrBuilderList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.GalleryPhotoProto photos = 7;</code>
   */
  GalleryPhotoProtoOrBuilder getPhotosOrBuilder(
      int index);

  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.ContactProto contacts = 8;</code>
   */
  java.util.List<ContactProto>
      getContactsList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.ContactProto contacts = 8;</code>
   */
  ContactProto getContacts(int index);
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.ContactProto contacts = 8;</code>
   */
  int getContactsCount();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.ContactProto contacts = 8;</code>
   */
  java.util.List<? extends ContactProtoOrBuilder>
      getContactsOrBuilderList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.ContactProto contacts = 8;</code>
   */
  ContactProtoOrBuilder getContactsOrBuilder(
      int index);

  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.AddressProto addresses = 9;</code>
   */
  java.util.List<AddressProto>
      getAddressesList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.AddressProto addresses = 9;</code>
   */
  AddressProto getAddresses(int index);
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.AddressProto addresses = 9;</code>
   */
  int getAddressesCount();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.AddressProto addresses = 9;</code>
   */
  java.util.List<? extends AddressProtoOrBuilder>
      getAddressesOrBuilderList();
  /**
   * <code>repeated .com.tsemkalo.businesscards.generated.AddressProto addresses = 9;</code>
   */
  AddressProtoOrBuilder getAddressesOrBuilder(
      int index);

  /**
   * <code>int32 followersAmount = 10;</code>
   */
  int getFollowersAmount();

  /**
   * <code>int32 likesAmount = 11;</code>
   */
  int getLikesAmount();

  /**
   * <code>.com.tsemkalo.businesscards.generated.AppearanceProto appearance = 12;</code>
   */
  boolean hasAppearance();
  /**
   * <code>.com.tsemkalo.businesscards.generated.AppearanceProto appearance = 12;</code>
   */
  AppearanceProto getAppearance();
  /**
   * <code>.com.tsemkalo.businesscards.generated.AppearanceProto appearance = 12;</code>
   */
  AppearanceProtoOrBuilder getAppearanceOrBuilder();
}
