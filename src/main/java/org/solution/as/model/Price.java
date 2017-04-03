package org.solution.as.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.validation.annotation.Validated;

@Validated
public class Price {

	@PrimaryKey
	@Digits(integer=10,fraction=0)
	private BigInteger id;
	
	@NotNull
	@Digits(integer=10,fraction=2)
	private BigDecimal value;
	
	@NotNull
	private String currency_code;
	
	public Price() {
		
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
}
