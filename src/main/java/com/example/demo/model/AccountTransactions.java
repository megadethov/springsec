package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name="account_transactions")
public class AccountTransactions implements Serializable {
	
	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name="transaction_dt")
	private Date transactionDt;
	
	@Column(name = "transaction_summary")
	private String transactionSummary;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_amt")
	private Long transactionAmt;
	
	@Column(name = "closing_balance")
	private Long closingBalance;
	
	@Column(name = "create_dt")
	private LocalDate createDt;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(Long transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public Long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public LocalDate getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AccountTransactions that = (AccountTransactions) o;
		return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(customerId, that.customerId) && Objects.equals(transactionDt, that.transactionDt) && Objects.equals(transactionSummary, that.transactionSummary) && Objects.equals(transactionType, that.transactionType) && Objects.equals(transactionAmt, that.transactionAmt) && Objects.equals(closingBalance, that.closingBalance) && Objects.equals(createDt, that.createDt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionId, accountNumber, customerId, transactionDt, transactionSummary, transactionType, transactionAmt, closingBalance, createDt);
	}
}
