package com.vlearncom.service;

import com.vlearncom.dao.QuestionRepository;
import com.vlearncom.domain.Question;
import com.vlearncom.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    QuestionRepository questionRepository;

    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question addQuestion(Question question) {
        question.setBirth(new Date());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        SysUser user = sysUserService.findByUsername(userDetails.getUsername());

        question.setAuthor(user);
        question.setNview(0);
        return questionRepository.save(question);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }
}
