package edu.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {

    @GetMapping("dashboard")
    public String index() {
        return "admin/index";
    }

    @GetMapping("")
    public String table() {
        return "/templates/admin/NewFile";
    }

}
