package com.snkit.srpingjunedemo.vo;

public class OrderItem {
	
	public OrderItem(){
		
	}
	
	private String productName;
	
	private Double itemCost;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	
	

}
