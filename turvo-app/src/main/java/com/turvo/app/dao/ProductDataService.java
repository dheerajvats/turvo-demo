package com.turvo.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.entity.Product;
import com.turvo.app.repository.ProductRepository;

@Service
public class ProductDataService implements IProductDataService {
	
	@Autowired
	ProductRepository repository;
	
	public void saveProduct(Product product) {
		repository.save(product);
		
	}
	
}
