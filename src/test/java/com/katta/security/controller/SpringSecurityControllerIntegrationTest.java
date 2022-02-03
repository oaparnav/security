package com.katta.security.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SpringSecurityControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private MockRestServiceServer mockRestServiceServer;
	private MockHttpServletRequestBuilder requestBuilder;
	@Qualifier("restTemplate")
	@Autowired
	private RestTemplate restTemplate;

	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
		
	}
	
	@Test
	public void shouldReturn200() throws Exception {
		requestBuilder = get("/sayHello");
		
		mockRestServiceServer.expect(MockRestRequestMatchers.requestTo(containsString("/dummyUrl")))
		.andRespond(withSuccess("Success",MediaType.APPLICATION_JSON));
		
		mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	public void shouldReturn500_withRetry() throws Exception {
		requestBuilder = get("/sayHello");
		
		mockRestServiceServer.expect( ExpectedCount.manyTimes(), MockRestRequestMatchers.requestTo(containsString("/dummyUrl")))
		.andRespond(withServerError());
		
		mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
		
	}

}
