package com.att.main.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="FINANCES_USER")
public class User {
	
	@Id
	@Column(name="USER_ID")
	private Long userId;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="users")
	private List<Account> accounts = new ArrayList<Account>();
	
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
	
	@ElementCollection
	@CollectionTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	private List<UserAddress> userAddress = new ArrayList<UserAddress>();

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
