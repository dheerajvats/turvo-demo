package com.turvo.app.dao;

public interface IInventoryDataService {
	
	public Double returnProductInventory(Double productId);
	
	public Double decreaseInventory(Double productId);

}
