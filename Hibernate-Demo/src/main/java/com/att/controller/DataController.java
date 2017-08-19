package com.att.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.att.hibernate.util.InifniteUserUtil;
import com.att.main.pojos.Bank;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;
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
	
	@RequestMapping(value="/addUserObj")
	@ResponseBody
	public String returnUserObjText() {
		Date date =  new Date();
		User user = new User();
		user.setuserId(1L);
		user.setFirstName("vamsi");
		user.setLastName("Guttikonda");
		user.setBirthDate(date);
		user.setEmailId("vamsi.gpv@gmail.com");
		user.setLastUpdatedBy("vamsi");
		user.setLastUpdated(date);
		user.setCreatedBy("vamsi");
		user.setCreatedDate(date);
		user.setUserAddressLineOne("585 S lincoln ave");
		user.setUserAddressLineTwo("Apartment 2");
		user.setCity("Woodbridge");
		user.setState("NY");
		user.setZipcode("13210");
		bankDaoService.adduser(user);
		return "UserObjText";
	}
	
	@RequestMapping(value="/addBankObj")
	@ResponseBody
	public String addBankObj() {
		Bank bank = new Bank();
		bank.setName("Bank of America");
		bank.setAddressLineOne("44 Wall Street");
		bank.setAddressLineTwo("Suite 43");
		bank.setAddresType("Apartment");
		bank.setCity("NewwYork");
		bank.setIsInternational(0);
		bank.setCreatedBy("Vamsi");
		bank.setCreatedDate(new Date());
		bank.setLastUpdateby("vamsi");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipcode("01133");
		bank.getContactsList().add("Mary");
		bank.getContactsList().add("Sandra");
		bankDaoService.addBank(bank);
		return "BankObjText";
	}
}
