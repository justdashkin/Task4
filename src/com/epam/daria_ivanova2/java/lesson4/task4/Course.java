package com.epam.daria_ivanova2.java.lesson4.task4;

import java.util.ArrayList;

public class Course {

	private String courseName;
	private int duration;

	public Course(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
