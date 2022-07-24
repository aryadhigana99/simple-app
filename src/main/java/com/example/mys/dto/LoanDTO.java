package com.example.mys.dto;

import java.math.BigDecimal;
import java.util.Date;

public class LoanDTO {

	private Long id;
	
	private Long accountId;
	
	private String name;
	
	private String typeLoan;
	
	private Date loanDate;
	
	private BigDecimal loanAmount;
	
	private BigDecimal payment;

	public LoanDTO(Long id, Long accountId, String name, String typeLoan, Date loanDate, BigDecimal loanAmount,
			BigDecimal payment) {
		this.id = id;
		this.accountId = accountId;
		this.name = name;
		this.typeLoan = typeLoan;
		this.loanDate = loanDate;
		this.loanAmount = loanAmount;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTypeLoan() {
		return typeLoan;
	}

	public void setTypeLoan(String typeLoan) {
		this.typeLoan = typeLoan;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	
}
