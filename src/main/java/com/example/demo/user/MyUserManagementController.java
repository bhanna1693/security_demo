package com.example.demo.user;

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
    public List<MyUser> getAllMyUsers() {
        return MY_USER_LIST;
    }

    @PostMapping
    public void registerNewMyUser(@RequestBody MyUser user) {
        System.out.println(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId) {
        System.out.println(userId);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody MyUser user) {
        System.out.printf("%s %s%n", userId, user);
    }
}
