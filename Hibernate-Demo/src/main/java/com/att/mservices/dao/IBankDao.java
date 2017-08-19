package com.att.mservices.dao;

import java.util.List;

import com.att.main.pojos.Bank;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;

public interface IBankDao {
	
	public List<Bank> getAllBankDetails();
	
	public void adduser(User user);
	
	public void addSampleuser(Sampleuser user);
}
