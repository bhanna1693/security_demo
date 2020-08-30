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
            new MyUser((long) 1, "Hanna"),
            new MyUser((long) 2, "Brand"),
            new MyUser((long) 3, "Falarski"),
            new MyUser((long) 4, "Purucker")
    );

    @GetMapping("{myUserId}")
    public MyUser getMyUser(@PathVariable Long myUserId) {
        return MY_USER_LIST.stream()
                .filter(myUser -> myUserId.equals(myUser.getMyUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "User " + myUserId + " does not exist"
                ));
    }
}
