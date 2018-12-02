package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Course;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface CourseService {

	public Course addCourse(Course course);
	public Course enableOrDisableCourse(Course course, boolean flag);
	public List<Course> getAllCourses();
	public Boolean isCourseAvailable(String courseName);
	public List<Course> getAllActiveCourses();
	public List<Course> getAllInActiveCourses();	
}