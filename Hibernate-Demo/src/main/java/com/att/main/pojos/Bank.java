package com.att.main.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="BANK")
public class Bank implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="BANK_ID")
		private Long bankId;
		
		@Column(name="NAME")
		private String name;
		
		@Column(name="ADDRESS_LINE_1")
		private String addressLineOne;
		
		@Column(name="ADDRESS_LINE_2")
		private String addressLineTwo;
		
		@Column(name="CITY")
		private String city;
		
		@ElementCollection
		@CollectionTable(name="BANK_CONTACT", joinColumns=@JoinColumn(name="BANK_ID"))
		@Column(name="NAME")
		private List<String> contactsList = new ArrayList<String>();
		
		public List<String> getContactsList() {
			return contactsList;
		}
		public void setContactsList(List<String> contactsList) {
			this.contactsList = contactsList;
		}
		public Long getBankId() {
			return bankId;
		}
		public void setBankId(Long bankId) {
			this.bankId = bankId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddressLineOne() {
			return addressLineOne;
		}
		public void setAddressLineOne(String addressLineOne) {
			this.addressLineOne = addressLineOne;
		}
		public String getAddressLineTwo() {
			return addressLineTwo;
		}
		public void setAddressLineTwo(String addressLineTwo) {
			this.addressLineTwo = addressLineTwo;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public int getIsInternational() {
			return isInternational;
		}
		public void setIsInternational(int isInternational) {
			this.isInternational = isInternational;
		}
		public String getLastUpdateby() {
			return lastUpdateby;
		}
		public void setLastUpdateby(String lastUpdateby) {
			this.lastUpdateby = lastUpdateby;
		}
		public Date getLastUpdatedDate() {
			return lastUpdatedDate;
		}
		public void setLastUpdatedDate(Date lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
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
		public String getAddresType() {
			return addresType;
		}
		public void setAddresType(String addresType) {
			this.addresType = addresType;
		}
		
		@Column(name="STATE")
		private String state;
		
		@Column(name="ZIP_CODE")
		private String zipcode;
		
		@Column(name="IS_INTERNATIONAL")
		private int isInternational;
		
		@Column(name="LAST_UPDATED_BY")
		private String lastUpdateby;
		
		@Column(name="LAST_UPDATED_DATE")
		private Date lastUpdatedDate;
		
		@Column(name="CREATED_BY")
		private String createdBy;
		
		@Column(name="CREATED_DATE")
		private Date createdDate;
		
		@Column(name="ADDRESS_TYPE")
		private String addresType;
		
		
}
