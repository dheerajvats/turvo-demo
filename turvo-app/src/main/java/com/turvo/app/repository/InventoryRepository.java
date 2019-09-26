package com.turvo.app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turvo.app.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, ObjectId>{
	
}
