package com.tsemkalo.businesscards.configuration.enums;

public enum RoleType {
    ADMIN,
    TECHNICAL_SUPPORT,
    USER
//    COMPANY_REPRESENTATIVE
}

// Admin can not follow or like
// Company representative can add, edit and delete cards of its employees (usual users)
// All users can make cards by themselves
// Unauthorized users can only watch the cards, no likes, no follows
// Technical support can edit cards after admin reply
