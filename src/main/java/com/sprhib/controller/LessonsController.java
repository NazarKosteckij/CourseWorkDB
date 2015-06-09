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

import javax.servlet.http.HttpServletRequest;

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

	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addingTeam(HttpServletRequest request /*, @PathVariable String name, @PathVariable Integer subject_id, @PathVariable Integer group_id,
						   @PathVariable Integer room_id, @PathVariable Integer number, @PathVariable Integer day_id*/) {
		String name = request.getParameterValues("name")[0];
		int subject_id = Integer.parseInt(request.getParameterValues("subject_id")[0]);
		int group_id = Integer.parseInt(request.getParameterValues("group_id")[0]);
		int room_id = Integer.parseInt(request.getParameterValues("room_id")[0]);
		int number = Integer.parseInt(request.getParameterValues("number")[0]);
		int day_id = Integer.parseInt(request.getParameterValues("day_id")[0]);
		lessonsService.add(new Lesson(name,subject_id,group_id,room_id,number, day_id));
		return "{'status':'OK'}";
	}

	@ResponseBody
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String editingLesson(@PathVariable Integer id, HttpServletRequest request) {
		String name = request.getParameterValues("name")[0];
		int subject_id = Integer.parseInt(request.getParameterValues("subject_id")[0]);
		int group_id = Integer.parseInt(request.getParameterValues("group_id")[0]);
		int room_id = Integer.parseInt(request.getParameterValues("room_id")[0]);
		int number = Integer.parseInt(request.getParameterValues("number")[0]);
		int day_id = Integer.parseInt(request.getParameterValues("day_id")[0]);
		lessonsService.update(new Lesson(name, subject_id, group_id, room_id, number, day_id));
		return "{'status':'OK'}";
	}

	@ResponseBody
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String deleteLesson(@PathVariable Integer id) {
		lessonsService.delete(id);
		return "{'status':'OK'}";
	}

}
