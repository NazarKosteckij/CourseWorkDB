package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Lesson;
import com.sprhib.service.LessonService;

@Controller
@RequestMapping(value="/lessons")
public class LessonsController {
	
	@Autowired
	private LessonService teamService;
	
	@ResponseBody
	@RequestMapping(value="/all")
	public List listOfTeams() {
		List<Object> lessons = teamService.getAll();
		System.out.print(lessons);
		return lessons;
	}
	
	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Lesson getLesson(@PathVariable Integer id) {
		return teamService.get(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addingTeam(@ModelAttribute Lesson team) {
		teamService.add(team);
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public void edditingTeam(@ModelAttribute Lesson team, @PathVariable Integer id) {
		teamService.update(team);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public void deleteTeam(@PathVariable Integer id) {
		teamService.delete(id);
	}

}
