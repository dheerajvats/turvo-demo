package com.turvo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turvo.app.entity.FlashSale;

@Repository
public interface FlashSaleRepository extends MongoRepository<FlashSale, String>{

}
