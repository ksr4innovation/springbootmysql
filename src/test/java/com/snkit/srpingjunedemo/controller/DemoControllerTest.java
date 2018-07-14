package com.snkit.srpingjunedemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snkit.srpingjunedemo.vo.Order;
import com.snkit.srpingjunedemo.vo.OrderItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {
	
	
	private MockMvc mockmvc;


	@Autowired
	DemoController demoController;
	
	Order order;
	
	ObjectMapper objectMapper;
	
	JacksonTester jacksonTester;
	
	
	@Before
	public void setup() {
		mockmvc  = MockMvcBuilders.standaloneSetup(demoController).build();
		objectMapper = new ObjectMapper();
		
		 jacksonTester.initFields(this, objectMapper);
		 order = new Order();
			order.setCustomerId("kollu.srinu@gmail.com");
			order.setCustType("A");
			order.setEmail("kollu.srinu@gmail.com");
			order.setOrderAmount(new Double(205));
			
			OrderItem orderItem = new OrderItem();
			orderItem.setProductName("laptop");
			orderItem.setItemCost(new Double(10000));
			
			OrderItem orderItem1 = new OrderItem();
			orderItem1.setProductName("laptop");
			orderItem1.setItemCost(new Double(10000));
			order.getOrderItems().add(orderItem);
			
			order.getOrderItems().add(orderItem1);
		
		
	}
	
	@Test
	public void testSayHi() throws Exception {
		
		
		mockmvc.perform(get("/getMapping")).
		andExpect(status().isOk()).
		andExpect(content().string("Rest Service example @GetMapping"));
		
		
		
		
	}

	@Test
	public void testSaveOrder() throws Exception {
		
		
	
		
		mockmvc.perform(post("/persistOrder")
				.accept("application/vnd.snkit-v1+json")
				.contentType("application/vnd.snkit-v1+json").content(jacksonTester.write(order).getJson())).andDo(print())
		.andExpect(status().isOk()).andExpect(jsonPath("orderAmount").value(new Double(180)))
		.andExpect(jsonPath("$['orderItems'].[0].productName").value("laptop"));
		
		
	}
	
	
}
