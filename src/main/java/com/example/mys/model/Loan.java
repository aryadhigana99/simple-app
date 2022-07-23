package com.example.mys.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="loan")
public class Loan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "loan_loan_id_seq", sequenceName = "loan_loan_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_loan_id_seq")
	@Column(name="loan_id",nullable = false)
	private Long loanId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="account_id", referencedColumnName = "account_id", nullable = false)
	private Account accountId;
	
	
	@Column(name="loan_amount", nullable = false)
	private Long loanAmount;
	
	@Column(name="type_loan")
	private String typeLoan;
	
	@Column(name="overdue_date")
	private Date overdueDate;
	
	@Column(name="interest")
	private BigDecimal interest;
	
	@Column(name="pay_back")
	private BigDecimal payBack;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getTypeLoan() {
		return typeLoan;
	}

	public void setTypeLoan(String typeLoan) {
		this.typeLoan = typeLoan;
	}

	public Date getOverdueDate() {
		return overdueDate;
	}

	public void setOverdueDate(Date overdueDate) {
		this.overdueDate = overdueDate;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getPayBack() {
		return payBack;
	}

	public void setPayBack(BigDecimal payBack) {
		this.payBack = payBack;
	}
	
	
	
}
