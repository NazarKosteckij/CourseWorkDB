package com.sprhib.dao;

import com.sprhib.model.Day;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOImpl implements DAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}
	
	public void add(Object object) {
		  getCurrentSession().save(object);
	}

	public void update(Object object) {
		getCurrentSession().update(object);
	}

	public Object get(int id, Class clazz) {
		return getCurrentSession().get(clazz, id);
	}

	public void delete(int id, Class clazz) {
		Object object = get(id, clazz);
		if (object != null)
			getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAll(Class clazz) {
		Query query = getCurrentSession()
				.createSQLQuery("from "+clazz.getName())
				.addEntity(clazz);
		return query.list();
	}

}
