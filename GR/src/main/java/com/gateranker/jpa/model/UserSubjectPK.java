package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
/**
 * @author Sap Dharma Satyam
 */
/**
 * The primary key class for the user_subject database table.
 * 
 */
public class UserSubjectPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_name", insertable=false, updatable=false)
	private String userName;

	@Column(name="subject_name", insertable=false, updatable=false)
	private String subjectName;

	public UserSubjectPK() {
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserSubjectPK)) {
			return false;
		}
		UserSubjectPK castOther = (UserSubjectPK)other;
		return 
			this.userName.equals(castOther.userName)
			&& this.subjectName.equals(castOther.subjectName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userName.hashCode();
		hash = hash * prime + this.subjectName.hashCode();
		
		return hash;
	}
}