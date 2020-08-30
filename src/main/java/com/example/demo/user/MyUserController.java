package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class MyUserController {
    private static final List<MyUser> MY_USER_LIST = Arrays.asList(
            new MyUser((long) 1, "Brian Smith"),
            new MyUser((long) 2, "Susan Smith"),
            new MyUser((long) 3, "Shawn Smith")
    );

    @GetMapping("{userId}")
    public MyUser getMyUser(@PathVariable Long userId) {
        return MY_USER_LIST.stream()
                .filter(myUser -> userId.equals(myUser.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "User " + userId + " does not exist"
                ));
    }
}
