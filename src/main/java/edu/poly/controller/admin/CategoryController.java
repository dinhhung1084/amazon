package edu.poly.controller.admin;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.domain.Category;
import edu.poly.model.CategoryDto;
import edu.poly.service.CategoryService;
import edu.poly.service.SessionService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SessionService sessionService;

	@RequestMapping("page")
	public String index(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords", ""));
		sessionService.set("String", kwords);

		int currentPage = p.orElse(0);
		Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("categories", page);

		model.addAttribute("category", new Category());
		return "admin/categories";
	}

	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Integer categoryId,
			@RequestParam("p") Optional<Integer> p) {
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryDto dto = new CategoryDto();
		if (opt.isPresent()) {
			// List<Category> list = categoryService.findIsActivated();
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("category", dto);

			int currentPage = p.orElse(0);
			Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("categories", page);

			// model.addAttribute("categories", list);
			return new ModelAndView("admin/categories", model);
		}
		model.addAttribute("message", "Category is not existed");
		return new ModelAndView("forward:admin/categories", model);
	}

	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect:/admin/categories";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryDto dto,
			BindingResult result, @RequestParam("p") Optional<Integer> p) {
		if (result.hasErrors()) {
			int currentPage = p.orElse(0);
			Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("categories", page);
			// List<Category> list = categoryService.findIsActivated();
			// model.addAttribute("categories", list);
			return new ModelAndView("/admin/categories", model);
		}

		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity);
		entity.setActivated(true);
		categoryService.save(entity);
		return new ModelAndView("redirect:/admin/categories", model);
	}

	@GetMapping("search")
	public String search() {
		return "admin/categories";
	}

}
