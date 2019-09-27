package com.turvo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turvo.app.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Double>{

	
}
