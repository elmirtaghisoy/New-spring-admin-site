package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.User;
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