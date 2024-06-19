package edu.poly.controller.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.model.CustomerDto;
import edu.poly.service.CustomerService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	CustomerService customerService;

	@Autowired
	private ServletContext servletContext;

	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("account", new Customer());
		return "site/account/login-cover";
	}

	@PostMapping("login/check")
	public ModelAndView checkLogin(ModelMap model, @ModelAttribute("account") Customer entity, HttpSession session) {
		Customer account = customerService.login(entity.getUsername(), entity.getPassword());
		if (account != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, account);
			return new ModelAndView("redirect:/site/home", model);
		} else {
			model.addAttribute("message", "Username or Password is not correct!");
			return new ModelAndView("account/login", model);
		}
	}

	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("account", new CustomerDto());
		return "site/account/register";
	}

	@PostMapping("register/check")
	public ModelAndView registration(ModelMap model, @Valid @ModelAttribute("account") CustomerDto customerDto,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("account", new Customer());
			return new ModelAndView("/account/register", model);
		}

		if (!customerDto.getPassword().equals(customerDto.getConfirmPassword())) {
			model.addAttribute("message", "Passwords do not match!");
			return new ModelAndView("/account/register", model);
		}

		Customer customer = new Customer();

		customer.setUsername(customerDto.getUsername());
		customer.setPassword(customerDto.getPassword());
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setPhoto(customerDto.getPhoto());
		customer.setActivated(true);
		customer.setAdmin(false);

		customerService.save(customer);
		return new ModelAndView("redirect:/account/login");
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/account/login";
	}

}
