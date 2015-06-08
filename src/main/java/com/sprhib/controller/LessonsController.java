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
	private LessonService lessonsService;
	
	@ResponseBody
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List listOfLesson() {
		return  lessonsService.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Lesson getLesson(@PathVariable Integer id) {
		return lessonsService.get(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addingTeam(@ModelAttribute Lesson lesson, @PathVariable String name, @PathVariable Integer subject_id, @PathVariable Integer group_id,
						   @PathVariable Integer room_id, @PathVariable Integer number, @PathVariable Integer day_id) {
		lessonsService.add(new Lesson(name, subject_id, group_id, room_id, number, day_id));
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public void editingLesson(@ModelAttribute Lesson lesson, @PathVariable Integer id) {
		lessonsService.update(lesson);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public void deleteLesson(@PathVariable Integer id) {
		lessonsService.delete(id);
	}

}
