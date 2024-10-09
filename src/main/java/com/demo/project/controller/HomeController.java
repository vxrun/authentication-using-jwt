package com.demo.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/homepage")
	public String homePage() {
		return "Hello worlds";
	}
	
	@GetMapping("/homepageCheck")
	public String homePagecheck() {
		return "Hello worlds faagagaa";
	}

}
