package com.example.demo.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
public class MyUserManagementController {
    private static final List<MyUser> MY_USER_LIST = Arrays.asList(
            new MyUser((long) 1, "Brian Smith"),
            new MyUser((long) 2, "Susan Smith"),
            new MyUser((long) 3, "Shawn Smith")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    public List<MyUser> getAllMyUsers() {
        return MY_USER_LIST;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewMyUser(@RequestBody MyUser user) {
        System.out.println(user);
    }

    @DeleteMapping("{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable Long userId) {
        System.out.println(userId);
    }

    @PutMapping("{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable Long userId, @RequestBody MyUser user) {
        System.out.printf("%s %s%n", userId, user);
    }
}
