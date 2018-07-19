package com.vlearncom.service;

import com.vlearncom.dao.CourseRepository;
import com.vlearncom.dao.SharedFileRepository;
import com.vlearncom.domain.Course;
import com.vlearncom.domain.SharedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.vlearncom.config.Constants.DEFAULT_COURSEICON;
import static com.vlearncom.config.Constants.UPLOADED_FOLDER;

@Service
public class CourseService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SharedFileRepository sharedFileRepository;

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        course.setTeacher(sysUserService.getCurrentUser());
        course.setIcon(DEFAULT_COURSEICON);
        course = courseRepository.save(course);
        File dir = new File(UPLOADED_FOLDER + "courses/" + course.getId());
        if (!dir.exists())
            dir.mkdirs();
        return course;
    }

    public boolean editIcon(MultipartFile icon, Course course) {
        String uri = UPLOADED_FOLDER + "courses/" + course.getId() + "/icon.png";
        try {
            byte[] bytes = icon.getBytes();
            Path path = Paths.get(uri);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        course.setIcon(uri);
        return courseRepository.save(course) != null;
    }

    @Transactional
    public boolean addCourseFile(Course course, MultipartFile file) {
        String uri = UPLOADED_FOLDER + "courses/" + course.getId() + "/courseitems/" + file.getOriginalFilename();
        SharedFile sharedFile;
        try {
            byte[] bytes = file.getBytes();
            sharedFile = new SharedFile(file.getOriginalFilename(), uri);
            Path path = Paths.get(uri);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        sharedFile.setCourse(course);
        course.getCourseItems().add(sharedFile);
        course.setCourseItems(course.getCourseItems());
        if (sharedFileRepository.save(sharedFile) == null)
            return false;
        if (courseRepository.save(course) == null)
            return false;
        return true;
    }
}
