package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Lesson;

public interface LessonService {
	
	public void add(Lesson team);
	public void update(Lesson team);
	public Lesson get(int id);
	public void delete(int id);
	public List<Object> getAll();

}
