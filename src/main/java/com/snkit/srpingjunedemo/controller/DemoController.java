package com.snkit.srpingjunedemo.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snkit.srpingjunedemo.service.OrderProxyService;
import com.snkit.srpingjunedemo.service.OrderServiceInterface;
import com.snkit.srpingjunedemo.vo.Order;

@RestController
public class DemoController {	
	
	private Map<String,Order> map = new HashMap<String,Order>();
	
	@Autowired
	@Qualifier(value="bussinessOrderService")
	OrderServiceInterface orderServiceInterface;
	
	@Autowired
	@Qualifier(value="anonomusOrderService")
	OrderServiceInterface orderServiceInterface1;
	
	@Autowired
	OrderProxyService orderProxyService;
	
	@Autowired
	ObjectMapper  objectMapper;
	
	@GetMapping(value="/getMapping")
	public String sayHi() {
		
		
		
		return "Rest Service example @GetMapping";
	}
	
	@RequestMapping(value="/reqMapping",method=RequestMethod.GET)
	public String sayRequestMapping() {
		return " Rest Service example @RequestMapping";
	}
		
	@PostMapping(value="/persistOrder",consumes= {"application/json","application/xml"},
			produces= {"application/json","application/xml"})
	public Order saveOrder(@RequestBody Order order) {			
		UUID uuid = UUID.randomUUID();			
		order.setUuid(uuid.toString());		
		map.put(order.getUuid(), order);
		order.setStatus("Completed");		
		
		
		if (order.getCustType().equalsIgnoreCase("B")) {
		
		orderProxyService.invoke(orderServiceInterface, order);
		}else {
		
		orderProxyService.invoke(orderServiceInterface1, order);
		}
		return order;		
	}

	
	@PostMapping(value="/persistOrder",
			consumes= {"application/vnd.snkit-v1+json","application/vnd.snkit-v1+xml"},
			produces= {"application/vnd.snkit-v1+json","application/vnd.snkit-v1+xml"})
	public Order saveOrderxyz(@RequestBody Order order) {	
		
	
		UUID uuid = UUID.randomUUID();			
		order.setUuid(uuid.toString());		
		map.put(order.getUuid(), order);
		order.setStatus("XYZProcessed");	
		
		//bussinessOrderService.persistOrder(order);
		
		
		
		order=	orderProxyService.invoke(orderServiceInterface, order);
		
		order =orderProxyService.invoke(orderServiceInterface1, order);
		
		
			
		return order;		
	}

	
	@GetMapping(value="/getOrders")
	public Collection<Order> getOrders() {
		return map.values();
	}
	
	@PostMapping(value="/persistOrderWithOutReqBody")
	public Order persistOrderWithOurReqBody( Order order) {			
		UUID uuid = UUID.randomUUID();			
		order.setUuid(uuid.toString());		
		map.put(order.getUuid(), order);		
		order.setStatus("Completed");		
		return order;
		
	}
	
	
	
	@PostMapping(value="/persistOrder",
			consumes= {"application/vnd.snkit-v2+json","application/vnd.snkit-v2+xml"},
			produces= {"application/vnd.snkit-v2+json","application/vnd.snkit-v2+xml"})
	public Order saveOrder(@RequestBody String str) {			
		UUID uuid = UUID.randomUUID();		
		
		Order order = null;
		try {
			order = objectMapper.readValue(str, Order.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.setUuid(uuid.toString());		
		map.put(order.getUuid(), order);
		order.setStatus("Completed");		
		
		
		if (order.getCustType().equalsIgnoreCase("B")) {
		
		orderProxyService.invoke(orderServiceInterface, order);
		}else {
		
		orderProxyService.invoke(orderServiceInterface1, order);
		}
		return order;		
	}

}
