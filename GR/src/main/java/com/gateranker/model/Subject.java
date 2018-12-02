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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable, Persistable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_name", nullable=false, unique=true)
	private String subjectName;

	@Column(name="is_subject_active", nullable=false)
	private boolean isSubjectActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_subject_registration", nullable = true)
	private Date datOfSubjectRegistration;

	@Transient
	@JsonIgnore
	private boolean isNew = false;
	
	public Subject() {
		super();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public boolean isSubjectActive() {
		return isSubjectActive;
	}

	public void setSubjectActive(boolean isSubjectActive) {
		this.isSubjectActive = isSubjectActive;
	}

	public Date getDatOfSubjectRegistration() {
		return datOfSubjectRegistration;
	}

	public void setDatOfSubjectRegistration(Date datOfSubjectRegistration) {
		this.datOfSubjectRegistration = datOfSubjectRegistration;
	}

	@Override
	public String getId() {
		return this.getSubjectName();
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
		return "Subject [subjectName=" + subjectName + ", isSubjectActive=" + isSubjectActive
				+ ", datOfSubjectRegistration=" + datOfSubjectRegistration + ", isNew=" + isNew + "]";
	}
	
}
