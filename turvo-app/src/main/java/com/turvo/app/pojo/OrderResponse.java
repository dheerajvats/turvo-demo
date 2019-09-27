package com.turvo.app.pojo;

import com.turvo.app.dao.utils.Response;

public class OrderResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Double productId;
		
	private Double orderId;
	
	private String status;

	public Double getProductId() {
		return productId;
	}

	public void setProductId(Double productId) {
		this.productId = productId;
	}

	public Double getOrderId() {
		return orderId;
	}

	public void setOrderId(Double orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
