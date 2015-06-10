package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Lesson;

@Repository
public class LessonsDAOImpl implements LessonsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}

	public void add(Object lesson) {
			getCurrentSession().save(lesson);			 
	}

	public void update(Object lesson) {
		getCurrentSession().update(lesson);
	}

	public Object get(int id, Object object) {
		return getCurrentSession().get(object.getClass(), id);
	}

	public void delete(int id, Object object) {
		Object lesson = get(id, object);
		if (lesson != null)
			getCurrentSession().delete(lesson);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAll() {
		Query query = getCurrentSession().createQuery("from  Lesson");//.createSQLQuery("select * from lessons").addEntity(Lesson.class);
		// ("from  Lesson where day_id=1")
				List<Object> result = query.list();
		return result;
	}

}
