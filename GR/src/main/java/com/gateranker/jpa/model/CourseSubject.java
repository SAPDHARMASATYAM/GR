package com.gateranker.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * @author Sap Dharma Satyam
 */
import java.util.UUID;

/**
 * The persistent class for the course_subject database table.
 * 
 */
@Entity
@Table(name="course_subject")
@NamedQuery(name="CourseSubject.findAll", query="SELECT c FROM CourseSubject c")
public class CourseSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_subject_added")
	private Date dateOfSubjectAdded;

	@Column(name="is_subject_active_in_course")
	private boolean isSubjectActiveInCourse;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="course_name")
	private Course course;
	
	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_name")
	private Subject subject;

	public CourseSubject() {
	}

	

	public Date getDateOfSubjectAdded() {
		return this.dateOfSubjectAdded;
	}

	public void setDateOfSubjectAdded(Date dateOfSubjectAdded) {
		this.dateOfSubjectAdded = dateOfSubjectAdded;
	}

	public boolean getIsSubjectActiveInCourse() {
		return this.isSubjectActiveInCourse;
	}

	public void setIsSubjectActiveInCourse(boolean isSubjectActiveInCourse) {
		this.isSubjectActiveInCourse = isSubjectActiveInCourse;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public void setSubjectActiveInCourse(boolean isSubjectActiveInCourse) {
		this.isSubjectActiveInCourse = isSubjectActiveInCourse;
	}



	@Override
	public String toString() {
		return "CourseSubject [id=" + id + ", dateOfSubjectAdded=" + dateOfSubjectAdded + ", isSubjectActiveInCourse="
				+ isSubjectActiveInCourse + ", course=" + course + ", subject=" + subject + "]";
	}
	

}