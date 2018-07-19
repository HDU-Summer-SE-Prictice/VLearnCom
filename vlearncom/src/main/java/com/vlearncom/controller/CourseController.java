package com.vlearncom.controller;

import com.vlearncom.domain.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @GetMapping("/courses/index")
    public String courses() {
        return "courses/index";
    }

    @GetMapping("/courses/add")
    public String coursesAdd() {
        return "courses/add";
    }

    @PostMapping("/courses/add")
    public String doCoursesAdd(Course course, Model model) {
        return "courses/add";
    }
}
