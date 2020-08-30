package com.example.demo.security;

public enum ApplicationUserPermission {
    MY_USER_READ("my_user:read"),
    MY_USER_WRITE("my_user:write"),
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
