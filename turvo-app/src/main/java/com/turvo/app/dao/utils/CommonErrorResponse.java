package com.turvo.app.dao.utils;

public class CommonErrorResponse extends Response {
	
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String errorDesciption;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesciption() {
		return errorDesciption;
	}

	public void setErrorDesciption(String errorDesciption) {
		this.errorDesciption = errorDesciption;
	}

}
