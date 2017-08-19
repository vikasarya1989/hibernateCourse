package com.att.mservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.main.pojos.Bank;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;

@Transactional
@Repository
public class BankServiceImpl implements IBankDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getAllBankDetails() {
		String hql_all_bank_details = "FROM Bank";
		return (List<Bank>) entityManager.createQuery(hql_all_bank_details).getResultList();
	}

	@Override
	public void adduser(User user) {
		entityManager.persist(user);
	}
	

	@Override
	public void addSampleuser(Sampleuser user) {
		System.out.println("User name :" + user.getUserId());
		System.out.println("User Id :" + user.getUserName());
		System.out.println("Created Date : " + user.getCreatedDate());
		entityManager.persist(user);
		
	}

	@Override
	public void addBank(Bank bank) {
		entityManager.persist(bank);
	}

}
