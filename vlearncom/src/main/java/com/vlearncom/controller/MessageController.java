package com.vlearncom.controller;

import com.vlearncom.domain.SysUser;
import com.vlearncom.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MessageController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/message")
    public String message(@AuthenticationPrincipal Principal principal, Model model) {
        SysUser me = sysUserService.findByUsername(principal.getName());
        model.addAttribute("peers", me.getPeers());
        return "message/message";
    }
    @GetMapping("/message/writing")
    public  String  writing()
    {
        return"message/writing";
    }
}
