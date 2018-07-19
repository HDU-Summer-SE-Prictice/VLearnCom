package com.vlearncom.service;

import com.vlearncom.dao.AnswerRepository;
import com.vlearncom.domain.Answer;
import com.vlearncom.domain.Question;
import com.vlearncom.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    SysUserService sysUserService;

    public Answer addToQuestion(Answer answer, Question question) {
        answer.setAuthor(sysUserService.getCurrentUser());
        answer.setQuestion(question);
        answer.setBirth(new Date());

        return answerRepository.save(answer);
    }
}
