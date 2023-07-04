package com.tsemkalo.businesscards.configuration.constants;

public class PermissionsForController {
    public static final String READ = "hasAuthority('READ')";
    public static final String EDIT = "hasAuthority('EDIT')";
    public static final String FOLLOW_LIKE = "hasAuthority('FOLLOW_LIKE')";
    public static final String CHAT = "hasAuthority('CHAT')";
    public static final String ADMIN = "hasRole('ADMIN')";
    public static final String TECHNICAL_SUPPORT = "hasRole('TECHNICAL_SUPPORT')";

}