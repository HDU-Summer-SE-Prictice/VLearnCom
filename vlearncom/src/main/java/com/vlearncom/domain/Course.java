package com.vlearncom.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    /**
     * 课程老师。teacher 的身份必须是ROLE_TEACHER
     */
    @ManyToOne
    private SysUser teacher;

    /**
     * 课程学员。每个 student 的身份必须是 ROLE_STUDENT
     */
    @ManyToMany
    private List<SysUser> students;
}
