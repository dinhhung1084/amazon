package edu.poly.controller.site;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
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

import edu.poly.constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.domain.Product;
import edu.poly.service.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("site/shop")
public class ShopController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    ProductService productService;

    @GetMapping
    public String index(Model model,
            @RequestParam("p") Optional<Integer> p, HttpSession session) {
        int currentPage = p.orElse(0);
        Page<Product> product = productService.findPaginatedActivated(currentPage, 8);
        Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
        model.addAttribute("customer", customer);
        model.addAttribute("products", product);
        return "site/home/shop";
    }

    @GetMapping("edit/{productId}")
    public ModelAndView viewProduct(ModelMap model, @PathVariable("productId") Integer productId, HttpSession session) {

        Optional<Product> opt = productService.findById(productId);
        if (opt.isPresent()) {
            Product entity = opt.get();
            model.addAttribute("product", entity);
            List<Product> product = productService.findStock();
            model.addAttribute("products", product);
            Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
            model.addAttribute("customer", customer);
            return new ModelAndView("site/home/product", model);
        }

        model.addAttribute("message", "something went wrong!");
        return new ModelAndView("redirect:/site/shop", model);
    }
}
