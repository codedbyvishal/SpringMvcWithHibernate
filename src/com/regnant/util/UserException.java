package com.regnant.util;

public class UserException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private final String errorCode;

	public UserException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
