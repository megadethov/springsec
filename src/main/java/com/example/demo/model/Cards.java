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
@Table(schema = "public", name = "cards")
@SequenceGenerator(name = "public.cards_card_id_seq", sequenceName = "public.cards_card_id_seq", initialValue = 1, allocationSize = 1)
public class Cards implements Serializable {

	@Id
	@Column(name = "card_id")
	@GeneratedValue(generator = "public.cards_card_id_seq", strategy = GenerationType.SEQUENCE)
	private Long cardId;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private Long totalLimit;

	@Column(name = "amount_used")
	private Long amountUsed;

	@Column(name = "available_amount")
	private Long availableAmount;

	@Column(name = "create_dt")
	private LocalDate createDt;

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(Long totalLimit) {
		this.totalLimit = totalLimit;
	}

	public Long getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(Long amountUsed) {
		this.amountUsed = amountUsed;
	}

	public Long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Long availableAmount) {
		this.availableAmount = availableAmount;
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
		Cards cards = (Cards) o;
		return Objects.equals(cardId, cards.cardId) && Objects.equals(customerId, cards.customerId) && Objects.equals(cardNumber, cards.cardNumber) && Objects.equals(cardType, cards.cardType) && Objects.equals(totalLimit, cards.totalLimit) && Objects.equals(amountUsed, cards.amountUsed) && Objects.equals(availableAmount, cards.availableAmount) && Objects.equals(createDt, cards.createDt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardId, customerId, cardNumber, cardType, totalLimit, amountUsed, availableAmount, createDt);
	}
}
