package com.sprhib.model;

import javax.persistence.*;

@Entity
@Table(name="group")
public class Group {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Integer count_of_students;
	
	public Group(){
		
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param count_of_students
	 */
	public Group(String name, Integer count_of_students) {
		this.name = name;
		this.count_of_students = count_of_students;
		id = 0;
	}

	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount_of_students() {
		return count_of_students;
	}

	public void setCount_of_students(Integer count_of_students) {
		this.count_of_students = count_of_students;
	}
	

}
