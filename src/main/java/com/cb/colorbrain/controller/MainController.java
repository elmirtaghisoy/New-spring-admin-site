package com.cb.colorbrain2.controller;

import com.cb.colorbrain2.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(@AuthenticationPrincipal User user) {
        return "clientPage";
    }

    @GetMapping("/main")
    public String main() {
        return "adminPage";
    }

}