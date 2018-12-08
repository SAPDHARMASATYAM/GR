package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.UserCourse;
/**
 * @author Sap Dharma Satyam
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserCourseService {

	public Boolean addCourseToUser(UserCourse userCourse);

	public Boolean updateCourseOfUser(String userName, String oldCourse, String newCourse);

	public Boolean removeCourseFromUser(String userId, String courseId);

	public Boolean removeAllCoursesFromUser(String userId);

	public List<UserCourse> getAllCoursesOfUser(String userId);

	public List<UserCourse> getAllCoursesOfUserByActiveIndicator(String userId, Boolean activeIndicator);

	public Boolean enableOrDisableCourseOfUser(String userId, String courseId, Boolean activeIndicator);

	public Boolean enableOrDisableAllCoursesOfUser(String userId, Boolean flag);
}
