package com.snkit.srpingjunedemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snkit.srpingjunedemo.service.OrderProxyService;

@Configuration
public class DemoConfiguration {
	
	@Bean
	OrderProxyService orderProxyService() {
		
		return new OrderProxyService();
	}

	

	
	@Bean
	ObjectMapper objectMapper() {
		
		return new ObjectMapper();
	}
}
