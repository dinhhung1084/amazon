package edu.poly.controller.site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.domain.Customer;
import edu.poly.domain.Product;
import edu.poly.service.CustomerService;
import edu.poly.service.ProductService;

@Controller
@RequestMapping("site")
public class HomeController {

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	@GetMapping("home")
	public String home(Model model) {
		List<Customer> customer = customerService.findActivatedCustomer();
		List<Product> product = productService.findStock();
		model.addAttribute("customers", customer);
		model.addAttribute("products", product);
		return "site/home/index";
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
