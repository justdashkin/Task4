package com.epam.daria_ivanova2.java.lesson4.task4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Schedule {

	public static void main(String[] args) {
		Student s1 = new Student("Daria", "Ivanova");
		Course c1 = new Course("Java", 10);
		Calendar cal = new GregorianCalendar(2016, 3, 25);
		s1.setSchedule(c1, cal);

		//s1.CalculateHours(s1.getSchedule(), c1);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("wh"+s1.calculateWorkingHours(s1.getSchedule(), c1));
		System.out.println("dif "+ s1.calculateDifference(s1.getSchedule(), c1));
	}

}
