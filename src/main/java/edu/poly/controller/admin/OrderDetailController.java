package edu.poly.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.domain.OrderDetail;
import edu.poly.service.OrderDetailService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/orderDetails")
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	HttpSession session;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<OrderDetail> page = orderDetailService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("orderDetails", page);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return "admin/orderDetails";
	}

	@GetMapping("delete/{orderDetailId}")
	public ModelAndView delete(ModelMap model, @PathVariable("orderDetailId") Integer orderDetailId,
			@RequestParam("p") Optional<Integer> p) {
		orderDetailService.deactivateOrderDetail(orderDetailId);
		int currentPage = p.orElse(0);
		Page<OrderDetail> page = orderDetailService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		model.addAttribute("orderDetails", page);
		model.addAttribute("message", "Order Detail is deleted");
		return new ModelAndView("admin/orderDetails", model); // return to file
	}

}
