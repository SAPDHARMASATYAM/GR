package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
/**
 * @author Sap Dharma Satyam
 *
 * The persistent class for the user_course database table.
 * 
 */
@Entity
@Table(name = "user_course")
@NamedQuery(name = "UserCourse.findAll", query = "SELECT u FROM UserCourse u")
public class UserCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "course_expiry_date")
	private Date courseExpiryDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_course_added")
	private Date dateOfCourseAdded;

	@Column(name = "is_full_subscription")
	private String isFullSubscription;

	@Column(name = "is_user_course_active")
	private boolean isUserCourseActive;

	// bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name = "course_name")
	private Course course;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_name")
	private User user;

	public UserCourse() {
	}

	public Date getCourseExpiryDate() {
		return this.courseExpiryDate;
	}

	public void setCourseExpiryDate(Date courseExpiryDate) {
		this.courseExpiryDate = courseExpiryDate;
	}

	public Date getDateOfCourseAdded() {
		return this.dateOfCourseAdded;
	}

	public void setDateOfCourseAdded(Date dateOfCourseAdded) {
		this.dateOfCourseAdded = dateOfCourseAdded;
	}

	public String getIsFullSubscription() {
		return this.isFullSubscription;
	}

	public void setIsFullSubscription(String isFullSubscription) {
		this.isFullSubscription = isFullSubscription;
	}

	public boolean getIsUserCourseActive() {
		return this.isUserCourseActive;
	}

	public void setIsUserCourseActive(boolean isUserCourseActive) {
		this.isUserCourseActive = isUserCourseActive;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setUserCourseActive(boolean isUserCourseActive) {
		this.isUserCourseActive = isUserCourseActive;
	}

	@Override
	public String toString() {
		return "UserCourse [id=" + id + ", courseExpiryDate=" + courseExpiryDate + ", dateOfCourseAdded="
				+ dateOfCourseAdded + ", isFullSubscription=" + isFullSubscription + ", isUserCourseActive="
				+ isUserCourseActive + ", course=" + course + ", user=" + user + "]";
	}
}