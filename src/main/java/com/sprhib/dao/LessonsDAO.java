package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Lesson;

public interface LessonsDAO {
	
	public void add(Object team);
	public void update(Object team);
	public Object get(int id, Object object);
	public void delete(int id, Object object);
	public List<Object> getAll();

}
