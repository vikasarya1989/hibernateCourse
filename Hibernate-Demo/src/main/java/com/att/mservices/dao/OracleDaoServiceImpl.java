package com.att.mservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.att.main.pojos.Person;

@Repository
@Transactional(value="oracleTransactionManager")
public class OracleDaoServiceImpl implements OracleDaoService {

	@PersistenceContext
	@Qualifier(value="oracleEntityManager")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersonDetails() {
		String hql_all_person_details = "FROM Person";
		return (List<Person>)entityManager.createQuery(hql_all_person_details).getResultList();
	}
}
