package com.gateranker.jpa.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.UserCourse;
/**
 * @author Sap Dharma Satyam
 *
 */
@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UUID> {

	UserCourse findByUserAndCourse(String userName, String subjectName);

	List<UserCourse> findAllByUser(String userName);

	List<UserCourse> findAllByUserAndIsUserCourseActive(String userName, Boolean activeIndicator);
}
