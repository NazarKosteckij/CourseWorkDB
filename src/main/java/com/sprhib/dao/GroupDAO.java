package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Group;

public interface GroupDAO {
	
	public void add(Group group);
	public void update(Group group);
	public Group get(int id);
	public void delete(int id);
	public List<Group> getAll();

}
