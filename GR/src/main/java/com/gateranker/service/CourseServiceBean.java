package com.gateranker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.repository.CourseRepository;
import com.gateranker.model.Course;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceBean implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Boolean isCourseAvailable(String courseName) {
		return courseRepository.existsById(courseName);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public List<Course> getAllActiveCourses() {
		return null;
	}

	@Override
	public Boolean inActiveCourse(String courseName) {
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

}
