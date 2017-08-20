package com.att.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.att.main.pojos.Bank;
import com.att.main.pojos.Credential;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;
import com.att.main.pojos.UserAddress;
import com.att.mservices.dao.IBankDao;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonBackReference;

@Controller
public class DataController {
	
	private IBankDao bankDaoService;
	
	@Autowired
	public void setBankDaoService(IBankDao bankDaoService) {
		this.bankDaoService = bankDaoService;
	}
	
	@RequestMapping(value="/getBankDetails")
	@ResponseBody
	public List<Bank> getAllBankDetails() {
		return bankDaoService.getAllBankDetails();
	}
	
	@RequestMapping(value="/getBankDetailsAsMap")
	@ResponseBody
	public Map<String, String> getBankDetailsAsMap() {
		return bankDaoService.getBankDetailsAsMap();
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public void adduser(@RequestBody User user) {
		bankDaoService.adduser(user);
	}
	
	@RequestMapping(value="/addSampleUser", method=RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public void shoeUser(@RequestBody Sampleuser user) {
		bankDaoService.addSampleuser(user);
		
	}
	
	@RequestMapping(value="/addCredentialForUser")
	@ResponseBody
	public String addCredentialForUser() {
		User user = new User();
		setUserData(user);
		Credential credential = new Credential();
		credential.setUserName("myUserName");
		credential.setPassword("myPassword");
		credential.setUser(user);
		bankDaoService.addCredentialForUser(credential);
		return "credentialUserObj";
	}
	
	@RequestMapping(value="/addUserAddressObj")
	@ResponseBody
	public String addUserAddressObj() {
		UserAddress userAddress1 = new UserAddress();
		setAddressOne(userAddress1);
		bankDaoService.addUserAddressObj(userAddress1);
		return "UserAddressObjText";
	}
	
	@RequestMapping(value="/addUserObj")
	@ResponseBody
	public String returnUserObjText() {
		Date date =  new Date();
		User user = new User();
		UserAddress address1 = new UserAddress();
		UserAddress address2 = new UserAddress();
		setAddressOne(address1);
		setAddressTwo(address2);
		user.getUserAddress().add(address1);
		user.getUserAddress().add(address2);
		setUserData(user);
		bankDaoService.adduser(user);
		return "UserObjText";
	}
	
	@RequestMapping(value="/addBankObj")
	@ResponseBody
	public String addBankObj() {
		Bank bank = new Bank();
		bank.setName("Bank of America");
		bank.setAddressLineOne("44 Green Street");
		bank.setAddressLineTwo("Suite 89");
		bank.setAddresType("Secondary");
		bank.setCity("Wood Bridge");
		bank.setIsInternational(1);
		bank.setCreatedBy("President");
		bank.setCreatedDate(new Date());
		bank.setLastUpdateby("vamsi");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NJ");
		bank.setZipcode("01133");
		bank.getContactsList().put("Manager", "Rodney Lew");
		bank.getContactsList().put("Teller", "Pramendra Tiwari");
		bankDaoService.addBank(bank);
		return "BankObjText";
	}
	
	
	public static void setUserData(User user) {
		user.setuserId(3L);
		user.setFirstName("Pratap");
		user.setLastName("Guttikonda");
		user.setBirthDate(new Date());
		user.setEmailId("pratap.gpv@gmail.com");
		user.setLastUpdatedBy("Pratap");
		user.setLastUpdated(new Date());
		user.setCreatedBy("vamsi");
		user.setCreatedDate(new Date());
	}
	
	public static void setAddressOne(UserAddress address1) {
		address1.setUserAddressLineOne("56 Atherton Drive");
		address1.setUserAddressLineTwo("Apartment 2");
		address1.setCity("Exton");
		address1.setState("PA");
		address1.setZipcode("19351");
	}
	
	public static void setAddressTwo(UserAddress address2) {
		address2.setUserAddressLineOne("2017 E genesse st");
		address2.setUserAddressLineTwo("Apartment D");
		address2.setCity("Syracuse");
		address2.setState("NY");
		address2.setZipcode("13210");
	}
}
