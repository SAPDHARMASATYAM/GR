/**
 * 
 */
package com.gateranker.service;

import java.util.List;

import com.gateranker.jpa.model.UserSubject;

/**
 * @author Sap Dharma Satyam
 *
 */
public interface UserSubjectService {
	
	public Boolean addSubjectToUser(UserSubject userSubject);

	public Boolean updateSubjectOfUser(String userName, String oldSubject, String newSubject);

	public Boolean removeSubjectFromUser(String userId, String courseId);

	public Boolean removeAllSubjectsFromUser(String userId);

	public List<UserSubject> getAllSubjectsOfUser(String userId);

	public List<UserSubject> getAllSubjectsOfUserByActiveIndicator(String userId, Boolean activeIndicator);

	public Boolean enableOrDisableSubjectOfUser(String userId, String courseId, Boolean activeIndicator);

	public Boolean enableOrDisableAllSubjectsOfUser(String userId, Boolean flag);
	
}
