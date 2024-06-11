package edu.poly.controller.admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.domain.Category;
import edu.poly.model.CategoryDto;
import edu.poly.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public String index(Model model1, Model model2) {
		List<Category> list = categoryService.findAll();
		model1.addAttribute("categories", list);
		model2.addAttribute("category", new Category());
		return "admin/categories";
	}

	@GetMapping("edit/{categoryId}")
	public String edit() {
		return "admin/categories";
	}

	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect:/admin/categories";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, CategoryDto dto) {
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity);
		return new ModelAndView("redirect:/admin/categories", model);
	}

	@GetMapping("search")
	public String search() {
		return "admin/categories";
	}

}
