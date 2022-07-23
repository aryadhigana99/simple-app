package com.example.mys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "device_device_id_seq", sequenceName = "device_device_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_device_id_seq")
	@Column(name="device_id",nullable = false)
	private Long device_id;
	
	@Column(name="phone_number",nullable = false)
	private String phoneNumber;
	
	@Column
	private String os;
	
	@Column
	private String imei;

	public Long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	

}
