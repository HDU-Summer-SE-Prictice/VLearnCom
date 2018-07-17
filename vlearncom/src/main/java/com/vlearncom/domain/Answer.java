package com.vlearncom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;

    private SysUser author;
}
