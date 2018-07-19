package com.vlearncom.controller;

import com.vlearncom.domain.Course;
import com.vlearncom.domain.SharedFile;
import com.vlearncom.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.vlearncom.config.Constants.UPLOADED_FOLDER;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses/index")
    public String courses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);

        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            System.out.println("path:"+path.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "courses/index";
    }

    @GetMapping("/courses/add")
    public String coursesAdd() {
        return "courses/add";
    }

    @PostMapping("/courses/add")
    public String doCoursesAdd(Course course) {
        if ((course = courseService.addCourse(course)) == null)
            return "redirect:/questions/add?error";
        return "redirect:/courses/show/" + course.getId();
    }

    @GetMapping("/courses/show/{id}")
    public String coursesShow(@PathVariable("id") Integer id, Model model) {
        Course course = courseService.findById(id);
        if (course == null)
            return "404";
        model.addAttribute("course", course);
        return "courses/show";
    }

    @PostMapping("/courses/editicon/{id}")
    public String editIcon(@PathVariable("id") Integer id, @RequestParam("icon") MultipartFile icon, Model model) {
        Course course = courseService.findById(id);
        if (course == null)
            return "404";

        if (icon.isEmpty() || !courseService.editIcon(icon, course)) {
            return "redirect:/courses/show/" + id + "?iconError";
        }

        return "redirect:/courses/show/" + id;
    }

    @PostMapping("/courses/addcourseitem/{id}")
    public String addCourseItem(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file, Model model) {
        Course course = courseService.findById(id);
        if (course == null)
            return "404";

        if (file.isEmpty() || !courseService.addCourseFile(course, file)) {
            return "redirect:/courses/show/" + id + "?courseItemError";
        }

        return "redirect:/courses/show/" + id;
    }
}
