package com.vlearncom.controller;

import com.vlearncom.domain.Answer;
import com.vlearncom.domain.Question;
import com.vlearncom.service.AnswerService;
import com.vlearncom.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnswerController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @PostMapping(value = "/answerAdd/{id}")
    public String answerAdd(@PathVariable("id") Integer id, Answer answer, Model model) {
        Question question = questionService.findById(id);
        if (question == null)
            return "redirect:/questions/show/" + id + "?error";

        if (answerService.addToQuestion(answer, question) == null)
            return "redirect:/questions/show/" + id + "?error";

        model.addAttribute("quest", question);
        return "redirect:/questions/show/" + id;
    }
}
