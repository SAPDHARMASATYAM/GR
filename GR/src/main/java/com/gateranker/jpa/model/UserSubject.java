package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * @author Sap Dharma Satyam
 */
import java.util.UUID;

/**
 * The persistent class for the user_subject database table.
 * 
 */
@Entity
@Table(name="user_subject")
@NamedQuery(name="UserSubject.findAll", query="SELECT u FROM UserSubject u")
public class UserSubject implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;// The row number!
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_subject_subscription")
	private Date dateOfSubjectSubscription;

	@Column(name="is_subject_active_for_user")
	private boolean isSubjectActiveForUser;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_name")
	private Subject subject;

	public UserSubject() {
	}

	public Date getDateOfSubjectSubscription() {
		return this.dateOfSubjectSubscription;
	}

	public void setDateOfSubjectSubscription(Date dateOfSubjectSubscription) {
		this.dateOfSubjectSubscription = dateOfSubjectSubscription;
	}

	public boolean getIsSubjectActiveForUser() {
		return this.isSubjectActiveForUser;
	}

	public void setIsSubjectActiveForUser(boolean isSubjectActiveForUser) {
		this.isSubjectActiveForUser = isSubjectActiveForUser;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setSubjectActiveForUser(boolean isSubjectActiveForUser) {
		this.isSubjectActiveForUser = isSubjectActiveForUser;
	}

	@Override
	public String toString() {
		return "UserSubject [id=" + id + ", dateOfSubjectSubscription=" + dateOfSubjectSubscription
				+ ", isSubjectActiveForUser=" + isSubjectActiveForUser + ", user=" + user + ", subject=" + subject
				+ "]";
	}
	

}