package com.vlearncom.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private String icon;

    /**
     * 课件地址，可以是网络地址或本地路径
     */
    @OneToMany(mappedBy = "course")
    private List<SharedFile> coursewares;

    /**
     * 实际课程条目
     */
    @OneToMany(mappedBy = "course")
    private List<SharedFile> courseItems;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SharedFile> getCoursewares() {
        return coursewares;
    }

    public void setCoursewares(List<SharedFile> coursewares) {
        this.coursewares = coursewares;
    }

    public List<SharedFile> getCourseItems() {
        return courseItems;
    }

    public void setCourseItems(List<SharedFile> courseItems) {
        this.courseItems = courseItems;
    }

    public SysUser getTeacher() {
        return teacher;
    }

    public void setTeacher(SysUser teacher) {
        this.teacher = teacher;
    }

    public List<SysUser> getStudents() {
        return students;
    }

    public void setStudents(List<SysUser> students) {
        this.students = students;
    }
}
