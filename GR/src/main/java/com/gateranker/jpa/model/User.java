package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * @author Sap Dharma Satyam
 */
/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable, Persistable<String> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name")
	private String userName;
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_registration")
	private Date dateOfRegistration;

	@Column(name = "first_name")
	private String firstName;
	@JsonIgnore
	@Column(name = "invalid_attempt_count")
	private int invalidAttemptCount;
	@JsonIgnore
	@Column(name = "is_user_active")
	private boolean isUserActive;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date")
	private Date lastLoginDate;

	@Column(name = "last_name")
	private String lastName;
	private String password;
	@JsonIgnore
	// bi-directional many-to-one association to UserCourse
	@OneToMany(mappedBy = "user")
	private List<UserCourse> userCourses;
	@JsonIgnore
	// bi-directional many-to-one association to UserProfile
	@OneToMany(mappedBy = "user")
	private List<UserProfile> userProfiles;
	@JsonIgnore
	// bi-directional many-to-one association to UserSubject
	@OneToMany(mappedBy = "user")
	private List<UserSubject> userSubjects;

	@Transient
	@JsonIgnore
	private boolean isNew = true;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfRegistration() {
		return this.dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getInvalidAttemptCount() {
		return this.invalidAttemptCount;
	}

	public void setInvalidAttemptCount(int invalidAttemptCount) {
		this.invalidAttemptCount = invalidAttemptCount;
	}

	public boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserCourse> getUserCourses() {
		return this.userCourses;
	}

	public void setUserCourses(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public UserCourse addUserCours(UserCourse userCours) {
		getUserCourses().add(userCours);
		userCours.setUser(this);

		return userCours;
	}

	public UserCourse removeUserCours(UserCourse userCours) {
		getUserCourses().remove(userCours);
		userCours.setUser(null);

		return userCours;
	}

	public List<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public UserProfile addUserProfile(UserProfile userProfile) {
		getUserProfiles().add(userProfile);
		userProfile.setUser(this);

		return userProfile;
	}

	public UserProfile removeUserProfile(UserProfile userProfile) {
		getUserProfiles().remove(userProfile);
		userProfile.setUser(null);

		return userProfile;
	}

	public List<UserSubject> getUserSubjects() {
		return this.userSubjects;
	}

	public void setUserSubjects(List<UserSubject> userSubjects) {
		this.userSubjects = userSubjects;
	}

	public UserSubject addUserSubject(UserSubject userSubject) {
		getUserSubjects().add(userSubject);
		userSubject.setUser(this);

		return userSubject;
	}

	public UserSubject removeUserSubject(UserSubject userSubject) {
		getUserSubjects().remove(userSubject);
		userSubject.setUser(null);

		return userSubject;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	@JsonIgnore
	public String getId() {
		return this.getUserName();
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return this.isNew;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", dateOfRegistration=" + dateOfRegistration + ", firstName=" + firstName
				+ ", invalidAttemptCount=" + invalidAttemptCount + ", lastLoginDate=" + lastLoginDate + ", lastName="
				+ lastName + "]";
	}


}