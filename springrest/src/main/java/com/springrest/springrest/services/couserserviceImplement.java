package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.course;

@Service
@Component("implementservice1")
public class couserserviceImplement implements CourseService{

	List<course> list;
	
	public couserserviceImplement() {
		
		list = new ArrayList<>();
		
		list.add(new course(1234,"Rest Apis" , "here we are learning rest api"));
		list.add(new course(1235,"Java" , "here we are learning Java"));
		list.add(new course(1236,"spring core" , "here we are learning spring core"));
		list.add(new course(1237,"spring boot" , "here we are learning spring boot"));
		
	}
	
	public List<course> getCourse(){
		return list;
	}
	
	
	@Override
	public course getCourseById(long courseId) {
		for(course c: list) {
			if (c.getId()==courseId)
				return c;
		}
		
		return null;
	}

	@Override
	public course addcourse(course c) {
		list.add(c);
		return c;
	}

	@Override
	public course updatecourse(course c) {
		int i=0;
		for(course x: list)
		{
			if(x.getId()==c.getId()) {
				list.set(i, c);
				break;
			}
			i++;
		}
		
		return c;
	}

	@Override
	public void deletecourse(long courseid) {
		
		for(course c : list)
		{
			if(c.getId()==courseid)
			{
				list.remove(c);
			}
		}
		
	}
}
