package com.att.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.att.main.pojos.Bank;
import com.att.mservices.dao.IBankDao;

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
}
