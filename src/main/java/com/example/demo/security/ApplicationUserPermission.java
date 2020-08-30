package com.example.demo.security;

public enum ApplicationUserPermission {
    MEMBER_READ("member:read"),
    MEMBER_WRITE("member:write"),
    FAMILY_READ("family:read"),
    FAMILY_WRITE("family:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
