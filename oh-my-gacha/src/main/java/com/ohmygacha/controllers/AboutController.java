package com.ohmygacha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class AboutController {

	@GetMapping("/about")
	public String aboutView() {
		return "about";
	}
}
