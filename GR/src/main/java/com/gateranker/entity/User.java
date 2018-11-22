package com.gateranker.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id", unique = true, nullable = false, length = 100)
	private String emailId;

	@Column(name = "is_user_active", nullable = false)
	private boolean isUserActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", nullable = false)
	private Date lastLogin;

	@Column(nullable = false, length = 15)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_registration", nullable = true)
	private Date datOfRegistration;

	@Transient
	private boolean isNew = true;

	public User() {
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatOfRegistration() {
		return datOfRegistration;
	}

	public void setDatOfRegistration(Date datOfRegistration) {
		this.datOfRegistration = datOfRegistration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getId() {
		return this.getEmailId();
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
		return "User [emailId=" + emailId + ", isUserActive=" + isUserActive + ", lastLogin=" + lastLogin
				+ ", password=" + password + ", datOfRegistration=" + datOfRegistration + "]";
	}


}