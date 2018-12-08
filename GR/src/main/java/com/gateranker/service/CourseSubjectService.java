package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.CourseSubject;

/**
 * @author Sap Dharma Satyam
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface CourseSubjectService {

	public Boolean addSubjectinCourse(CourseSubject courseSubject);

	public Boolean addSubjectsInCourse(List<CourseSubject> CourseSubjects);

	public Boolean updateSubjectInCourse(String courseName, String oldSubjectName, String newSubjectName);

	public Boolean enableOrDisableSubjectInCourse(String courseName, String subjectName, Boolean activeIndicator);

	public Boolean enableOrDisableAllSubjectsInCourse(String courseName, Boolean activeIndicator);

	public Boolean removeSubjectFromCourse(String courseName, String subjectName);

	public Boolean removeAllSubjectsFromCourse(String courseName);

	public List<CourseSubject> getAllSubjectsInCourse(String courseName);
}
