package com.att.hibernate.util;

import java.math.BigDecimal;
import java.util.Date;

import com.att.main.pojos.Account;
import com.att.main.pojos.Transaction;

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

}
