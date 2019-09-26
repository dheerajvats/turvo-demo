package com.turvo.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Inventory")
public class Inventory {
	
	@Id
	private String inventoryId;
	
	@Field(value = "ProductId")
	private Double productId;
	
	@Field(value = "Quantity")
	private Double quantity;

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Double getProductId() {
		return productId;
	}

	public void setProductId(Double productId) {
		this.productId = productId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
