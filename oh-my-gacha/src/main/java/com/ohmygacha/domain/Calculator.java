package com.ohmygacha.domain;

public class Calculator {
	
	private double probability;
	private int pullCost;
	private double moneyIn;
	private int currencyOut;
	private int attempts;
	private double totalCost;
	
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public int getCurrencyOut() {
		return currencyOut;
	}

	public void setCurrencyOut(int currencyOut) {
		this.currencyOut = currencyOut;
	}

	public int getPullCost() {
		return pullCost;
	}

	public void setPullCost(int pullCost) {
		this.pullCost = pullCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**this function returns the number of attempts after which the probability 
	 * of an event occurring at least once approaches 100%.
	 * This is calculated using logarithms, a threshold is chosen after which we
	 * consider 0.9999 to be close enough to 1.
	**/
	public int numberOfTrials(double probability) {
		int attempts;
		double threshold = 0.00001;
		if (probability == 1) {	//log(0) is undefined so return 1 if probability is 1
			return 1;
		}
		// Change of base formula --> logb(x) = loga(x) / loga(b)
		attempts = (int) Math.ceil(Math.log10(threshold) / Math.log10(1 - probability));
		return attempts;
	}
	
	//Computes the expected minimum cost of obtaining a specific loot drop.
	public double totalCost(int attempts, double moneyIn, int currencyOut, int pullCost) {
		double conversionRate = moneyIn / currencyOut;
		double totalCost = Math.ceil(conversionRate * attempts * pullCost);
		return totalCost;
	}

	@Override
	public String toString() {
		return "Calculator [probability=" + probability + ", pullCost=" + pullCost + ", moneyIn=" + moneyIn
				+ ", currencyOut=" + currencyOut + ", attempts=" + attempts + ", totalCost=" + totalCost + "]";
	}
	
	
	
	
}
