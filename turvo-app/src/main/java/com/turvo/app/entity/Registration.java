package com.turvo.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.turvo.app.dao.utils.RegistrationStatus;

@Document(collection = "Registration")
public class Registration {
	
	@Id
	private Double registrationId;
	
	@Field(value = "CustomerId")
	private String customerId;
	
	@Field(value = "FlashSaleId")
	private String flashSaleId;
	
	@Field(value = "Status")
	private RegistrationStatus regStatus;

	public Double getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Double registrationId) {
		this.registrationId = registrationId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFlashSaleId() {
		return flashSaleId;
	}

	public void setFlashSaleId(String flashSaleId) {
		this.flashSaleId = flashSaleId;
	}

	public RegistrationStatus getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(RegistrationStatus regStatus) {
		this.regStatus = regStatus;
	}

}
