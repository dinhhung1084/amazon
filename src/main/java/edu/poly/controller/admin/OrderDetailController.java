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

import edu.poly.domain.OrderDetail;
import edu.poly.service.OrderDetailService;

@Controller
@RequestMapping("admin/orderDetails")
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<OrderDetail> page = orderDetailService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("orderDetails", page);
		return "admin/orderDetails";
	}

	// @GetMapping("edit/{orderDetailId}")
	// public ModelAndView edit(ModelMap model, @PathVariable("orderDetailId")
	// Integer orderDetailId,
	// @RequestParam("p") Optional<Integer> p) {
	// Optional<OrderDetail> opt = orderDetailService.findById(orderDetailId);
	// if (opt.isPresent()) {
	// OrderDetail entity = opt.get();
	// model.addAttribute("orderDetails", entity);
	// int currentPage = p.orElse(0);
	// Page<OrderDetail> page =
	// orderDetailService.findPaginatedActivated(currentPage, 5);
	// model.addAttribute("orderDetails", page);
	// return new ModelAndView("admin/orderDetails", model);
	// }
	// model.addAttribute("message", "Order Detail is not existed");
	// return new ModelAndView("forward:admin/orderDetails", model);
	// }

	@GetMapping("delete/{orderDetailId}")
	public ModelAndView delete(ModelMap model, @PathVariable("orderDetailId") Integer orderDetailId,
			@RequestParam("p") Optional<Integer> p) {
		orderDetailService.deactivateOrder(orderDetailId);
		int currentPage = p.orElse(0);
		Page<OrderDetail> page = orderDetailService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("orderDetails", page);
		model.addAttribute("message", "Order Detail is deleted");
		return new ModelAndView("admin/orderDetails", model); // return to file
	}

	// @RequestMapping(value = "update")
	// public ModelAndView saveOrUpdate(ModelMap model, @Valid
	// @ModelAttribute("orderDetail") OrderDetail entity,
	// BindingResult result, @RequestParam("p") Optional<Integer> p,
	// @RequestParam("action") String action) {
	// if (result.hasErrors()) {
	// int currentPage = p.orElse(0);
	// Page<OrderDetail> page =
	// orderDetailService.findPaginatedActivated(currentPage, 5);
	// model.addAttribute("orderDetails", page);
	// model.addAttribute("error", "There was an error processing your request.");
	// return new ModelAndView("/admin/orderDetails", model);
	// }
	// if (action.equals("saveOrUpdate")) {
	// entity.set((short) 2);
	// } else if (action.equals("cancel")) {
	// entity.setStatus((short) 0);

	// }
	// entity.setActivated(true);
	// orderService.save(entity);
	// return new ModelAndView("redirect:/admin/orders/page", model);
	// }

}
