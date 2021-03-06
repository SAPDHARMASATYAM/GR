package com.gateranker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Course;
import com.gateranker.jpa.repository.CourseRepository;
import com.gateranker.service.CourseService;

/**
 * @author Sap Dharma Satyam
 */
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
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course enableOrDisableCourse(Course course, boolean flag) {
		course.setIsCourseActive(flag);
		return courseRepository.saveAndFlush(course);
	}

	@Override
	public Optional<Course> findById(String id) {
		return courseRepository.findById(id);
	}

	@Override
	public List<Course> getAllCoursesByActiveIndicator(boolean flag) {
		return courseRepository.findAllByIsCourseActive(flag);
	}

}
