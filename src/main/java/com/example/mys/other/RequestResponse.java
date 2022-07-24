package com.example.mys.other;

import java.io.Serializable;

public class RequestResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String code;
	
	String message;
	
	Object object;

	public RequestResponse(String code, String message, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.object = object;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
