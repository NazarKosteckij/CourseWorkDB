package com.sprhib.service;

import com.sprhib.dao.DaysDAO;
import com.sprhib.dao.GroupDAO;
import com.sprhib.model.Day;
import com.sprhib.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DayServiceImpl implements DayService {
	
	@Autowired
	private DaysDAO daysDAO;


	public void add(Day day) {
		daysDAO.add(day);
	}

	public void update(Day day) {
		daysDAO.update(day);
	}

	public Day get(int id) {
		return (Day)daysDAO.get(id);
	}

	public void delete(int id) {
		daysDAO.delete(id);
	}

	@Override
	public List<Day> getAll() {
		return daysDAO.getAll();
	}

}
