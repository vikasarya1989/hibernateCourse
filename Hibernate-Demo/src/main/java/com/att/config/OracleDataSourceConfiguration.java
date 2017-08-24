package com.att.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.att", transactionManagerRef = "oracleTransactionMangerRef", 
						entityManagerFactoryRef = "oracleEntityMangerRef")
public class OracleDataSourceConfiguration {
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix="spring.oracle.datasource")
	public DataSource oracleDataSource() {
		return DataSourceBuilder
				.create()
				.build();
	}
	
	@Primary
	@Bean(name="oracleEntityManager")
	public LocalContainerEntityManagerFactoryBean 
			oracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(oracleDataSource())
				.packages("com.att.main.pojos")
				.build();
				
	}
	
	@Primary
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager 
			oracleTransactionManager(@Qualifier("oracleEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
