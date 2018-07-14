package com.snkit.srpingjunedemo.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.snkit.srpingjunedemo.vo.Order;

public class OrderProxyService {
	

	public Order invoke(OrderServiceInterface orderService, Order order){
		
	
	
		
		orderService.persistOrder(order);
		
		
		return order;
		
	}

}
