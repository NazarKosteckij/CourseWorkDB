package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.GroupDAO;
import com.sprhib.dao.LessonsDAO;
import com.sprhib.model.Group;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Transactional
	public void add(Group group) {
		groupDAO.add(group); 		
	}

	public void update(Group group) {
		groupDAO.update(group);
	}

	public Group get(int id) {
		Group group = new Group();
		return (Group)groupDAO.get(id);
	}

	public void delete(int id) {
		groupDAO.delete(id);
	}

}
