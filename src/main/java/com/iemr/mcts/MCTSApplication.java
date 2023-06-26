package com.iemr.mcts;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.iemr.mcts.utils.IEMRApplBeans;

@SpringBootApplication
@EnableScheduling
public class MCTSApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(mctsApplication, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { MCTSApplication.class });
	}

	private static Class<MCTSApplication> mctsApplication = MCTSApplication.class;

	@Bean(name = "fieldProperties")
	public static PropertiesFactoryBean fieldProperties() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("fields.properties"));
		return bean;
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IEMRApplBeans instantiateBeans(){
		
		return new IEMRApplBeans();
	}
}

