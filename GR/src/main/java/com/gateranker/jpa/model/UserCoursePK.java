package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
/**
 * @author Sap Dharma Satyam
 */
/**
 * The primary key class for the user_course database table.
 * 
 */
public class UserCoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_name", insertable=false, updatable=false)
	private String userName;

	@Column(name="course_name", insertable=false, updatable=false)
	private String courseName;

	public UserCoursePK() {
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserCoursePK)) {
			return false;
		}
		UserCoursePK castOther = (UserCoursePK)other;
		return 
			this.userName.equals(castOther.userName)
			&& this.courseName.equals(castOther.courseName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userName.hashCode();
		hash = hash * prime + this.courseName.hashCode();
		
		return hash;
	}
}