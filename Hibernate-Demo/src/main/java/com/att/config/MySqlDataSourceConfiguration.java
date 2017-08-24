package com.att.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.att", transactionManagerRef = "mySqlTransactionMangerRef", 
						entityManagerFactoryRef = "mySqlEntityMangerRef")
public class MySqlDataSourceConfiguration {
	
		@Bean
		@ConfigurationProperties(prefix="spring.mysql.datasource")
		public DataSource mySqlDataSource() {
			return DataSourceBuilder
					.create()
					.build();
		}
		
		@Bean(name="mySqlEntityManager")
		public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
			return builder
					.dataSource(mySqlDataSource())
					.packages("com.att.main.pojos")
					.build();
					
		}
		
		@Bean(name = "mySqlTransactionManager")
		public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManager") EntityManagerFactory entityManagerFactory) {
			return new JpaTransactionManager(entityManagerFactory);
		}
}
