package com.vlearncom.controller;

import com.vlearncom.domain.SysUser;
import com.vlearncom.service.SysRoleService;
import com.vlearncom.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleService sysRoleService;

    @GetMapping({"/", "/index"})
    public String root(Model model) {
        model.addAttribute("roles", sysRoleService.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("sys_roles", sysRoleService.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(SysUser sysUser) {
        if (sysUserService.save(sysUser) != null)
            return "redirect:register?success";
        return "redirect:register?error";
    }
}
