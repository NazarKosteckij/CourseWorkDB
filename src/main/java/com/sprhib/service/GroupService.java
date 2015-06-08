package com.sprhib.service;

import com.sprhib.model.Group;

import java.util.List;

public interface GroupService {
	
	public void add(Group group);
	public void update(Group group);
	public Group get(int id);
	public void delete(int id);
	public List<Group> getAll();

}
