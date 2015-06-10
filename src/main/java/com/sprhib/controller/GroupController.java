package com.sprhib.controller;

import java.util.List;

import com.sprhib.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Group;
import com.sprhib.dao.GroupDAO;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@ResponseBody
	@RequestMapping("/all")
	public  List<Group> getAll(){
		List<Group> list = groupService.getAll();
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public  String add(HttpServletRequest request){
		groupService.add(new Group(request.getParameterValues("name")[0],Integer.parseInt(request.getParameterValues("count_of_students")[0])));
		return "{'status':'OK'}";
	}

	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Group getLesson(@PathVariable Integer id) {
		return groupService.get(id);
	}

}
