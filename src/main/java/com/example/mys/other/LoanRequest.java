package com.example.mys.other;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accountId;
	private BigDecimal loanAmount;
	private String typeLoan;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getTypeLoan() {
		return typeLoan;
	}
	public void setTypeLoan(String typeLoan) {
		this.typeLoan = typeLoan;
	}


}
