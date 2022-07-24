package com.example.mys.dto;

public class EmergencyContactDTO {

	private Long id;
	private String name;
	private String phoneNumber;
	private String relation;
	private String accountName;
	private Long accountId;
	
	
	public EmergencyContactDTO(Long id, String name, String phoneNumber, String relation, String accountName,
			Long accountId) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.relation = relation;
		this.accountName = accountName;
		this.accountId = accountId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "EmergencyContactDTO [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", relation="
				+ relation + ", accountName=" + accountName + ", accountId=" + accountId + "]";
	}
	
	
}
