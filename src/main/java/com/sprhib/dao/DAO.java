package com.sprhib.dao;

import com.sprhib.model.Day;

import java.util.List;

public interface DAO {
	
	public void add(Object object);
	public void update(Object object);
	public Object get(int id, Class clazz);
	public void delete(int id, Class clazz);
	public List<Object> getAll(Class clazz);

}
