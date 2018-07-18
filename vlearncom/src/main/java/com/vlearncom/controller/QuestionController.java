package com.vlearncom.controller;

import com.vlearncom.domain.Question;
import com.vlearncom.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    public String questions(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "questions/index";
    }

    @PostMapping("/questions/add")
    public String questionAdd(Question question, Model model) {
        question = questionService.addQuestion(question);
        model.addAttribute("questions", questionService.findAll());
        if (question == null)
            return "questions/index?error";
        return "questions/index";
    }
}
