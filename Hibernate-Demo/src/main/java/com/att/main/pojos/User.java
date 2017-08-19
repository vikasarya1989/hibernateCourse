package com.att.main.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="FINANCES_USER")
public class User {
	
	@Id
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "DD-MON-YYYY")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="DD-MON-YYYY")
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailId;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "DD-MON-YYYY")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="DD-MON-YYYY")
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdated;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "DD-MON-YYYY")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="DD-MON-YYYY")
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Embedded
	private UserAddress userAddress = new UserAddress();

	public Long getuserId() {
		return userId;
	}
	public void setuserId(Long userId) {
		this.userId = userId;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserAddressLineOne() {
		return userAddress.userAddressLineOne;
	}
	public void setUserAddressLineOne(String userAddressLineOne) {
		this.userAddress.userAddressLineOne = userAddressLineOne;
	}
	public String getUserAddressLineTwo() {
		return userAddress.userAddressLineTwo;
	}
	public void setUserAddressLineTwo(String userAddressLineTwo) {
		this.userAddress.userAddressLineTwo = userAddressLineTwo;
	}
	public String getCity() {
		return userAddress.city;
	}
	public void setCity(String city) {
		this.userAddress.city = city;
	}
	public String getState() {
		return userAddress.state;
	}
	public void setState(String state) {
		this.userAddress.state = state;
	}
	public String getZipcode() {
		return userAddress.zipcode;
	}
	public void setZipcode(String zipcode) {
		this.userAddress.zipcode = zipcode;
	}
	
}
