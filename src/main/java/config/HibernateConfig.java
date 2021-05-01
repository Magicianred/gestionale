package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "config" })
@PropertySource("classpath:application.properties")
public class HibernateConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		
		final BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	/*
	@Bean LocalSessionFactoryBean sessionFactory() {
		
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan((new String[] { "model" }));
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	*/
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em 
	    	= new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "model" });
	
		em.setPersistenceUnitName("testPU");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
	  	return em;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	    return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    properties.setProperty("hibernate.enable_lazy_load_no_trans", env.getProperty("hibernate.enable_lazy_load_no_trans"));
	    properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    
	    return properties;
	}
	
	/*
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
		
		final HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
	final Properties hibernateProperties() {
		
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		return hibernateProperties;
	}
	*/
	

}
