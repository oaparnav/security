package com.katta.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationClass {
	
	@Qualifier("restTemplate")
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
