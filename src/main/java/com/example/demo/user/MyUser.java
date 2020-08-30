package com.example.demo.user;

public class MyUser {
    private Long myUserId;
    private String name;

    public MyUser(Long myUserId, String name) {
        this.myUserId = myUserId;
        this.name = name;
    }

    public Long getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(Long myUserId) {
        this.myUserId = myUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
