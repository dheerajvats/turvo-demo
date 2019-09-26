package com.turvo.app.pojo;

public class PurchaseOrderRequest {
	
	private Double productId;
	
	private String customerId;
	
	private String saleId;
	
	private Double registrationId;

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

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public Double getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Double registrationId) {
		this.registrationId = registrationId;
	}
	
}
