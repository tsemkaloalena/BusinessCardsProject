package com.tsemkalo.businesscards.configuration.constants;

public class PermissionsForController {
    public static final String READ = "hasAuthority('READ')";
    public static final String EDIT = "hasAuthority('EDIT')";
    public static final String FOLLOW_LIKE = "hasAuthority('FOLLOW_LIKE')";
    public static final String CHAT = "hasAuthority('CHAT')";
    public static final String CONTROL_SUPPORT = "hasAuthority('CONTROL_SUPPORT')";
    public static final String RESOLVE_QUESTIONS = "hasAuthority('RESOLVE_QUESTIONS')";
}