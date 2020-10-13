package com.ohmygacha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OhMyGachaApplicationTests {

	@Test
	void numberOfTrialsTest() {
		var calc = new Calculator();
		assertEquals(225, calc.numberOfTrials(0.05), "For 0.05 probability of a,"
				+ "p of a occuring at least once approaches 1 at 225 trials");
		assertEquals(83, calc.numberOfTrials(0.13), "For 0.13 probability of a,"
				+ "p of a occuring at least once approaches 1 at 83 trials");
		assertEquals(1, calc.numberOfTrials(1.0), "For 1.0 probability of a,"
				+ "p of a occuring at least once approaches 1 after 1 trial.");
		
	}

}
