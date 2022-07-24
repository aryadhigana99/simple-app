package com.example.mys.service.impl;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.mys.dto.LoanDTO;
import com.example.mys.model.Account;
import com.example.mys.model.Loan;
import com.example.mys.other.LoanRequest;
import com.example.mys.other.PaymentRequest;
import com.example.mys.other.RequestResponse;
import com.example.mys.repository.AccountRepository;
import com.example.mys.repository.LoanRepository;
import com.example.mys.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public ResponseEntity<RequestResponse> saveLoan(LoanRequest loanRequest) throws Exception {
		try {
			Optional<Account> account = accountRepository.findById(loanRequest.getAccountId());

			Loan loan = new Loan();
			loan.setTypeLoan(loanRequest.getTypeLoan());
			loan.setLoanAmount(loanRequest.getLoanAmount());
			
			BigDecimal percent = new BigDecimal("0.1");
			BigDecimal interest = loanRequest.getLoanAmount().multiply(percent);
			
			loan.setInterest(interest);
			loan.setTotalLoan(loan.getLoanAmount().add(interest));
			loan.setStatus("OPEN");
			loan.setCreateBy(account.get().getName());
			
			DateTime now = new DateTime();
			LocalDate overDueDate = now.toLocalDate().plusDays(30);
			loan.setOverdueDate(overDueDate.toDate());
			loan.setAccountId(account.get());
			loanRepository.save(loan);
			
			return new ResponseEntity<>(new RequestResponse("200", "OK",null), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RequestResponse> savePayment(PaymentRequest paymentRequest) throws Exception {
		try {
			Optional<Loan> loan = loanRepository.findById(paymentRequest.getLoanId());
			loan.get().setPayment(loan.get().getPayment().add(paymentRequest.getAmount()));
			
			if(loan.get().getPayment().compareTo(loan.get().getTotalLoan()) == 1) {
				loan.get().setChangeBy("SYSTEM");
				loan.get().setChangeOn(new Date());
			} else {
				loan.get().setChangeBy("PAYMENT FUNCTION");
				loan.get().setChangeOn(new Date());
			}
			loanRepository.save(loan.get());
			return new ResponseEntity<>(new RequestResponse("200", "OK",null), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RequestResponse> checkLoanOpen(Date today,String status) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<LoanDTO> response = loanRepository.loanList(today,status);
			
			return new ResponseEntity<>(new RequestResponse("200","OK",response), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		return null;
	}

	@Override
	public ResponseEntity<RequestResponse> rejectLoan(Long loanId) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<Loan> loan = loanRepository.findById(loanId);
			
			loan.get().setStatus("REJECT");
			loan.get().setChangeBy("SYSTEM");
			loan.get().setChangeOn(new Date());
			
			loanRepository.save(loan.get());
			return new ResponseEntity<>(new RequestResponse("200", "OK",null), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new RequestResponse("500", e.toString(),null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
