package com.vlearncom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SharedFile {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    /**
     * 所属课程
     */
    @ManyToOne
    private Course course;

    /**
     * 课程的地址，本地路径或网络地址。TODO: 研究 java.net.URL 和 java.net.URI 的用法
     */
    private String path;

    public SharedFile(String name, String path) {
        this.name = name;
        this.path = path;
    }

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

