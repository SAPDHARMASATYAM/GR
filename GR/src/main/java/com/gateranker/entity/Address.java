package com.gateranker.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.domain.Persistable;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable, Persistable<String>  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String addressId;

	@Column(nullable=false, length=100)
	private String city;

	@Column(nullable=false, length=45)
	private String country;

	@Column(nullable=false, length=45)
	private String doorNumber;

	@Column(nullable=false, length=100)
	private String locality;

	@Column(nullable=false, length=6)
	private String pincode;

	@Column(nullable=false, length=45)
	private String state;

	@Column(nullable=false, length=100)
	private String street;

	@Column(nullable=false, length=100)
	private String town;

	@Transient
	private boolean isNew = false;
	
	public Address() {
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDoorNumber() {
		return this.doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String getId() {
		return this.getAddressId();
	}

}