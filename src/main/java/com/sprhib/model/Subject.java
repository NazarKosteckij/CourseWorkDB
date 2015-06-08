package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nkostets on 6/8/2015.
 */
@Entity
@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue
    private Integer id;

    private String names;

    private String teacher_name;

    public Subject(String names, String teacher_name) {
        this.names = names;
        this.teacher_name = teacher_name;
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
