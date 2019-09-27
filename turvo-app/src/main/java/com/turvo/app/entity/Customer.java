package com.turvo.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.turvo.app.dao.utils.CustomerStatus;

@Document(collection = "Customer")
public class Customer {
	
	@Field(value = "Name")
	private String name;
	
	@Id
	private String customerId;
	
	@Field(value= "Address")
	private String shipToAddress;
	
	@Field(value = "Status")
	private CustomerStatus status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}

}