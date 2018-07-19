package com.vlearncom.controller;

import com.vlearncom.domain.Question;
import com.vlearncom.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            return "redirect:/questions?error";
        return "redirect:/questions";
    }

    @GetMapping("/questions/show/{id}")
    public String questionShow(@PathVariable("id") Integer id, Model model) {
        Question question = questionService.findById(id);
        if (question == null)
            return "404";
        if (questionService.view(question) == null)
            return "redirect:/questions?error";
        model.addAttribute("quest", question);
        return "questions/show";
    }
}
