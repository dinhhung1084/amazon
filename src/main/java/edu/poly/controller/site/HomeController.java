package edu.poly.controller.site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.domain.Product;
import edu.poly.service.CustomerService;
import edu.poly.service.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("site")
public class HomeController {

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	@GetMapping("home")
	public String home(Model model, HttpSession session) {
		List<Customer> customers = customerService.findActivatedCustomer();
		List<Product> product = productService.findStock();
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		model.addAttribute("customers", customers);
		model.addAttribute("products", product);
		return "site/home/index";
	}

	@GetMapping("about")
	public String about(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return "site/home/about";
	}

	@GetMapping("services")
	public String services(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return "site/home/services";
	}

	@GetMapping("blog")
	public String blog(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return "site/home/blog";
	}

	@GetMapping("contact")
	public String contact(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return "site/home/contact";
	}

}
