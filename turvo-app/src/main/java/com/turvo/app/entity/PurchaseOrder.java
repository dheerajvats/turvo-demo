package com.turvo.app.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.turvo.app.dao.utils.OrderStatus;

@Document(collection = "PurchaseOrder")
public class PurchaseOrder {
	
	@Id
	private Double orderId;
	
	@Field(value = "ProductId")
	private Double productId;
	
	@Field(value = "CustomerId")
	private String customerId;
	
	@Field(value = "CreatedAt")
	private Date orderedAt;
	
	@Field(value = "UpdatedAt")
	private Date lastUpdated;
	
	@Field(value = "Status")
	private OrderStatus orderStatus;

	public Double getOrderId() {
		return orderId;
	}

	public void setOrderId(Double orderId) {
		this.orderId = orderId;
	}

	public Double getProductId() {
		return productId;
	}

	public void setProductId(Double productId) {
		this.productId = productId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
