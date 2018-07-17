package com.vlearncom.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @PostMapping("/editor")
    public String editorRun(@RequestParam("source") String source){
        return source;
    }
}
