package com.gateranker.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the user_profile database table.
 * 
 */
@Entity
@Table(name = "user_profile")
@NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
public class UserProfile implements Serializable, Persistable<String> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 100)
	private String userName;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 10)
	private String gender;

	@Column(name = "is_user_profile_active", nullable = false)
	private boolean isUserProfileActive;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 10)
	private String mobile;

	@Column(name = "secret_question_1", nullable = false, length = 100)
	private String secretQuestion1;

	@Column(name = "secret_question_2", nullable = false, length = 100)
	private String secretQuestion2;

	@Column(name = "secret_question_answer_1", nullable = false, length = 100)
	private String secretQuestionAnswer1;

	@Column(name = "secret_question_answer_2", nullable = false, length = 100)
	private String secretQuestionAnswer2;
	
	@Transient
	@JsonIgnore
	private boolean isNew = false;

	public UserProfile() {
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setUserProfileActive(boolean isUserProfileActive) {
		this.isUserProfileActive = isUserProfileActive;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getIsUserProfileActive() {
		return this.isUserProfileActive;
	}

	public void setIsUserProfileActive(boolean isUserProfileActive) {
		this.isUserProfileActive = isUserProfileActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSecretQuestion1() {
		return this.secretQuestion1;
	}

	public void setSecretQuestion1(String secretQuestion1) {
		this.secretQuestion1 = secretQuestion1;
	}

	public String getSecretQuestion2() {
		return this.secretQuestion2;
	}

	public void setSecretQuestion2(String secretQuestion2) {
		this.secretQuestion2 = secretQuestion2;
	}

	public String getSecretQuestionAnswer1() {
		return this.secretQuestionAnswer1;
	}

	public void setSecretQuestionAnswer1(String secretQuestionAnswer1) {
		this.secretQuestionAnswer1 = secretQuestionAnswer1;
	}

	public String getSecretQuestionAnswer2() {
		return this.secretQuestionAnswer2;
	}

	public void setSecretQuestionAnswer2(String secretQuestionAnswer2) {
		this.secretQuestionAnswer2 = secretQuestionAnswer2;
	}

	@Override
	public String getId() {
		return this.getUserName();
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}


	@Override
	public String toString() {
		return "UserProfile [userName=" + userName + ", firstName=" + firstName + ", gender=" + gender
				+ ", isUserProfileActive=" + isUserProfileActive + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", secretQuestion1=" + secretQuestion1 + ", secretQuestion2=" + secretQuestion2
				+ ", secretQuestionAnswer1=" + secretQuestionAnswer1 + ", secretQuestionAnswer2="
				+ secretQuestionAnswer2 + ", isNew=" + isNew + "]";
	}


}