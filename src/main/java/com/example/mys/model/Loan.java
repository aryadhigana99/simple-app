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
	private BigDecimal loanAmount;
	
	@Column(name="type_loan")
	private String typeLoan;
	
	@Column(name="overdue_date")
	private Date overdueDate;
	
	@Column(name="interest")
	private BigDecimal interest;
	
	@Column(name="total_loan")
	private BigDecimal totalLoan;
	
	@Column
	private BigDecimal payment = new BigDecimal("0");
	
	@Column
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="loan_date")
	private Date loanDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_on")
	private Date createOn = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_on")
	private Date changeOn;
	
	@Column(name="create_by")
	private String createBy;
	
	@Column(name="change_by")
	private String changeBy;
	
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

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
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

	public BigDecimal getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(BigDecimal totalLoan) {
		this.totalLoan = totalLoan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getChangeOn() {
		return changeOn;
	}

	public void setChangeOn(Date changeOn) {
		this.changeOn = changeOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	
	
	
	
	
}
