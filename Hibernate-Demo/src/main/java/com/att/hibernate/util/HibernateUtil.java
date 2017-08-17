package com.att.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.att.main.pojos.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
