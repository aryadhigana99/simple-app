package com.example.mys.service.impl;

import java.util.Optional;

import javax.persistence.AccessType;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mys.model.Account;
import com.example.mys.model.Address;
import com.example.mys.model.Device;
import com.example.mys.other.AccountRequest;
import com.example.mys.other.AccountType;
import com.example.mys.other.AddressRequest;
import com.example.mys.other.DeviceRequest;
import com.example.mys.other.RequestResponse;
import com.example.mys.repository.AccountRepository;
import com.example.mys.repository.AddressRepository;
import com.example.mys.repository.DeviceRepository;
import com.example.mys.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
//	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseEntity<RequestResponse> saveAccount(AccountRequest accountRequest) throws Exception {
		try {
			
			Account account = new Account();
			account.setName(accountRequest.getName());
			account.setBirthDate(accountRequest.getBirthDate());
			
			LocalDate birthDate = new LocalDate(accountRequest.getBirthDate());
			LocalDate currentDate = new LocalDate();
			
			Years age = Years.yearsBetween(birthDate, currentDate);
			account.setAccountType(AccountType.CUSTOMER);
			account.setAge(age.getYears());
			
			accountRepository.save(account);
			
			return new ResponseEntity<>(new RequestResponse("200", "OK"), HttpStatus.CREATED);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RequestResponse> updateAddress(AddressRequest addressRequest) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<Account> account = accountRepository.findById(addressRequest.getAccountId());

			Address address = new Address();
			address.setAddress(addressRequest.getAddress());
			address.setCity(addressRequest.getCity());
			address.setPostalCode(addressRequest.getPostalCode());
			address.setProvince(addressRequest.getProvince());
			
			addressRepository.save(address);
			account.get().setAddress(address);
			accountRepository.save(account.get());
			return new ResponseEntity<>(new RequestResponse("200", "OK"), HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}

	@Override
	public ResponseEntity<RequestResponse> updateDevice(DeviceRequest deviceRequest) throws Exception {
		try {
			Optional<Account> account = accountRepository.findById(deviceRequest.getAccountId());

			Device device = new Device();
			
			device.setPhoneNumber(deviceRequest.getPhoneNumber());
			device.setImei(deviceRequest.getImei());
			device.setOs(deviceRequest.getOs());
			
			deviceRepository.save(device);
			account.get().setDeviceId(device);
			accountRepository.save(account.get());
			return new ResponseEntity<>(new RequestResponse("200", "OK"), HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}

}
