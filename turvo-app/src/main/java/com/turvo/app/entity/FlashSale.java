package com.turvo.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.turvo.app.dao.utils.SaleStatus;

@Document(collection = "FlashSale")
public class FlashSale {
	
	@Id
	private String flashSaleId;
	
	@Field(value = "ProductId")
	private Double productId;
	
	@Field(value = "Status")
	private SaleStatus status;
	
	@Field(value = "Duration")
	private String durationInSeconds;
	
	@Field(value = "RegistrationOpen")
	private Boolean registrationOpen;

	public String getFlashSaleId() {
		return flashSaleId;
	}

	public void setFlashSaleId(String flashSaleId) {
		this.flashSaleId = flashSaleId;
	}

	public Double getProductId() {
		return productId;
	}

	public void setProductId(Double productId) {
		this.productId = productId;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public String getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(String durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public Boolean getRegistrationOpen() {
		return registrationOpen;
	}

	public void setRegistrationOpen(Boolean registrationOpen) {
		this.registrationOpen = registrationOpen;
	}

}