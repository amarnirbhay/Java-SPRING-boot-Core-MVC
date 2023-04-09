package com.jsp.spring_boot_crud_with_response_exception.exception;

public class IdNotFoundException extends Exception{
	String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public IdNotFoundException(String msg) {
		super(msg);
		
	}
}
