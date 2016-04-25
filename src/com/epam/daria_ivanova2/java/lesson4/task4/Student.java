package com.epam.daria_ivanova2.java.lesson4.task4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Student {

	private String firstName;
	private String lastName;
	private HashMap<Course, Calendar> schedule = new HashMap<Course, Calendar>();
	private Calendar today = new GregorianCalendar();
	public static final int WORKING_HOURS_PER_DAY = 8;

	public HashMap<Course, Calendar> getSchedule() {
		return schedule;

	}

	public void setSchedule(Course course, Calendar dateOfStart) {
		schedule.put(course, dateOfStart);
	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int CalculateWeekends(HashMap<Course, Calendar> schedule, Course course) {
		int countOfWeekends = 0;
		for (int i = schedule.get(course).get(Calendar.WEEK_OF_YEAR); i < today.get(Calendar.WEEK_OF_YEAR); i++) {
			countOfWeekends += 2;
		}
		return countOfWeekends;
	}

	//считаем количество дней от начала курса до сегодня
	public int CalculateDays(HashMap<Course, Calendar> schedule, Course course) {
		int countOfDays = 0;
		for (int item = schedule.get(course).get(Calendar.DAY_OF_YEAR); item <= today
				.get(Calendar.DAY_OF_YEAR); item++) {
			countOfDays++;
		}
		if (schedule.get(course).get(Calendar.YEAR) != today.get(Calendar.YEAR)) {
			countOfDays = countOfDays + 365 * (-(schedule.get(course).get(Calendar.YEAR) - today.get(Calendar.YEAR)));
		}
		return countOfDays;
	}
	
	//считаем рабочие часы
	public int calculateWorkingHours(HashMap<Course, Calendar> schedule, Course course){
		int countOfWorkingDays = this.CalculateDays(schedule, course)- this.CalculateWeekends(schedule, course);
		return countOfWorkingDays*WORKING_HOURS_PER_DAY;
	}
	
	//считаем разницу рабочих часов и часов курса
	public int calculateDifference(HashMap<Course, Calendar> schedule, Course course){
		int difference = course.getDuration() - this.calculateWorkingHours(schedule, course);
		return difference;
	}
}
