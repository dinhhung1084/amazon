package edu.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.constant.SessionAttr;
import edu.poly.domain.Customer;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("dashboard")
    public String index(ModelMap model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
        model.addAttribute("customer", customer);
        return "admin/index";
    }

}
