package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    private boolean hasLoggedIn = false;

    @GetMapping("/login")
    public String getLoginView() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal()).equals("anonymousUser")) {
            return "redirect:/";
        } else {
            // not logged in, send to login page.
            return "login";
        }


    }

    @GetMapping("/index")
    public String getHomeView() {
        return "redirect:/";
    }
}
