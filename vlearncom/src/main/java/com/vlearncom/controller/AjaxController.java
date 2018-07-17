package com.vlearncom.controller;

import com.vlearncom.utils.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @Autowired
    EditorService editorService;

    @PostMapping("/editor")
    public String editorRun(@RequestParam("code") String code){
        return editorService.execJava(code);
    }
}
