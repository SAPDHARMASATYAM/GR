package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Sap Dharma Satyam
 */
/**
 * The persistent class for the user_profile database table.
 * 
 */
@Entity
@Table(name="user_profile")
@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")
    private Long id; // The row number!
	
	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="is_user_profile_active")
	private boolean isUserProfileActive;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;

	//bi-directional many-to-one association to User
	@Id
	@OneToOne
	@JoinColumn(name="user_name")
	private User user;

	public UserProfile() {
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

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserProfileActive(boolean isUserProfileActive) {
		this.isUserProfileActive = isUserProfileActive;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", firstName=" + firstName + ", gender=" + gender + ", isUserProfileActive="
				+ isUserProfileActive + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", user=" + user
				+ "]";
	}

}