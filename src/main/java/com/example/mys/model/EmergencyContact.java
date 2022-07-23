package com.example.mys.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emergency_contact")
public class EmergencyContact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "emergency_contact_emergency_contact_id_seq", sequenceName = "emergency_contact_emergency_contact_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emergency_contact_emergency_contact_id_seq")
	@Column(name="emergency_contact_id",nullable = false)
	private Long emergencyContactId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="account_id", referencedColumnName = "account_id")
	@Column(nullable = false)
	private Account accountId;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column
	private String name; 
	
	@Column
	private String relation;

	public Long getEmergencyContactId() {
		return emergencyContactId;
	}

	public void setEmergencyContactId(Long emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	

}
