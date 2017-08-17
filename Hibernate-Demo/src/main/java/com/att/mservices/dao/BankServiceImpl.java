package com.att.mservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.main.pojos.Bank;

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

}
