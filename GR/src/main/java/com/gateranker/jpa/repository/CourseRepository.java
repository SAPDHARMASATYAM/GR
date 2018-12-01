package com.gateranker.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
	public List<Course> findAllByIsCourseActive(Boolean active);
}
