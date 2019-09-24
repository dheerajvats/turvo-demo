package com.turvo.app.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.app.dao.utils.Response;
import com.turvo.app.pojo.ProductResponse;
import com.turvo.app.pojo.TurvoProduct;
import com.turvo.app.service.IProductService;

@RestController
@CrossOrigin
public class ProductResource {
	
	@Autowired
	IProductService productService;
	
	@PostMapping(value = "/addProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> addNewProduct(@RequestBody TurvoProduct product, HttpServletRequest request) {
		
		productService.saveNewProduct(product);
		
		ProductResponse response = new ProductResponse("Product added successfully");
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}

}
