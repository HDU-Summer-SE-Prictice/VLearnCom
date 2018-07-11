package com.vlearncom.controller;

import com.vlearncom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    String index(Model model) {
        return "index";
    }

    @GetMapping("/list2")
    String userList2(Model model) throws Exception {
        model.addAttribute("hello","Hello, Spring Boot!");
        model.addAttribute("userList", userService.userList());
        return "/user/list2";
    }
}