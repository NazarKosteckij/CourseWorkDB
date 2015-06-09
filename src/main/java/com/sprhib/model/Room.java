package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Назар on 10.06.2015.
 */
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Room(String name) {
        this.name = name;
        this.id = 0;
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
}
