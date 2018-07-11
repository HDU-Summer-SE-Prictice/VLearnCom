package com.vlearncom.dao;

import com.vlearncom.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
}
