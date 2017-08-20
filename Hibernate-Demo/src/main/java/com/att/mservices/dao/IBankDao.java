package com.att.mservices.dao;

import java.util.List;
import java.util.Map;

import com.att.main.pojos.Bank;
import com.att.main.pojos.Credential;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;
import com.att.main.pojos.UserAddress;

public interface IBankDao {
	
	public List<Bank> getAllBankDetails();
	
	public void adduser(User user);
	
	public void addSampleuser(Sampleuser user);
	
	public void addBank(Bank bank);
	
	public Map<String, String> getBankDetailsAsMap();
	
	public void addUserAddressObj(UserAddress userAddress);
	
	public void addCredentialForUser(Credential credential);
}
