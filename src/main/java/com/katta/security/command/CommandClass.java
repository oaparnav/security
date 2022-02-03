package com.katta.security.command;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@Component(value = "commandClass")
public class CommandClass {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	public CommandClass(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Retry(name = "commandClass")
	public String doRun() {
		
		HttpEntity<Void> requestEntity  = new HttpEntity<>(new HttpHeaders());
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://dummyUrl", HttpMethod.GET, requestEntity, String.class);
		
		return responseEntity.getBody();
	}
	

}
