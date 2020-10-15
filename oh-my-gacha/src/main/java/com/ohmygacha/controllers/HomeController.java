package com.ohmygacha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ohmygacha.domain.Calculator;

@Controller
public class HomeController {

	@GetMapping("/")
	public String rootView(ModelMap model) {
		model.put("calculator", new Calculator());
		System.out.println(model.get("calculator").toString());
		return "index";
	}

	@PostMapping("/")
	public String calculatePost(@ModelAttribute Calculator calculator) {
		// Set the attempts and total cost by calling the calculation methods
		calculator.setAttempts(calculator.numberOfTrials(calculator.getProbability()));
		calculator.setTotalCost(calculator.totalCost(calculator.getAttempts(), calculator.getMoneyIn(),
				calculator.getCurrencyOut(), calculator.getPullCost()));
		return "index";
	}
	

}
