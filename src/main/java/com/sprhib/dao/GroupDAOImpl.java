package com.sprhib.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Group;
import com.sprhib.model.Lesson;

@Repository
public class GroupDAOImpl implements GroupDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void add(Group group) {
		  Session session = sessionFactory.openSession();  
		  org.hibernate.Transaction tx = session.beginTransaction();  
		  session.save(group);  
		  tx.commit();  
		  session.close();  
	}

	public void update(Group group) {
		getCurrentSession().update(group);
	}

	public Group get(int id) {
		Group group = (Group) getCurrentSession().get(Group.class, id);
		return group;
	}

	public void delete(int id) {
		Group group = get(id);
		if (group != null)
			getCurrentSession().delete(group);
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAll() {
		Query query = getCurrentSession().createSQLQuery("select * from group").addEntity(Group.class);
				List<Group> result = query.list();
		return result;
	}

}
