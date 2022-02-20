package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "loans")
@SequenceGenerator(name = "public.loans_loan_number_seq", sequenceName = "public.loans_loan_number_seq", initialValue = 1, allocationSize = 1)
public class Loans implements Serializable {
	
	@Id
	@Column(name = "loan_number")
	@GeneratedValue(generator = "public.loans_loan_number_seq", strategy = GenerationType.SEQUENCE)
	private Long loanNumber;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name="start_dt")
	private LocalDate startDt;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "total_loan")
	private Long totalLoan;
	
	@Column(name = "amount_paid")
	private Long amountPaid;
	
	@Column(name = "outstanding_amount")
	private Long outstandingAmount;
	
	@Column(name = "create_dt")
	private LocalDate createDt;

	public Long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Long loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDate getStartDt() {
		return startDt;
	}

	public void setStartDt(LocalDate startDt) {
		this.startDt = startDt;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Long getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(Long totalLoan) {
		this.totalLoan = totalLoan;
	}

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Long getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Long outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
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
		Loans loans = (Loans) o;
		return Objects.equals(loanNumber, loans.loanNumber) && Objects.equals(customerId, loans.customerId) && Objects.equals(startDt, loans.startDt) && Objects.equals(loanType, loans.loanType) && Objects.equals(totalLoan, loans.totalLoan) && Objects.equals(amountPaid, loans.amountPaid) && Objects.equals(outstandingAmount, loans.outstandingAmount) && Objects.equals(createDt, loans.createDt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanNumber, customerId, startDt, loanType, totalLoan, amountPaid, outstandingAmount, createDt);
	}
}
