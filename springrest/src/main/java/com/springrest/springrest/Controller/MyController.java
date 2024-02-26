package com.springrest.springrest.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.springrest.springrest.entity.*;
import com.springrest.springrest.services.CourseService;

import ch.qos.logback.core.status.Status;

@RestController
public class MyController {
	
	@Autowired
	@Qualifier("implementservice1")
	private CourseService service_to_get_courses;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application";
	}
	
//	get all courses 
	@GetMapping("/courses")
	public ResponseEntity<List<course>> getCourses(){
		
		List<course> list = this.service_to_get_courses.getCourse();
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(list));
		}
//		return this.service_to_get_courses.getCourse();
		
	}
	
//get a  course details by id
	@GetMapping("/courses/{courseId}")
	public List<String> getCouseById(@PathVariable long courseId) {
		course askedCourse= this.service_to_get_courses.getCourseById(courseId);
		
		List<String> list= new ArrayList<String>();
		
		
		list.add(askedCourse.getTitleString());
		list.add(askedCourse.getDescripString());
		
		return list;
		
	}
//add a new course 
	@PostMapping("/courses")
	
	public course addcourse(@RequestBody course c)
	{
		return this.service_to_get_courses.addcourse(c);
	}
	
	
//update a course 
	
	@PutMapping("/courses")
	
	public course updatecourse(@RequestBody course c)
	{
		return this.service_to_get_courses.updatecourse(c);
	}
	
//	delete a course 
	@DeleteMapping("/courses/{courseid}")
	
	public ResponseEntity<HttpStatus>deletecourse(@PathVariable long courseid){
		try {
			
			this.service_to_get_courses.deletecourse(courseid);
			
			return ResponseEntity.status(HttpStatus.OK).build();
			
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
}
