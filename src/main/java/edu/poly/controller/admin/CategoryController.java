package edu.poly.controller.admin;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import constant.SessionAttr;
import edu.poly.domain.Category;
import edu.poly.domain.Customer;
import edu.poly.model.CategoryDto;
import edu.poly.service.CategoryService;
import edu.poly.service.SessionService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SessionService sessionService;

	@Autowired
	HttpSession session;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
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
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("category", dto);
			int currentPage = p.orElse(0);
			Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("categories", page);
			return new ModelAndView("admin/categories", model);
		}

		model.addAttribute("message", "Category is not existed");
		return new ModelAndView("forward:admin/categories", model);
	}

	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model, @PathVariable("categoryId") Integer categoryId,
			@RequestParam("p") Optional<Integer> p) {
		categoryService.deactivateCategory(categoryId);
		int currentPage = p.orElse(0);
		Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
		model.addAttribute("categories", page);
		model.addAttribute("category", new Category());
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		model.addAttribute("message", "Category is deleted");
		return new ModelAndView("admin/categories", model); // return to file
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryDto dto,
			BindingResult result, @RequestParam("p") Optional<Integer> p) {
		if (result.hasErrors()) {
			int currentPage = p.orElse(0);
			Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("categories", page);
			return new ModelAndView("/admin/categories", model);
		}
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity);
		entity.setActivated(true);
		categoryService.save(entity);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		return new ModelAndView("redirect:/admin/categories/page", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords", ""));
		sessionService.set("String", kwords);
		if (StringUtils.hasText(kwords)) {
			Pageable pageable = PageRequest.of(p.orElse(0), 5);
			Page<Category> page = categoryService.searchActiveProducts(kwords, pageable);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("categories", page);
			model.addAttribute("category", new Category());
			model.addAttribute("keywords", kwords);
		} else {
			int currentPage = p.orElse(0);
			Page<Category> page = categoryService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("categories", page);
			model.addAttribute("keywords", kwords);
			model.addAttribute("category", new Category());
		}

		return "/admin/categories";
	}

}
