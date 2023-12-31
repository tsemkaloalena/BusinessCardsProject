// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.tsemkalo.businesscards.generatedProtos;

public final class UserServiceOuterClass {
  private UserServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_UserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_UserProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_SafeUserProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_RoleProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_RoleProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_PermissionProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_PermissionProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_UsernameProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_UsernameProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_Token_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_Token_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_ChangePasswordResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_ChangePasswordResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_EditInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_EditInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_UserIdProtoList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tsemkalo_businesscards_SafeUserProtoList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tsemkalo_businesscards_SafeUserProtoList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021UserService.proto\022\032com.tsemkalo.busine" +
      "sscards\032\033google/protobuf/empty.proto\"\236\001\n" +
      "\tUserProto\022\n\n\002id\030\001 \001(\003\022\020\n\010username\030\002 \001(\t" +
      "\022\020\n\010password\030\003 \001(\t\022\014\n\004name\030\004 \001(\t\022\017\n\007surn" +
      "ame\030\005 \001(\t\0223\n\004role\030\006 \001(\0132%.com.tsemkalo.b" +
      "usinesscards.RoleProto\022\r\n\005email\030\007 \001(\t\"\220\001" +
      "\n\rSafeUserProto\022\n\n\002id\030\001 \001(\003\022\020\n\010username\030" +
      "\002 \001(\t\022\014\n\004name\030\003 \001(\t\022\017\n\007surname\030\004 \001(\t\0223\n\004" +
      "role\030\005 \001(\0132%.com.tsemkalo.businesscards." +
      "RoleProto\022\r\n\005email\030\006 \001(\t\"\221\001\n\tRoleProto\022\n",
      "\n\002id\030\001 \001(\003\0227\n\004name\030\002 \001(\0162).com.tsemkalo." +
      "businesscards.ProtoRoleType\022?\n\npermissio" +
      "n\030\003 \003(\0132+.com.tsemkalo.businesscards.Per" +
      "missionProto\"\221\001\n\017PermissionProto\022\n\n\002id\030\001" +
      " \001(\003\022=\n\004name\030\002 \001(\0162/.com.tsemkalo.busine" +
      "sscards.ProtoPermissionType\0223\n\004role\030\003 \001(" +
      "\0132%.com.tsemkalo.businesscards.generated.RoleProto" +
      "\"!\n\rUsernameProto\022\020\n\010username\030\001 \001(\t\"\026\n\005T" +
      "oken\022\r\n\005token\030\001 \001(\t\"Z\n\025ChangePasswordReq" +
      "uest\022\027\n\017currentUsername\030\001 \001(\t\022\023\n\013oldPass",
      "word\030\002 \001(\t\022\023\n\013newPassword\030\003 \001(\t\"-\n\026Chang" +
      "ePasswordResponse\022\023\n\013newPassword\030\001 \001(\t\"i" +
      "\n\017EditInfoRequest\022\027\n\017currentUsername\030\001 \001" +
      "(\t\022=\n\neditedInfo\030\002 \001(\0132).com.tsemkalo.bu" +
      "sinesscards.SafeUserProto\"H\n\025ForgotPassw" +
      "ordRequest\022\032\n\022resetPasswordToken\030\001 \001(\t\022\023" +
      "\n\013newPassword\030\002 \001(\t\"\"\n\017UserIdProtoList\022\017" +
      "\n\007userIds\030\001 \003(\003\"M\n\021SafeUserProtoList\0228\n\005" +
      "users\030\001 \003(\0132).com.tsemkalo.businesscards" +
      ".SafeUserProto*;\n\rProtoRoleType\022\t\n\005ADMIN",
      "\020\000\022\025\n\021TECHNICAL_SUPPORT\020\001\022\010\n\004USER\020\002*p\n\023P" +
      "rotoPermissionType\022\010\n\004READ\020\000\022\010\n\004EDIT\020\001\022\017" +
      "\n\013FOLLOW_LIKE\020\002\022\010\n\004CHAT\020\003\022\023\n\017CONTROL_SUP" +
      "PORT\020\004\022\025\n\021RESOLVE_QUESTIONS\020\0052\252\007\n\013UserSe" +
      "rvice\022e\n\021getUserByUsername\022).com.tsemkal" +
      "o.businesscards.UsernameProto\032%.com.tsem" +
      "kalo.businesscards.UserProto\022u\n\035getNonAc" +
      "tivatedUserByUsername\022).com.tsemkalo.bus" +
      "inesscards.UsernameProto\032).com.tsemkalo." +
      "businesscards.SafeUserProto\022^\n\031deleteNon",
      "ActivatedAccount\022).com.tsemkalo.business" +
      "cards.UsernameProto\032\026.google.protobuf.Em" +
      "pty\022I\n\010saveUser\022%.com.tsemkalo.businessc" +
      "ards.UserProto\032\026.google.protobuf.Empty\022w" +
      "\n\016changePassword\0221.com.tsemkalo.business" +
      "cards.ChangePasswordRequest\0322.com.tsemka" +
      "lo.businesscards.ChangePasswordResponse\022" +
      "_\n\017activateAccount\022!.com.tsemkalo.busine" +
      "sscards.Token\032).com.tsemkalo.businesscar" +
      "ds.UsernameProto\022v\n\rresetPassword\0221.com.",
      "tsemkalo.businesscards.ForgotPasswordReq" +
      "uest\0322.com.tsemkalo.businesscards.Change" +
      "PasswordResponse\022O\n\010editInfo\022+.com.tsemk" +
      "alo.businesscards.EditInfoRequest\032\026.goog" +
      "le.protobuf.Empty\022o\n\021getUsersByTheirId\022+" +
      ".com.tsemkalo.businesscards.UserIdProtoL" +
      "ist\032-.com.tsemkalo.businesscards.SafeUse" +
      "rProtoListB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_com_tsemkalo_businesscards_UserProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tsemkalo_businesscards_UserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_UserProto_descriptor,
        new java.lang.String[] { "Id", "Username", "Password", "Name", "Surname", "Role", "Email", });
    internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tsemkalo_businesscards_SafeUserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_SafeUserProto_descriptor,
        new java.lang.String[] { "Id", "Username", "Name", "Surname", "Role", "Email", });
    internal_static_com_tsemkalo_businesscards_RoleProto_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tsemkalo_businesscards_RoleProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_RoleProto_descriptor,
        new java.lang.String[] { "Id", "Name", "Permission", });
    internal_static_com_tsemkalo_businesscards_PermissionProto_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tsemkalo_businesscards_PermissionProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_PermissionProto_descriptor,
        new java.lang.String[] { "Id", "Name", "Role", });
    internal_static_com_tsemkalo_businesscards_UsernameProto_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_tsemkalo_businesscards_UsernameProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_UsernameProto_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_tsemkalo_businesscards_Token_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_tsemkalo_businesscards_Token_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_Token_descriptor,
        new java.lang.String[] { "Token", });
    internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_ChangePasswordRequest_descriptor,
        new java.lang.String[] { "CurrentUsername", "OldPassword", "NewPassword", });
    internal_static_com_tsemkalo_businesscards_ChangePasswordResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_tsemkalo_businesscards_ChangePasswordResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_ChangePasswordResponse_descriptor,
        new java.lang.String[] { "NewPassword", });
    internal_static_com_tsemkalo_businesscards_EditInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_com_tsemkalo_businesscards_EditInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_EditInfoRequest_descriptor,
        new java.lang.String[] { "CurrentUsername", "EditedInfo", });
    internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_ForgotPasswordRequest_descriptor,
        new java.lang.String[] { "ResetPasswordToken", "NewPassword", });
    internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_com_tsemkalo_businesscards_UserIdProtoList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_UserIdProtoList_descriptor,
        new java.lang.String[] { "UserIds", });
    internal_static_com_tsemkalo_businesscards_SafeUserProtoList_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_com_tsemkalo_businesscards_SafeUserProtoList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tsemkalo_businesscards_SafeUserProtoList_descriptor,
        new java.lang.String[] { "Users", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
