package edu.poly.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController {

	@GetMapping("login")
	public String login() {
		return "site/account/login-cover";
	}
	
	@GetMapping("register")
	public String register() {
		return "site/account/register";
	}
}
