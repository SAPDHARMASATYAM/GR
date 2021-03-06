package com.gateranker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Course;

/**
 * @author Sap Dharma Satyam
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface CourseService {

	public Course addCourse(Course course);

	public List<Course> getAllCourses();

	public List<Course> getAllCoursesByActiveIndicator(boolean flag);

	public Course enableOrDisableCourse(Course course, boolean flag);

	public Boolean isCourseAvailable(String courseName);

	public Optional<Course> findById(String id);
}
