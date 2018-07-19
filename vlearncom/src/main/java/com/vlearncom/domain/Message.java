package com.vlearncom.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private SysUser from;

    @ManyToOne
    private SysUser to;

    private Date time;

    private String content;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysUser getFrom() {
        return from;
    }

    public void setFrom(SysUser from) {
        this.from = from;
    }

    public SysUser getTo() {
        return to;
    }

    public void setTo(SysUser to) {
        this.to = to;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
