package com.snkit.srpingjunedemo.service;

import org.springframework.stereotype.Service;

import com.snkit.srpingjunedemo.vo.Order;

@Service(value="bussinessOrderService")
public class BussinessOrderService implements OrderServiceInterface {

	@Override
	public Order persistOrder(Order order) {
		
		 order.setOrderAmount(order.getOrderAmount()-20);
		
		return  order;
	}

}
