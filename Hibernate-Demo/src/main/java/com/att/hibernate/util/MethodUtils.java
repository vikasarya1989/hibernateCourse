package com.att.hibernate.util;

import java.math.BigDecimal;
import java.util.Date;

import com.att.main.pojos.Account;
import com.att.main.pojos.Transaction;
import com.att.main.pojos.User;

public class MethodUtils {
	
	public static Transaction getbeltPurchaseTx(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setLastUpdatedby("Kevin");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("Many To One Bidirectional Belt Purchase");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}
	
	public static Account getAccountFieldDataOne() {
		Account account = new Account();
		account.setInitialBalance(new BigDecimal("1001.00"));
		account.setCurrentBalance(new BigDecimal("888.00"));
		account.setCreatedBy("John");
		account.setCreatedDate(new Date());
		account.setLastupdatedBy("john");
		account.setLasUpdatedDate(new Date());
		account.setOpenDate(new Date());
		account.setCloseDate(new Date());
		account.setName("Home Loan Account");
		return account;
	}
	
	public static Account getAccountFieldDataTwo() {
		Account account = new Account();
		account.setInitialBalance(new BigDecimal("1111.00"));
		account.setCurrentBalance(new BigDecimal("666.00"));
		account.setCreatedBy("Donald");
		account.setCreatedDate(new Date());
		account.setLastupdatedBy("Donald");
		account.setLasUpdatedDate(new Date());
		account.setOpenDate(new Date());
		account.setCloseDate(new Date());
		account.setName("Auto Loan Account");
		return account;
	}
	
	public static User getUserDataOne() {
		User user = new User();
		user.setuserId(7L);
		user.setFirstName("UserOne");
		user.setLastName("userOne");
		user.setBirthDate(new Date());
		user.setEmailId("user.user@gmail.com");
		user.setLastUpdatedBy("U1");
		user.setLastUpdated(new Date());
		user.setCreatedBy("U1");
		user.setCreatedDate(new Date());
		return user;
	}
	
	public static User getUserDataTwo() {
		User user = new User();
		user.setuserId(9L);
		user.setFirstName("UserTwo");
		user.setLastName("UserTwo");
		user.setBirthDate(new Date());
		user.setEmailId("user2.user2@gmail.com");
		user.setLastUpdatedBy("U2");
		user.setLastUpdated(new Date());
		user.setCreatedBy("U2");
		user.setCreatedDate(new Date());
		return user;
	}

}
