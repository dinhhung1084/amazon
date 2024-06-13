package edu.poly.controller.site;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.domain.Product;
import edu.poly.service.ProductService;

@Controller
@RequestMapping("site")
public class ShopController {

    @Autowired
    ProductService productService;

    @RequestMapping("shop")
    public String index(Model model,
            @RequestParam("p") Optional<Integer> p) {
        int currentPage = p.orElse(0);
        Page<Product> product = productService.findPaginatedActivated(currentPage, 8);
        model.addAttribute("products", product);
        return "site/home/shop";
    }
}
