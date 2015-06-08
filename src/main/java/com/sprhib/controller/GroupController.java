package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Group;
import com.sprhib.dao.GroupDAO;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupDAO groupDAO;
	@Transactional
	@ResponseBody
	@RequestMapping("/all")
	public  List<Group> getAll(){
		List<Group> list = groupDAO.getAll();
		return list;
	}
	@RequestMapping("/add")
	public  void add(){
		System.out.print("1111");
		Group group = new Group("d", 1);
		groupDAO.add(group);
	}
}
