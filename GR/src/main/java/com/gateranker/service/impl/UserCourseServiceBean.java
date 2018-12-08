/**
 * 
 */
package com.gateranker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.UserCourse;
import com.gateranker.jpa.repository.UserCourseRepository;
import com.gateranker.service.UserCourseService;

/**
 * @author Sap Dharma Satyam
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserCourseServiceBean implements UserCourseService {

	@Autowired
	UserCourseRepository userCourseRepository;

	@Override
	public Boolean addCourseToUser(UserCourse userCourse) {
		UserCourse addCourseToUserResponse = userCourseRepository.save(userCourse);
		return (null != addCourseToUserResponse) ? true : false;
	}

	@Override
	public Boolean updateCourseOfUser(String userName, String oldCourse, String newCourse) {

		UserCourse findByUserAndCourseResponse = userCourseRepository.findByUserAndCourse(userName, oldCourse);
		if (findByUserAndCourseResponse != null) {
			findByUserAndCourseResponse.getCourse().setCourseName(newCourse);
			UserCourse updateCourseOfUserResponse = userCourseRepository.save(findByUserAndCourseResponse);
			if (updateCourseOfUserResponse != null) {
				return true;
			}
		}
		return false;

	}

	@Override
	public Boolean removeCourseFromUser(String userId, String courseId) {
		UserCourse findByUserAndCourseResponse = userCourseRepository.findByUserAndCourse(userId, courseId);
		if (findByUserAndCourseResponse != null) {
			userCourseRepository.delete(findByUserAndCourseResponse);
			return true;
		}
		return false;
	}

	@Override
	public Boolean removeAllCoursesFromUser(String userId) {
		List<UserCourse> findAllByUserResponse = userCourseRepository.findAllByUser(userId);
		if (findAllByUserResponse != null) {
			userCourseRepository.deleteAll(findAllByUserResponse);
			return true;
		}
		return false;
	}

	@Override
	public List<UserCourse> getAllCoursesOfUser(String userId) {
		List<UserCourse> getAllCoursesOfUserResponse = userCourseRepository.findAllByUser(userId);
		return getAllCoursesOfUserResponse;
	}

	@Override
	public List<UserCourse> getAllCoursesOfUserByActiveIndicator(String userId, Boolean activeIndicator) {
		List<UserCourse> getAllCoursesOfUserByActiveIndicatorResponse = userCourseRepository
				.findAllByUserAndIsUserCourseActive(userId, activeIndicator);
		return getAllCoursesOfUserByActiveIndicatorResponse;
	}

	@Override
	public Boolean enableOrDisableCourseOfUser(String userId, String courseId, Boolean activeIndicator) {
		UserCourse enableOrDisableCourseOfUserResponse = userCourseRepository.findByUserAndCourse(userId, courseId);
		if (null != enableOrDisableCourseOfUserResponse) {
			enableOrDisableCourseOfUserResponse.setUserCourseActive(activeIndicator);
			return true;
		}
		return false;
	}

	@Override
	public Boolean enableOrDisableAllCoursesOfUser(String userId, Boolean flag) {
		List<UserCourse> enableOrDisableAllCoursesOfUserResponse = userCourseRepository.findAllByUser(userId);
		if (null != enableOrDisableAllCoursesOfUserResponse) {
			List<UserCourse> updateAllResponse = userCourseRepository.saveAll(enableOrDisableAllCoursesOfUserResponse);
			if (null != updateAllResponse) {
				return true;
			}
		}
		return false;
	}

}
