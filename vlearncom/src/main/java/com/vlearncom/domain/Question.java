package com.vlearncom.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Question {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "int default 0")
    private Integer level;

    @NotNull
    private String username;

}
