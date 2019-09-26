package com.turvo.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.turvo.app.entity.Inventory;

@Service
public class InventoryDataService implements IInventoryDataService {
	
	@Autowired
	MongoTemplate inventoryTemplate;

	@Override
	public Double returnProductInventory(Double productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("ProductId").is(productId));
		
		Inventory inventory = inventoryTemplate.findOne(query, Inventory.class);
		return inventory.getQuantity();
	}

	@Override
	public Double decreaseInventory(Double productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("ProductId").is(productId));
		
		Update update = new Update();
		update.inc("Quantity", -1);
		
		Inventory inventory = inventoryTemplate.findAndModify(query, update, Inventory.class);
		return inventory.getQuantity();
	}

}
