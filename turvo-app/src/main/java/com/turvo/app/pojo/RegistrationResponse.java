package com.turvo.app.pojo;

import com.turvo.app.dao.utils.Response;

public class RegistrationResponse extends Response {

	private static final long serialVersionUID = 1L;
	
	private Double registrationId;

	public Double getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Double registrationId) {
		this.registrationId = registrationId;
	}

}
