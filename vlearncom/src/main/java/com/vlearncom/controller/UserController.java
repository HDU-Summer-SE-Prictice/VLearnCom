package com.vlearncom.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable("id") Integer id, Model model) {
        return "user";
    }
}
