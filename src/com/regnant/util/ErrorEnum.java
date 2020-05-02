package com.regnant.util;

public enum ErrorEnum {
	
	ERRO1("ERRO1" ,"INVALID AGE"),
	ERRO2( "ERRO2","invalid city"),
	ERRO3( "ERRO3","email already exists..."),
	ERRO4( "ERRO4","Login name already exists..."),
	ERROR5("ERRO5","user Does not Exists");
	

	private String errorCode;
	private String msg;
	
	private ErrorEnum(String errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getMsg() {
		return msg;
	}

}
