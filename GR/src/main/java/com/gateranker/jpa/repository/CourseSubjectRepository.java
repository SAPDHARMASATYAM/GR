/**
 * 
 */
package com.gateranker.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.CourseSubject;

/**
 * @author Sap Dharma Satyam
 *
 */
@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, UUID>{

	public Optional<CourseSubject> findByCourseAndSubject(String courseName, String subjectName);
	public List<CourseSubject> findAllByCourse(String courseName);

	public List<CourseSubject> findAllByCourseAndIsSubjectActiveInCourse (String courseName, Boolean activeIndicator);
	
	//public List<CourseSubjectNamesOnly> findAllByCourse(String courseName);
}
