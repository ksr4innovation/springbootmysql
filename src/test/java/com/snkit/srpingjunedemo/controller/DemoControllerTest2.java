package com.snkit.srpingjunedemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snkit.srpingjunedemo.service.OrderProxyService;
import com.snkit.srpingjunedemo.service.OrderServiceInterface;
import com.snkit.srpingjunedemo.vo.Order;
import com.snkit.srpingjunedemo.vo.OrderItem;


@RunWith(MockitoJUnitRunner.class)
public class DemoControllerTest2 {
	
	private MockMvc mockmvc;


	
	@InjectMocks
	DemoController demoController;
	
	
	@Mock
	OrderServiceInterface bussinessOrderService;
	
	@Mock
	OrderServiceInterface anonomusOrderService;
	
	@Mock
	OrderProxyService orderProxyService;
	
	Order order;
	
	ObjectMapper objectMapper;
	
	JacksonTester jacksonTester;
	
	Order orderResp;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(demoController);
		
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
			
			
			orderResp = new Order();
			orderResp.setCustomerId("kollu.srinu@gmail.com");
			orderResp.setCustType("A");
			orderResp.setEmail("kollu.srinu@gmail.com");
			orderResp.setOrderAmount(new Double(205));
				
				OrderItem orderItemresp = new OrderItem();
				orderItemresp.setProductName("laptop");
				orderItemresp.setItemCost(new Double(10000));
				
				OrderItem orderItemresp1 = new OrderItem();
				orderItemresp1.setProductName("laptop");
				orderItemresp1.setItemCost(new Double(10000));
				orderResp.getOrderItems().add(orderItemresp);
				
				orderResp.getOrderItems().add(orderItemresp1);
		
		
	}
	
	@Test
	public void testSayHi() throws Exception {
		
		
		mockmvc.perform(get("/getMapping")).
		andExpect(status().isOk()).
		andExpect(content().string("Rest Service example @GetMapping"));
		
		
		
		
	}

	@Test
	public void testSaveOrder() throws Exception {
		
		
		
		
		when(orderProxyService.invoke(anonomusOrderService,order)).thenReturn(orderResp);
		
		
		mockmvc.perform(post("/persistOrder")
				.accept("application/vnd.snkit-v1+json")
				.contentType("application/vnd.snkit-v1+json").content(jacksonTester.write(order).getJson())).andDo(print())
		.andExpect(status().isOk()).andExpect(jsonPath("orderAmount").value(new Double(180)))
		.andExpect(jsonPath("$['orderItems'].[0].productName").value("laptop"));
		
		
	}
	
	
}
