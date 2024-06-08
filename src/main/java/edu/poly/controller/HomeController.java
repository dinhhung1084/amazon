package edu.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	@GetMapping("")
	public String home() {
		return "site/home/index";
	}
	
	@GetMapping("site/shop")
	public String shop() {
		return "site/home/shop";
	}
	
}
