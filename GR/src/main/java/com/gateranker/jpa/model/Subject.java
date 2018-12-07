package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 * @author Sap Dharma Satyam
 */

/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_name")
	private String subjectName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_subject_registration")
	private Date dateOfSubjectRegistration;

	@Column(name="is_subject_active")
	private boolean isSubjectActive;

	//bi-directional many-to-one association to CourseSubject
	@OneToMany(mappedBy="subject")
	private List<CourseSubject> courseSubjects;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="subject")
	private List<Topic> topics;

	//bi-directional many-to-one association to UserSubject
	@OneToMany(mappedBy="subject")
	private List<UserSubject> userSubjects;

	public Subject() {
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getDateOfSubjectRegistration() {
		return this.dateOfSubjectRegistration;
	}

	public void setDateOfSubjectRegistration(Date dateOfSubjectRegistration) {
		this.dateOfSubjectRegistration = dateOfSubjectRegistration;
	}

	public boolean getIsSubjectActive() {
		return this.isSubjectActive;
	}

	public void setIsSubjectActive(boolean isSubjectActive) {
		this.isSubjectActive = isSubjectActive;
	}

	public List<CourseSubject> getCourseSubjects() {
		return this.courseSubjects;
	}

	public void setCourseSubjects(List<CourseSubject> courseSubjects) {
		this.courseSubjects = courseSubjects;
	}

	public CourseSubject addCourseSubject(CourseSubject courseSubject) {
		getCourseSubjects().add(courseSubject);
		courseSubject.setSubject(this);

		return courseSubject;
	}

	public CourseSubject removeCourseSubject(CourseSubject courseSubject) {
		getCourseSubjects().remove(courseSubject);
		courseSubject.setSubject(null);

		return courseSubject;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setSubject(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setSubject(null);

		return topic;
	}

	public List<UserSubject> getUserSubjects() {
		return this.userSubjects;
	}

	public void setUserSubjects(List<UserSubject> userSubjects) {
		this.userSubjects = userSubjects;
	}

	public UserSubject addUserSubject(UserSubject userSubject) {
		getUserSubjects().add(userSubject);
		userSubject.setSubject(this);

		return userSubject;
	}

	public UserSubject removeUserSubject(UserSubject userSubject) {
		getUserSubjects().remove(userSubject);
		userSubject.setSubject(null);

		return userSubject;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", dateOfSubjectRegistration=" + dateOfSubjectRegistration
				+ ", isSubjectActive=" + isSubjectActive + ", courseSubjects=" + courseSubjects + ", topics=" + topics
				+ ", userSubjects=" + userSubjects + "]";
	}

}