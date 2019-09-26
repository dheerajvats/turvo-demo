package com.turvo.app.service;

import com.turvo.app.pojo.OrderResponse;
import com.turvo.app.pojo.PurchaseOrderRequest;

public interface IPurchaseOrderService {
	
	public OrderResponse placeOrder(PurchaseOrderRequest orderRequest);

}
