package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.LessonsDAO;
import com.sprhib.model.Lesson;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonsDAO lessonsDAO;

	public void add(Lesson team) {
		lessonsDAO.add(team);		
	}

	public void update(Lesson team) {
		lessonsDAO.update(team);
	}

	public Lesson get(int id) {
		return (Lesson)lessonsDAO.get(id, new Lesson());
	}

	public void delete(int id) {
		lessonsDAO.delete(id, new Lesson());
	}

	public List<Object> getAll() {
		return lessonsDAO.getAll();
	}

}
