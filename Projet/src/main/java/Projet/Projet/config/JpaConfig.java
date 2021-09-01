package Projet.Projet.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("Projet.Projet.dao")
public class JpaConfig {
	
	@Bean
	public DataSource dataSource (){
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/projet-ajc");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		dataSource.setMaxTotal(10);
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		//Fournisseur JPA : Hibernate
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		//Configurer l'emf
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("Projet.Projet.model");
		emf.setJpaVendorAdapter(vendorAdapter);
		
		//Configurer les propriètés du vendor
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "false");
		
		//Associer ces propriètés à l'emf
		emf.setJpaProperties(hibernateProperties);
		
		return emf;	
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		//Associer emf au gestionnaire de transactions
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
}
