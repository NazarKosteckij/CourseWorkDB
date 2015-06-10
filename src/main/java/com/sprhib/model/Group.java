package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nkostets on 6/8/2015.
 */
@Entity
@Table(name="Groups")
public class Group {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer count_of_students;

    public Group(){}

    public Group(String name, Integer count) {
        this.name = name;
        this.id = 0;
        this.count_of_students = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount_of_students() {
        return count_of_students;
    }

    public void setCount_of_students(Integer count_of_students) {
        this.count_of_students = count_of_students;
    }
}
