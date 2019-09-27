package com.turvo.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.entity.PurchaseOrder;
import com.turvo.app.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderDataService implements IPurchaseOrderDataService {
	
	@Autowired
	PurchaseOrderRepository repository;

	@Override
	public PurchaseOrder saveOrder(PurchaseOrder order) {
		return repository.save(order);
	}

}
