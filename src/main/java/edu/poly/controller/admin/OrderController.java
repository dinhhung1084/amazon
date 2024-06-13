package edu.poly.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.domain.Order;
import edu.poly.service.OrderService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<Order> page = orderService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("orders", page);
		model.addAttribute("order", new Order());
		return "admin/orders";
	}

	@GetMapping("edit/{orderId}")
	public ModelAndView edit(ModelMap model, @PathVariable("orderId") Integer orderId,
			@RequestParam("p") Optional<Integer> p) {
		Optional<Order> opt = orderService.findById(orderId);
		if (opt.isPresent()) {
			Order entity = opt.get();
			model.addAttribute("order", entity);
			int currentPage = p.orElse(0);
			Page<Order> page = orderService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("orders", page);
			return new ModelAndView("admin/orders", model);
		}
		model.addAttribute("message", "Order is not existed");
		return new ModelAndView("forward:admin/orders", model);
	}

	@GetMapping("delete/{orderId}")
	public ModelAndView delete(ModelMap model, @PathVariable("orderId") Integer orderId,
			@RequestParam("p") Optional<Integer> p) {
		orderService.deactivateOrder(orderId);
		int currentPage = p.orElse(0);
		Page<Order> page = orderService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("orders", page);
		model.addAttribute("order", new Order());
		model.addAttribute("message", "Order is deleted");
		return new ModelAndView("admin/orders", model); // return to file
	}

	@RequestMapping(value = "update")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("order") Order entity,
			BindingResult result, @RequestParam("p") Optional<Integer> p, @RequestParam("action") String action) {
		if (result.hasErrors()) {
			int currentPage = p.orElse(0);
			Page<Order> page = orderService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("orders", page);
			model.addAttribute("error", "There was an error processing your request.");
			return new ModelAndView("/admin/orders", model);
		}
		if (action.equals("saveOrUpdate")) {
			entity.setStatus((short) 2);
		} else if (action.equals("cancel")) {
			entity.setStatus((short) 0);

		}
		entity.setActivated(true);
		orderService.save(entity);
		return new ModelAndView("redirect:/admin/orders/page", model);
	}

}
