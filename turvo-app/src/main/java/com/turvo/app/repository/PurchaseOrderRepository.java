package com.turvo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turvo.app.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, Double>{

}
