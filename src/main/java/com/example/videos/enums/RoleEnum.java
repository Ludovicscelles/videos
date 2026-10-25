package com.example.videos.enums;

public enum RoleEnum {
    ADMIN("A"),
    MANAGER("MA"),
    USER("U");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
