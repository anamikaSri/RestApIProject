package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.course;

public interface CourseService {
  
	public List<course> getCourse();
	
	public course getCourseById(long courseId);
	
	public course addcourse(course c);
	
	public course updatecourse(course c);
		
	public void deletecourse(long courseid);
	
	
}
