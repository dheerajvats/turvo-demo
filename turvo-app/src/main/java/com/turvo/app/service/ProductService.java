package com.turvo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.ICountersDataService;
import com.turvo.app.dao.IProductDataService;
import com.turvo.app.entity.Product;
import com.turvo.app.pojo.TurvoProduct;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductDataService productDataService;
	
	@Autowired
	ICountersDataService counterDataService;
	
	@Override
	public void saveNewProduct(TurvoProduct product) {
		Product newProduct = productDAOConvertor(product);
		productDataService.saveProduct(newProduct);
	}
	
	private Product productDAOConvertor (TurvoProduct product) {
		Product dbProductEntity = new Product();
		dbProductEntity.setDescription(product.getDescription());
		dbProductEntity.setName(product.getName());
		dbProductEntity.setPrice(product.getPrice());
		dbProductEntity.setProductId(counterDataService.getNextValue("productid"));
		return dbProductEntity;
	}

}