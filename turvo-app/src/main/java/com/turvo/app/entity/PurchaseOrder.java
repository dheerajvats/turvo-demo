package com.turvo.app.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.turvo.app.dao.utils.OrderStatus;

public class PurchaseOrder {
	
	@Id
	private String orderId;
	
	@Field(value = "ProductId")
	private String productId;
	
	@Field(value = "CustomerId")
	private String customerId;
	
	@Field(value = "CreatedAt")
	private Date orderedAt;
	
	@Field(value = "UpdatedAt")
	private Date lastUpdated;
	
	@Field(value = "Status")
	private OrderStatus orderStatus;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
