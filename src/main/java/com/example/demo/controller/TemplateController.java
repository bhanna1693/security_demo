package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/login")
    public String getLoginView() {
        // not logged in, send to login page.
        return "login";
    }

    @GetMapping("/index")
    public String getHomeView() {
        return "/";
    }
}
