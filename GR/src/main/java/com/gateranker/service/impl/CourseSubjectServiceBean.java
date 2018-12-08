/**
 * 
 */
package com.gateranker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.CourseSubject;
import com.gateranker.jpa.repository.CourseSubjectRepository;
import com.gateranker.service.CourseSubjectService;

/**
 * @author Sap Dharma Satyam
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseSubjectServiceBean implements CourseSubjectService {

	@Autowired
	private CourseSubjectRepository courseSubjectRepository;

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#addSubjectinCourse(com.gateranker.jpa.model.CourseSubject)
	 */
	@Override
	public Boolean addSubjectinCourse(CourseSubject courseSubject) {
		return courseSubjectRepository.save(courseSubject) != null ? true:false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#addSubjectsInCourse(java.util.List)
	 */
	@Override
	public Boolean addSubjectsInCourse(List<CourseSubject> courseSubjects) {
		return courseSubjectRepository.saveAll(courseSubjects) != null ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#updateSubjectInCourse(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean updateSubjectInCourse(String courseName, String oldSubjectName, String newSubjectName) {
		courseSubjectRepository.findByCourseAndSubject(courseName, oldSubjectName).map(cs->{
			cs.getSubject().setSubjectName(newSubjectName);
			return courseSubjectRepository.save(cs) != null ? true :false;
		}).orElseThrow(()->new ResourceNotFoundException("Subject not found in : " + courseName + " -> " + oldSubjectName));
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#enableOrDisableSubjectInCourse(java.lang.String, java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean enableOrDisableSubjectInCourse(String courseName, String subjectName, Boolean activeIndicator) {
		courseSubjectRepository.findByCourseAndSubject(courseName, subjectName).map(cs->{
			cs.setIsSubjectActiveInCourse(activeIndicator);
			return courseSubjectRepository.save(cs) != null ? true :false;
		}).orElseThrow(()->new ResourceNotFoundException("Subject not found in : " + courseName + " -> " + subjectName));
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#enableOrDisableAllSubjectsInCourse(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean enableOrDisableAllSubjectsInCourse(String courseName, Boolean activeIndicator) {
		List<CourseSubject> subjectsByCourseNameResponse = courseSubjectRepository.findAllByCourse(courseName);
		subjectsByCourseNameResponse.forEach(cs -> cs.setIsSubjectActiveInCourse(activeIndicator));
		return courseSubjectRepository.saveAll(subjectsByCourseNameResponse) != null ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#removeSubjectFromCourse(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean removeSubjectFromCourse(String courseName, String subjectName) {
		 Optional<CourseSubject> findByCourseAndSubjectResponse = courseSubjectRepository.findByCourseAndSubject(courseName, subjectName);
		 findByCourseAndSubjectResponse.map(cs->{
			 courseSubjectRepository.delete(cs);
			 return true;
		 }).orElseThrow(()->new ResourceNotFoundException("Subject not found in : " + courseName + " -> " + subjectName));
		 return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#removeAllSubjectsFromCourse(java.lang.String)
	 */
	@Override
	public Boolean removeAllSubjectsFromCourse(String courseName) {
		List<CourseSubject> findAllSubjectsByCourseResponse = courseSubjectRepository.findAllByCourse(courseName);
		if(null != findAllSubjectsByCourseResponse) { 
			courseSubjectRepository.deleteAll(findAllSubjectsByCourseResponse);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.CourseSubjectService#getAllSubjectsInCourse(java.lang.String)
	 */
	@Override
	public List<CourseSubject> getAllSubjectsInCourse(String courseName) {
		return courseSubjectRepository.findAllByCourse(courseName);
	}

}
