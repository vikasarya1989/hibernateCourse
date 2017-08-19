package com.att.main.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	@Column(name="USER_ADDRESS_LINE_1")
	public String userAddressLineOne;
	@Column(name="USER_ADDRESS_LINE_2")
	public String userAddressLineTwo;
	@Column(name="CITY")
	public String city;
	@Column(name="STATE")
	public String state;
	@Column(name="ZIP_CODE")
	public String zipcode;
	
	public String getUserAddressLineOne() {
		return userAddressLineOne;
	}
	public void setUserAddressLineOne(String userAddressLineOne) {
		this.userAddressLineOne = userAddressLineOne;
	}
	public String getUserAddressLineTwo() {
		return userAddressLineTwo;
	}
	public void setUserAddressLineTwo(String userAddressLineTwo) {
		this.userAddressLineTwo = userAddressLineTwo;
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
	
	public UserAddress() {
	}
}