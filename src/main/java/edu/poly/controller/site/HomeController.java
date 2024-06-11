package edu.poly.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("site")
public class HomeController {

	@GetMapping("home")
	public String home() {
		return "site/home/index";
	}

	@GetMapping("shop")
	public String shop() {
		return "site/home/shop";
	}

	@GetMapping("about")
	public String about() {
		return "site/home/about";
	}

	@GetMapping("cart")
	public String cart() {
		return "site/home/cart";
	}

	@GetMapping("services")
	public String services() {
		return "site/home/services";
	}

	@GetMapping("checkout")
	public String checkout() {
		return "site/home/checkout";
	}

	@GetMapping("blog")
	public String blog() {
		return "site/home/blog";
	}

	@GetMapping("contact")
	public String contact() {
		return "site/home/contact";
	}

	@GetMapping("thankyou")
	public String thankyou() {
		return "site/home/thankyou";
	}
}
