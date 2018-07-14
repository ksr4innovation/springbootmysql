package com.snkit.srpingjunedemo.service;

import org.springframework.stereotype.Service;

import com.snkit.srpingjunedemo.exception.ControllerBodyTestException;
import com.snkit.srpingjunedemo.exception.DemoException;
import com.snkit.srpingjunedemo.vo.Order;

@Service(value="anonomusOrderService")
public class AnonomusOrderService implements OrderServiceInterface {

	@Override
	public Order persistOrder(Order order) {
		 order.setOrderAmount(order.getOrderAmount()-5);
			
		 if (order.getOrderAmount().intValue() == 175) {		 
			 throw new DemoException("CUST001"," Exception handling testing in rest service");
		 }
		 
		 if (order.getOrderAmount().intValue() == 200) {		 
			 throw new ControllerBodyTestException("BODYCUST001"," Exception handling testing in body response rest service");
		 }
		 
		 
			return  order;
	}

}
