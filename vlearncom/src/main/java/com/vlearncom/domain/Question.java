package com.vlearncom.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 发帖人
     */
    @ManyToOne
    private SysUser author;

    /**
     * 发帖日期
     */
    private Date birth;

    /**
     * 帖子回复
     */
    @OneToMany(mappedBy = "question")
    List<Answer> answers;

    /**
     * 阅读数量
     */
    @Column(columnDefinition = "int(10) default 0")
    private Integer nview;

    private String title;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysUser getAuthor() {
        return author;
    }

    public void setAuthor(SysUser author) {
        this.author = author;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getNview() {
        return nview;
    }

    public void setNview(Integer nview) {
        this.nview = nview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
