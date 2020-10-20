package com.ohmygacha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ohmygacha.domain.Calculator;

@SpringBootTest
class OhMyGachaApplicationTests {

	@Test
	void numberOfTrialsTest() {
		var calc = new Calculator();
		assertEquals(180, calc.numberOfTrials(new BigDecimal("0.05")),
				"For 0.05 probability of a," + "p of a occuring at least once approaches 1 at 180 trials");
		assertEquals(67, calc.numberOfTrials(new BigDecimal("0.13")),
				"For 0.13 probability of a," + "p of a occuring at least once approaches 1 at 67 trials");
		assertEquals(1, calc.numberOfTrials(new BigDecimal("1.0")),
				"For 1.0 probability of a," + "p of a occuring at least once approaches 1 after 1 trial.");

	}

	@Test
	void totalCostTest() {
		var calc = new Calculator();
		assertEquals(BigInteger.valueOf(1000), calc.totalCost(200, new BigDecimal("99.99"), BigInteger.valueOf(2000), BigInteger.valueOf(100)), "200 attempts should cost £1000.00");
		assertEquals(BigInteger.valueOf(750), calc.totalCost(500, new BigDecimal("38.99"), BigInteger.valueOf(13000), BigInteger.valueOf(500)), "500 attempts should cost £750.00");
		assertEquals(BigInteger.valueOf(23), calc.totalCost(20, new BigDecimal("8.99"), BigInteger.valueOf(2000), BigInteger.valueOf(250)), "20 attempts should cost £23.00");
		
	}

}
