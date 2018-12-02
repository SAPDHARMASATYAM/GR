package com.gateranker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.model.Course;
import com.gateranker.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/getAllCourses", method = RequestMethod.GET, produces = "application/json")
	public List<Course> getAllCourses() throws Exception {
		return courseService.getAllCourses();
	}
	
	@RequestMapping(value = "/getAllActiveCourses", method = RequestMethod.GET, produces = "application/json")
	public List<Course> getAllActiveCourses() throws Exception {
		return courseService.getAllActiveCourses();
	}
	
	@RequestMapping(value = "/getAllInActiveCourses", method = RequestMethod.GET, produces = "application/json")
	public List<Course> getAllInActiveCourses() throws Exception {
		return courseService.getAllInActiveCourses();
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, produces = "application/json")
	public Course addCourse(@RequestBody Course course) throws Exception {
		return courseService.addCourse(course);
	}
	@PutMapping("enableOrDisableCourse")
	public Course enableOrDisableCourse(@RequestBody Course course) {
		return courseService.enableOrDisableCourse(course, true);
	}
	
}
