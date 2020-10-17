package com.ohmygacha.domain;

import java.math.BigDecimal;

public class Calculator {
	
	//@DecimalMin(value="0.0", inclusive = false)
	private BigDecimal probability;	
	private Integer pullCost;
	private BigDecimal moneyIn;
	private Integer currencyOut;
	private Integer attempts;
	private Integer totalCost;
	
	
	public BigDecimal getProbability() {
		return probability;
	}

	public void setProbability(BigDecimal probability) {
		this.probability = probability;
	}

	public Integer getPullCost() {
		return pullCost;
	}

	public void setPullCost(Integer pullCost) {
		this.pullCost = pullCost;
	}

	public BigDecimal getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(BigDecimal moneyIn) {
		this.moneyIn = moneyIn;
	}

	public Integer getCurrencyOut() {
		return currencyOut;
	}

	public void setCurrencyOut(Integer currencyOut) {
		this.currencyOut = currencyOut;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	/**this function returns the number of attempts after which the probability 
	 * of an event occurring at least once approaches 100%.
	 * This is calculated using logarithms, a threshold is chosen after which we
	 * consider 0.9999 to be close enough to 1.
	**/
	public int numberOfTrials(BigDecimal probability) {
		int attempts;
		double threshold = 0.00001;
		double temp = probability.doubleValue();
		
		if (temp == 1) {	//log(0) is undefined so return 1 if probability is 1
			return 1;
		}
		// Change of base formula --> logb(x) = loga(x) / loga(b)
		attempts = (int) Math.ceil(Math.log10(threshold) / Math.log10(1 - temp));
		return attempts;
	}
	
	//Computes the expected minimum cost of obtaining a specific loot drop.
	public int totalCost(int attempts, BigDecimal moneyIn, Integer currencyOut, Integer pullCost) {
		double moneyInTemp = moneyIn.doubleValue();
		double conversionRate = moneyInTemp / currencyOut;
		double totalCost = Math.ceil(conversionRate * attempts * pullCost);
		return (int) totalCost;
	}

	@Override
	public String toString() {
		return "Calculator [probability=" + probability + ", pullCost=" + pullCost + ", moneyIn=" + moneyIn
				+ ", currencyOut=" + currencyOut + ", attempts=" + attempts + ", totalCost=" + totalCost + "]";
	}
	
	
	
	
}
