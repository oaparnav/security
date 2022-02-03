package com.katta.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class SecurityApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void shouldReturn200_WhenValidAuthTokenIsPassed() throws Exception {
		mockMvc.perform(get("/sayHello").header("auth-token", "xyz")).andExpect(status().isOk());
	}


}
