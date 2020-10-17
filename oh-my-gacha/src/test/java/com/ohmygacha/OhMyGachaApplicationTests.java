package com.ohmygacha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ohmygacha.domain.Calculator;

@SpringBootTest
class OhMyGachaApplicationTests {

	@Test
	void numberOfTrialsTest() {
		var calc = new Calculator();
		assertEquals(225, calc.numberOfTrials(new BigDecimal("0.05")),
				"For 0.05 probability of a," + "p of a occuring at least once approaches 1 at 225 trials");
		assertEquals(83, calc.numberOfTrials(new BigDecimal("0.13")),
				"For 0.13 probability of a," + "p of a occuring at least once approaches 1 at 83 trials");
		assertEquals(1, calc.numberOfTrials(new BigDecimal("1.0")),
				"For 1.0 probability of a," + "p of a occuring at least once approaches 1 after 1 trial.");

	}

	@Test
	void totalCostTest() {
		var calc = new Calculator();
		assertEquals(1000.0, calc.totalCost(200, new BigDecimal("99.99"), 2000, 100), "200 attempts should cost £1000.00");
		assertEquals(750.0, calc.totalCost(500, new BigDecimal("38.99"), 13000, 500), "500 attempts should cost £750.00");
		assertEquals(23.0, calc.totalCost(20, new BigDecimal("8.99"), 2000, 250), "20 attempts should cost £23.00");
		
	}

}
