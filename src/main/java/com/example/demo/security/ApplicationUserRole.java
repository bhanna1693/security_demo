package com.example.demo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    MY_USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(FAMILY_READ, FAMILY_WRITE, MY_USER_READ, MY_USER_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(FAMILY_READ, MY_USER_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
