package com.sprhib.dao;

import com.sprhib.model.Day;
import com.sprhib.model.Group;

import java.util.List;

public interface DaysDAO {
	
	public void add(Day day);
	public void update(Day day);
	public Day get(int id);
	public void delete(int id);
	public List<Day> getAll();

}
