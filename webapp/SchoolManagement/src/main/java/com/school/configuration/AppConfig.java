package com.school.configuration;

import static org.hibernate.cfg.Environment.*;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.school.dao"),
		@ComponentScan("com.school.service")})
public class AppConfig {

	@Autowired
	private Environment env;
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean =new LocalSessionFactoryBean();
		Properties prop=new Properties();
		
		prop.put(DRIVER,env.getProperty("mysql.driver") );
		prop.put(URL,env.getProperty("mysql.url") );
		prop.put(USER,env.getProperty("mysql.username") );
		prop.put(PASS,env.getProperty("mysql.password") );
		
		prop.put(SHOW_SQL,env.getProperty("hibernate.show_sql") );
		prop.put(HBM2DDL_AUTO,env.getProperty("hibernate.hbm2ddl.auto") );
		
		prop.put(C3P0_MIN_SIZE,env.getProperty("hibernate.c3p0.min_size") );
		prop.put(C3P0_MAX_SIZE,env.getProperty("hibernate.c3p0.max_size") );
		prop.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increment") );
		prop.put(C3P0_TIMEOUT,env.getProperty("hibernate.c3p0.timeout") );
		prop.put(C3P0_MAX_STATEMENTS,env.getProperty("hibernate.c3p0.max_statements") );
	
		factoryBean.setHibernateProperties(prop);
		factoryBean.setPackagesToScan("com.school.modal");
		
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
