package com.turvo.app.dao;

import com.turvo.app.entity.PurchaseOrder;

public interface IPurchaseOrderDataService {
	
	public PurchaseOrder saveOrder(PurchaseOrder order);

}
