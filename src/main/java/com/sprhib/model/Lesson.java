package com.sprhib.model;

import java.lang.reflect.Constructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	private Integer Subject_id;
	
	private Integer Group_id;

	private Integer Room_id;
	
	private Integer number;
	
	private Integer day_id;
	
	
	/**
	 * {@link Constructor}
	 */
	public Lesson(){
		
	}
	
	/**
	 * {@link Constructor}
	 * @param name
	 * @param subject_id
	 * @param group_id
	 * @param room_id
	 * @param number
	 * @param day_id
	 */
	public Lesson(String name, Integer subject_id, Integer group_id,
			Integer room_id, Integer number, Integer day_id) {
		this.id = 0;
		this.name = name;
		this.Subject_id = subject_id;
		this.Group_id = group_id;
		this.Room_id = room_id;
		this.number = number;
		this.day_id = day_id;
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

	public Integer getSubject_id() {
		return Subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		Subject_id = subject_id;
	}

	public Integer getGroup_id() {
		return Group_id;
	}

	public void setGroup_id(Integer group_id) {
		Group_id = group_id;
	}

	public Integer getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(Integer room_id) {
		Room_id = room_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDay_id() {
		return day_id;
	}

	public void setDay_id(Integer day_id) {
		this.day_id = day_id;
	}

}
