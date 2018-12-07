package com.gateranker.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sap Dharma Satyam
 *
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable , Persistable<String>{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="course_name")
	private String courseName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_course_registration")
	private Date dateOfCourseRegistration;

	@Column(name="is_course_active")
	private boolean isCourseActive;

	//bi-directional many-to-one association to CourseSubject
	@OneToMany(mappedBy="course")
	private List<CourseSubject> courseSubjects;

	//bi-directional many-to-one association to UserCourse
	@OneToMany(mappedBy="course")
	private List<UserCourse> userCourses;

	@Transient
	@JsonIgnore
	private boolean isNew = false;

	public Course() {
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getDateOfCourseRegistration() {
		return this.dateOfCourseRegistration;
	}

	public void setDateOfCourseRegistration(Date dateOfCourseRegistration) {
		this.dateOfCourseRegistration = dateOfCourseRegistration;
	}

	public boolean getIsCourseActive() {
		return this.isCourseActive;
	}

	public void setIsCourseActive(boolean isCourseActive) {
		this.isCourseActive = isCourseActive;
	}

	public List<CourseSubject> getCourseSubjects() {
		return this.courseSubjects;
	}

	public void setCourseSubjects(List<CourseSubject> courseSubjects) {
		this.courseSubjects = courseSubjects;
	}

	public CourseSubject addCourseSubject(CourseSubject courseSubject) {
		getCourseSubjects().add(courseSubject);
		courseSubject.setCourse(this);

		return courseSubject;
	}

	public CourseSubject removeCourseSubject(CourseSubject courseSubject) {
		getCourseSubjects().remove(courseSubject);
		courseSubject.setCourse(null);

		return courseSubject;
	}

	public List<UserCourse> getUserCourses() {
		return this.userCourses;
	}

	public void setUserCourses(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public UserCourse addUserCours(UserCourse userCours) {
		getUserCourses().add(userCours);
		userCours.setCourse(this);

		return userCours;
	}

	public UserCourse removeUserCours(UserCourse userCours) {
		getUserCourses().remove(userCours);
		userCours.setCourse(null);

		return userCours;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public String getId() {
		return this.getCourseName();
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", dateOfCourseRegistration=" + dateOfCourseRegistration
				+ ", isCourseActive=" + isCourseActive + ", courseSubjects=" + courseSubjects + ", userCourses="
				+ userCourses + ", isNew=" + isNew + "]";
	}

}