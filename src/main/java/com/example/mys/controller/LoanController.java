package com.example.mys.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mys.dto.LoanDTO;
import com.example.mys.other.LoanRequest;
import com.example.mys.other.PaymentRequest;
import com.example.mys.other.RequestResponse;
import com.example.mys.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/create")
	public ResponseEntity<RequestResponse> create(@RequestBody LoanRequest loanRequest){
		try {
			return loanService.saveLoan(loanRequest);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/payment")
	public ResponseEntity<RequestResponse> createPayment(@RequestBody PaymentRequest paymentRequest){
		try {
			return loanService.savePayment(paymentRequest);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/check/{status}")
	public ResponseEntity<RequestResponse> checkLoanOpen(@PathVariable String status)
	{
		try {
			Date today = new Date();
			return loanService.checkLoanOpen(today,status.toUpperCase());
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/hello/{name}")
	public String helloWorld(@PathVariable String name) {
		return "<h1> Hello, "+name+"</h1>";
	}
	
	@PutMapping("reject/{loanId}")
	public ResponseEntity<RequestResponse> rejectLoan(@PathVariable Long loanId)
	{
		try {
			return loanService.rejectLoan(loanId);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
