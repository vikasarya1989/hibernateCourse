package com.att.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
