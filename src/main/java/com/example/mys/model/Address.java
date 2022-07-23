package com.example.mys.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "address_address_id_seq", sequenceName = "address_address_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
	@Column(name="address_id",nullable = false)
	private Long addressId;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false )
	private String province;
	
	@Column(name="postal_code",nullable = false)
	private String postalCode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

}
