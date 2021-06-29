package com.te.productmangment.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {

	@Bean
	public LocalEntityManagerFactoryBean getFactory() {
		LocalEntityManagerFactoryBean entityManagerFactory = new LocalEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName("emsPeristenceUnit");
		return entityManagerFactory;
	}// 
	
	
//	LocalContainerEntityManagerFactoryBean
	
	public LocalContainerEntityManagerFactoryBean getManger() {
		LocalContainerEntityManagerFactoryBean entityManger = new LocalContainerEntityManagerFactoryBean();
		entityManger.setPersistenceUnitName("emsPeristenceUnit");
		return entityManger;
	}
}

