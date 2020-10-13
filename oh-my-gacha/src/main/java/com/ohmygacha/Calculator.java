package com.ohmygacha;

public class Calculator {
	
	/**this function returns the number of attempts after which the probability 
	 * of an event occurring at least once approaches 100%.
	 * This is calculated using logarithms, a threshold is chosen after which we
	 * consider 0.9999 to be close enough to 1.
	**/
	int numberOfTrials(double probability) {
		int attempts;
		double threshold = 0.00001;
		if (probability == 1) {	//log(0) is undefined so return 1 if probability is 1
			return 1;
		}
		// Change of base formula --> logb(x) = loga(x) / loga(b)
		attempts = (int) Math.ceil(Math.log10(threshold) / Math.log10(1 - probability));
		return attempts;
	}
	
	
}
