/**
 * 
 */
package com.gateranker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.gateranker.jpa.model.UserSubject;
import com.gateranker.jpa.repository.UserSubjectRepository;
import com.gateranker.service.UserSubjectService;

/**
 * @author Sap Dharma Satyam
 *
 */
public class UserSubjectServiceBean implements UserSubjectService {

	@Autowired private UserSubjectRepository userSubjectRepository;

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#addSubjectToUser(com.gateranker.jpa.model.UserSubject)
	 */
	@Override
	public Boolean addSubjectToUser(UserSubject userSubject) {
		return userSubjectRepository.save(userSubject) != null ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#updateSubjectOfUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean updateSubjectOfUser(String userName, String oldSubject, String newSubject) {
		userSubjectRepository.findByUserAndSubject(userName, oldSubject).map(us->{
			us.getSubject().setSubjectName(newSubject);
			UserSubject updateResponse = userSubjectRepository.save(us);
			return null != updateResponse ? true: false;
		}).orElseThrow(()-> new ResourceNotFoundException(" User Subject : " + userName + " -> " + oldSubject + " Not found."));
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#removeSubjectFromUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean removeSubjectFromUser(String userName, String subjectName) {
		userSubjectRepository.findByUserAndSubject(userName, subjectName).map(us->{
			userSubjectRepository.delete(us);
			return true;
		}).orElseThrow(()-> new ResourceNotFoundException(" User Subject : " + userName + " -> " + subjectName + " Not found."));
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#removeAllSubjectsFromUser(java.lang.String)
	 */
	@Override
	public Boolean removeAllSubjectsFromUser(String userName) {
		List<UserSubject> allSubjectsOfUserResponse = userSubjectRepository.findAllByUser(userName);
		if(null != allSubjectsOfUserResponse) {
			userSubjectRepository.deleteAll(allSubjectsOfUserResponse);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#getAllSubjectsOfUser(java.lang.String)
	 */
	@Override
	public List<UserSubject> getAllSubjectsOfUser(String userName) {
		return userSubjectRepository.findAllByUser(userName);
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#getAllSubjectsOfUserByActiveIndicator(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public List<UserSubject> getAllSubjectsOfUserByActiveIndicator(String userName, Boolean activeIndicator) {
		return userSubjectRepository.findAllByUserAndIsSubjectActiveForUser(userName, activeIndicator);
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#enableOrDisableSubjectOfUser(java.lang.String, java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean enableOrDisableSubjectOfUser(String userName, String subjectName, Boolean activeIndicator) {
		userSubjectRepository.findByUserAndSubject(userName, subjectName).map(us->{
			us.setIsSubjectActiveForUser(activeIndicator);
			UserSubject updateResponse = userSubjectRepository.save(us);
			return null != updateResponse ? true: false;
		}).orElseThrow(()-> new ResourceNotFoundException(" User Subject : " + userName + " -> " + subjectName + " Not found."));
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gateranker.service.UserSubjectService#enableOrDisableAllSubjectsOfUser(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean enableOrDisableAllSubjectsOfUser(String userName, Boolean activeIndicator) {
		List<UserSubject> allSubjectsOfUserResponse = userSubjectRepository.findAllByUser(userName);
		allSubjectsOfUserResponse.forEach(us-> us.setIsSubjectActiveForUser(activeIndicator));
		List<UserSubject> updateAllResponse = userSubjectRepository.saveAll(allSubjectsOfUserResponse);
		return null != updateAllResponse? true : false;
	}

}
