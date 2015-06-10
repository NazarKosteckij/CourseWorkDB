package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import com.sprhib.dao.DaysDAO;
import com.sprhib.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Group;
import com.sprhib.service.GroupService;
import com.sprhib.service.LessonService;

@Controller
public class LinkController {
	@Autowired
	LessonService lessons;

	@Autowired
	GroupService groupService;

	@Autowired
	DaysDAO daysDAO;


	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}

	private void dataInitialization(){
		Day monday = new Day("Понеділок");
		Day tuesday = new Day("Віврок");
		Day wednesday = new Day("Середа");
		Day thursday = new Day("Четвер");
		Day friday = new Day("П'ятниця");
		Day saturday = new Day("Субота");

		daysDAO.add(monday);
		daysDAO.add(tuesday);
		daysDAO.add(wednesday);
		daysDAO.add(thursday);
		daysDAO.add(friday);
		daysDAO.add(saturday);
	}
	@RequestMapping(value="/init")
	public String indexPage() {
		try {
			dataInitialization();
			groupService.add(new Group("?M-31", 0));
		} catch (org.hibernate.exception.ConstraintViolationException ex){
				System.out.print("Error duplicated name");
		}
		finally {

		}
		return "redirect:";
	}

	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public List addTeamPage2() {
		List<String> list;
		list = new ArrayList<String>();
		list.add("hello");
		return lessons.getAll();
	}
}
