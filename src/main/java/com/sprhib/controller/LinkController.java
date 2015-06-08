package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.LessonService;

@Controller
public class LinkController {
	@Autowired
	LessonService lessons;
	
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
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
