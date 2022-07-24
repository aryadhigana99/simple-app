package com.example.mys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mys.other.AccountRequest;
import com.example.mys.other.AddressRequest;
import com.example.mys.other.DeviceRequest;
import com.example.mys.other.EmergencyContactRequest;
import com.example.mys.other.RequestResponse;
import com.example.mys.service.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {

//	private final AccountRepository accountRepository;
//	
//	public AccountController(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//	}
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<RequestResponse> create(@RequestBody AccountRequest accountRequest) throws Exception{
		try {
			return accountService.saveAccount(accountRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/address")
	public ResponseEntity<RequestResponse> updateAddress(@RequestBody AddressRequest addressRequest) throws Exception{
		try {
			return accountService.updateAddress(addressRequest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/device")
	public ResponseEntity<RequestResponse> updateDevice(@RequestBody DeviceRequest deviceRequest) throws Exception{
		try {
			return accountService.updateDevice(deviceRequest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/emgc")
	public ResponseEntity<RequestResponse> addEmergencyContact(@RequestBody EmergencyContactRequest request) throws Exception{
		try {
			return accountService.addEmergencyContact(request);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping
//	public String check(@RequestParam(name = "str", defaultValue = "",required = false) String str) {
//		
//		return "<h1> Hello World </h1>"+str;
//	}
//	
//	@GetMapping("/{accountName}")
//	public String checkTwo(@PathVariable("accountName") String accountName) {
//		
//		return "<h1> Hello World "+accountName+"</h1>";
//	}
//	
//	@GetMapping("/coba")
//	public String checkThree(@RequestBody AccountRequest accountRequest) {
//		
//		return accountRequest.getName()+" "+accountRequest.getBirthDate();
//	}
	
}
