package com.turvo.app.dao.utils;

import java.io.Serializable;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String message;

	public Response() {

	}

	public Response(String message) {
		
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
