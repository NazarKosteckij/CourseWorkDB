package com.sprhib.dao;

import com.sprhib.model.Day;
import com.sprhib.model.Day;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaysDAOImpl implements DaysDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}
	
	public void add(Day day) {
		  getCurrentSession().save(day);
	}

	public void update(Day day) {
		getCurrentSession().update(day);
	}

	public Day get(int id) {
		Day day = (Day) getCurrentSession().get(Day.class, id);
		return day;
	}

	public void delete(int id) {
		Day day = get(id);
		if (day != null)
			getCurrentSession().delete(day);
	}

	@SuppressWarnings("unchecked")
	public List<Day> getAll() {
		Query query = getCurrentSession()
				.createSQLQuery("select * from days")
				.addEntity(Day.class);
		return query.list();
	}

}
