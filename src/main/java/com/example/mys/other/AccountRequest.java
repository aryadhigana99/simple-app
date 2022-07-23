package com.example.mys.other;

import java.io.Serializable;
import java.util.Date;

public class AccountRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "AccountRequest [name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
