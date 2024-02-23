package com.xworkz.vendormanage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.vendormanage")
@EnableWebMvc
public class SpringConfiguration {
	public SpringConfiguration() {
		System.out.println("Created SpringConfiguration....");
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntity() {
		
		return new LocalContainerEntityManagerFactoryBean();
	}

}
