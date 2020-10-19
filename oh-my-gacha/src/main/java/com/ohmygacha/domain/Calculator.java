package com.ohmygacha.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;

public class Calculator {
	
	@DecimalMin(value="0.0", inclusive = false, message = "Probability must be between 0 and 1")
	@DecimalMax(value="1.0", inclusive = true, message = "Probability must be between 0 and 1")
	private BigDecimal probability;	
	@PositiveOrZero(message = "Must be greater than or equal to zero")
	@Digits(integer = 9, fraction = 0, message="Must be a positive integer")
	private BigInteger pullCost;
	@PositiveOrZero(message = "Must be greater than or equal to zero")
	private BigDecimal moneyIn;
	@PositiveOrZero(message = "Must be greater than or equal to zero")
	@Digits(integer = 9, fraction = 0, message="Must be a positive integer")
	private BigInteger currencyOut;
	private double conversionRate;
	private int attempts;
	private BigInteger totalCost;
	
	
	public BigDecimal getProbability() {
		return probability;
	}

	public void setProbability(BigDecimal probability) {
		this.probability = probability;
	}

	public BigInteger getPullCost() {
		return pullCost;
	}

	public void setPullCost(BigInteger pullCost) {
		this.pullCost = pullCost;
	}

	public BigDecimal getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(BigDecimal moneyIn) {
		this.moneyIn = moneyIn;
	}

	public BigInteger getCurrencyOut() {
		return currencyOut;
	}

	public void setCurrencyOut(BigInteger currencyOut) {
		this.currencyOut = currencyOut;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public BigInteger getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigInteger totalCost) {
		this.totalCost = totalCost;
	}
	
	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	/**this function returns the number of attempts after which the probability 
	 * of an event occurring at least once approaches 100%.
	 * This is calculated using logarithms, a threshold is chosen after which we
	 * consider 0.9999 to be close enough to 1.
	**/
	public int numberOfTrials(BigDecimal probability) {
		int attempts;
		double threshold = 0.0001;
		double temp = probability.doubleValue();
		
		if (temp == 1) {	//log(0) is undefined so return 1 if probability is 1
			return 1;
		}
		// Change of base formula --> logb(x) = loga(x) / loga(b)
		attempts = (int) Math.ceil(Math.log10(threshold) / Math.log10(1 - temp));
		return attempts;
	}
	
	//Computes the expected minimum cost of obtaining a specific loot drop.
	public BigInteger totalCost(int attempts, BigDecimal moneyIn, BigInteger currencyOut, BigInteger pullCost) {
		double moneyInTemp = moneyIn.doubleValue();
		int currencyTemp = currencyOut.intValue();
		int pullTemp = pullCost.intValue();
		conversionRate = moneyInTemp / currencyTemp;
		double totalCost = Math.ceil(conversionRate * attempts * pullTemp);
		return BigInteger.valueOf((long) totalCost);
	}

	@Override
	public String toString() {
		return "Calculator [probability=" + probability + ", pullCost=" + pullCost + ", moneyIn=" + moneyIn
				+ ", currencyOut=" + currencyOut + ", attempts=" + attempts + ", totalCost=" + totalCost + "]";
	}
	
	
	
	
}
