package com.turvo.app.pojo;

import com.turvo.app.dao.utils.Response;

public class ProductResponse extends Response {

	private static final long serialVersionUID = 1L;

	private String message;

	public ProductResponse() {

	}

	public ProductResponse(String message) {
		
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
