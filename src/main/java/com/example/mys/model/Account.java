package com.example.mys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.example.mys.other.AccountType;

@Entity
@Table(name="account")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "account_account_id_seq", sequenceName = "account_account_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_account_id_seq")
	@Column(name="account_id", nullable=false)
	private Long accountId;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne
	@JoinColumn(name="address_id", referencedColumnName = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name="device_id", referencedColumnName = "device_id")
	private Device deviceId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_on")
	private Date createOn = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(nullable = false)
	private Integer age;

	@Column(name="account_type",nullable=true)
	private AccountType accountType;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Device getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Device deviceId) {
		this.deviceId = deviceId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
