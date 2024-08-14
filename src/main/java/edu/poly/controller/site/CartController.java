package edu.poly.controller.site;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.constant.SessionAttr;
import edu.poly.domain.CartItem;
import edu.poly.domain.Customer;
import edu.poly.domain.Order;
import edu.poly.domain.OrderDetail;
import edu.poly.domain.Product;
import edu.poly.service.CartItemService;
import edu.poly.service.OrderDetailService;
import edu.poly.service.OrderService;
import edu.poly.service.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("site/cart")
public class CartController {

	@Autowired
	ProductService productService;

	@Autowired
	CartItemService cartItemService;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	OrderService orderService;

	@GetMapping
	public String cart(ModelMap model, HttpSession session) {
		try {
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			if (customer != null) {
				List<CartItem> cartList = cartItemService.listCartItem(customer.getCustomerId());
				model.addAttribute("carts", cartList);
				double totalAmount = 0.0;
				for (CartItem cartItem : cartList) {
					double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
					totalAmount += itemTotal;
				}
				model.addAttribute("totalPrice", totalAmount);
				model.addAttribute("customer", customer);
				return "site/home/cart";
			}
			return "site/home/shop";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("add/{productId}")
	public ModelAndView add(ModelMap model, @PathVariable("productId") Integer productId, HttpSession session) {
		Optional<Product> opt = productService.findById(productId);
		if (opt.isPresent()) {
			Product entity = opt.get();
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			if (customer != null) {
				CartItem cartUpdate = cartItemService.findByProductId(customer.getCustomerId(), productId);
				if (cartUpdate != null) {
					cartUpdate.setQuantity(cartUpdate.getQuantity() + 1);
				} else {
					cartUpdate = new CartItem();
					cartUpdate.setCustomer(customer);
					cartUpdate.setProduct(entity);
					cartUpdate.setPrice(entity.getPrice());
					cartUpdate.setQuantity(1);
				}
				cartItemService.save(cartUpdate);
				List<CartItem> cartList = cartItemService.listCartItem(customer.getCustomerId());
				double totalAmount = 0.0;
				for (CartItem cartItem : cartList) {
					double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
					totalAmount += itemTotal;
				}
				model.addAttribute("totalPrice", totalAmount);
				model.addAttribute("carts", cartList);
				model.addAttribute("customer", customer);
				return new ModelAndView("redirect:/site/cart", model);
			}
		}
		return new ModelAndView("redirect:/site/home", model);
	}

	@GetMapping("remove/{productId}")
	public ModelAndView remove(ModelMap model, @PathVariable("productId") Integer productId, HttpSession session) {
		Optional<Product> opt = productService.findById(productId);
		if (opt.isPresent()) {
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			if (customer != null) {
				CartItem cartDelete = cartItemService.findByProductId(customer.getCustomerId(), productId);
				cartItemService.deleteById(cartDelete.getId());
				List<CartItem> cartList = cartItemService.listCartItem(customer.getCustomerId());
				double totalAmount = 0.0;
				for (CartItem cartItem : cartList) {
					double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
					totalAmount += itemTotal;
				}
				model.addAttribute("totalPrice", totalAmount);
				model.addAttribute("carts", cartList);
				model.addAttribute("customer", customer);
				return new ModelAndView("/site/home/cart", model);
			}
		}
		return new ModelAndView("site/home/shop", model);
	}

	@GetMapping("checkout")
	public String checkout(ModelMap model, HttpSession session) {
		try {
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			if (customer != null) {
				List<CartItem> cartList = cartItemService.listCartItem(customer.getCustomerId());
				double totalAmount = 0.0;
				for (CartItem cartItem : cartList) {
					double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
					totalAmount += itemTotal;
				}
				model.addAttribute("totalPrice", totalAmount);
				model.addAttribute("carts", cartList);
				model.addAttribute("customer", customer);
				return "site/home/checkout";
			}
			return "site/home/cart";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("placeOrder")
	public ModelAndView placeOrder(ModelMap model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		if (customer != null) {
			List<CartItem> cartList = cartItemService.listCartItem(customer.getCustomerId());
			Order order = new Order();
			double totalAmount = 0.0;
			for (CartItem cartItem : cartList) {
				double itemTotal = cartItem.getPrice() * cartItem.getQuantity();
				totalAmount += itemTotal;
			}
			order.setOrderDate(new Date());
			order.setStatus((short) 1);
			order.setAmount(totalAmount);
			order.setCustomer(customer);
			order.setActivated(true);
			orderService.save(order);
			for (CartItem cart : cartList) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(order);
				orderDetail.setPrice(cart.getProduct().getPrice());//
				orderDetail.setProduct(cart.getProduct());//
				orderDetail.setQuantity(cart.getQuantity());//
				orderDetail.setActivated(true);
				orderDetailService.save(orderDetail);
			}
			cartItemService.deleteCartItemsByCustomerId(customer.getCustomerId());
			return new ModelAndView("redirect:/site/home");
		}
		return new ModelAndView("site/home/checkout", model);
	}
}
