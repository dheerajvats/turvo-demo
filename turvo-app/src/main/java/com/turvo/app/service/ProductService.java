package com.turvo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.IProductDataService;
import com.turvo.app.entity.Product;
import com.turvo.app.pojo.TurvoProduct;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductDataService dataService;
	
	public void saveNewProduct(TurvoProduct product) {
		Product p = new Product();
		p.setDescription(product.getDescription());
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		dataService.saveProduct(p);
	}

}
