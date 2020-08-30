package com.example.demo.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/user")
public class MyUserManagementController {
    private static final List<MyUser> MY_USER_LIST = Arrays.asList(
            new MyUser((long) 1, "Brian Smith"),
            new MyUser((long) 2, "Susan Smith"),
            new MyUser((long) 3, "Shawn Smith")
    );

    public List<MyUser> getAllMyUsers() {
        return MY_USER_LIST;
    }

    public void registerNewMyUser(MyUser user) {
        System.out.println(user);
    }

    public void deleteUser(MyUser user) {
        System.out.println(user);
    }

    public void updateUser(Long userId, MyUser user) {
        System.out.printf("%s %s%n", userId, user);
    }
}
