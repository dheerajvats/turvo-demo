package com.turvo.app.dao;

import java.util.List;

import com.turvo.app.entity.Registration;

public interface IRegistrationDataService {
	
	public Double registerForSale(Registration registration);
	
	public  List<Registration> findByCustomerAndSaleId(String customerId, String saleId);

}
