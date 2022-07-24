package com.example.mys.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.example.mys.other.AccountRequest;
import com.example.mys.other.LoanRequest;
import com.example.mys.other.PaymentRequest;
import com.example.mys.other.RequestResponse;

public interface LoanService {
	
	public ResponseEntity<RequestResponse> saveLoan(LoanRequest loanRequest) throws Exception;
	public ResponseEntity<RequestResponse> savePayment(PaymentRequest paymentRequest) throws Exception;
	public ResponseEntity<RequestResponse> checkLoanOpen(Date today,String status) throws Exception;

}
