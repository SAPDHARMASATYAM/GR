package com.gateranker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable, Persistable<String> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 100)
	private String userName;
	
	@Column(name = "first_name", unique = true, nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", unique = true, nullable = false, length = 50)
	private String lastName;

	@Column(name = "password", unique = true, nullable = false, length = 15)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_attempt", nullable = true)
	private Date lastLoginAttempt;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_registration", nullable = true)
	private Date datOfRegistration;
	

	@Column(name = "in_valid_login_attempts", nullable = true)
	private int inValidLoginAttempts;
	
	@Column(name = "is_user_active", nullable = true)
	private boolean isUserActive;

	@Transient
	private boolean isNew = true;

	public User() {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginAttempt() {
		return lastLoginAttempt;
	}

	public void setLastLoginAttempt(Date lastLoginAttempt) {
		this.lastLoginAttempt = lastLoginAttempt;
	}

	public Date getDatOfRegistration() {
		return datOfRegistration;
	}

	public void setDatOfRegistration(Date datOfRegistration) {
		this.datOfRegistration = datOfRegistration;
	}

	public int getInValidLoginAttempts() {
		return inValidLoginAttempts;
	}

	public void setInValidLoginAttempts(int inValidLoginAttempts) {
		this.inValidLoginAttempts = inValidLoginAttempts;
	}

	public boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", lastLoginAttempt=" + lastLoginAttempt + ", datOfRegistration=" + datOfRegistration
				+ ", inValidLoginAttempts=" + inValidLoginAttempts + ", isUserActive=" + isUserActive + ", isNew="
				+ isNew + "]";
	}
}