package com.gateranker.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
	
	List<Course> findAllByIsCourseActive(boolean flag);
}
