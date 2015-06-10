package com.sprhib.controller;

import com.sprhib.model.Day;
import com.sprhib.model.Group;
import com.sprhib.model.Lesson;
import com.sprhib.service.DayService;
import com.sprhib.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nkostets on 6/10/2015.
 */
@Controller
@RequestMapping(value="/days")
public class DaysController {
    @Autowired
    private DayService dayService;

    @ResponseBody
    @RequestMapping("/all")
    public List<Day> getAll(){
        List<Day> list = dayService.getAll();
        return list;
    }
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Day getById(@PathVariable Integer id){
        Day list = dayService.get(id);
        return list;
    }
}
