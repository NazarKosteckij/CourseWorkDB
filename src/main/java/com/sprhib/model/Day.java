package com.sprhib.model;

import javax.persistence.*;

/**
 * Created by nkostets on 6/8/2015.
 */
@Entity
@Table(name="days")
public class Day {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", unique = true)
    private String names;

    public Day(String names) {
        this.names = names;
        this.id = 0;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
