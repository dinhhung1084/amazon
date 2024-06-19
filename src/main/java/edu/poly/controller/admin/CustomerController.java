package edu.poly.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.model.CustomerDto;
import edu.poly.service.CustomerService;
import edu.poly.service.SessionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	SessionService sessionService;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	HttpSession session;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<Customer> page = customerService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("custom", customer);
		model.addAttribute("customers", page);
		model.addAttribute("customer", new Customer());
		return "admin/customers";
	}

	@GetMapping("edit/{customerId}")
	public ModelAndView edit(ModelMap model, @PathVariable("customerId") Integer customerId,
			@RequestParam("p") Optional<Integer> p) {
		Optional<Customer> opt = customerService.findById(customerId);
		if (opt.isPresent()) {
			Customer entity = opt.get();
			model.addAttribute("customer", entity);
			int currentPage = p.orElse(0);
			Page<Customer> page = customerService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("custom", customer);
			model.addAttribute("customers", page);
			return new ModelAndView("admin/customers", model);
		}
		model.addAttribute("message", "Customer is not existed");
		return new ModelAndView("forward:admin/customers", model);
	}

	@GetMapping("delete/{customerId}")
	public ModelAndView delete(ModelMap model, @PathVariable("customerId") Integer customerId,
			@RequestParam("p") Optional<Integer> p) {
		customerService.deactivateCustomer(customerId);
		int currentPage = p.orElse(0);
		Page<Customer> page = customerService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("custom", customer);
		model.addAttribute("customers", page);
		model.addAttribute("customer", new Customer());
		model.addAttribute("message", "Customer is deleted");
		return new ModelAndView("admin/customers", model); // return to file
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") Customer customer,
			BindingResult result, @RequestParam("p") Optional<Integer> p, CustomerDto dto) {
		if (result.hasErrors()) {
			int currentPage = p.orElse(0);
			Page<Customer> page = customerService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("customers", page);
			return new ModelAndView("/admin/customers", model);
		}

		MultipartFile imageFile = dto.getImgFile();
		if (imageFile != null && !imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			customer.setPhoto(imageName);

			try {
				String uploadDir = servletContext.getRealPath("/images");
				File uploadDirFile = new File(uploadDir);
				if (!uploadDirFile.exists()) {
					uploadDirFile.mkdirs();
				}
				Path filePath = Paths.get(uploadDir, imageName);
				Files.write(filePath, imageFile.getBytes());
				System.out.println("Đường dẫn tệp ảnh: " + filePath.toString());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		customer.setActivated(true);
		Customer custom = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("custom", custom);
		customerService.save(customer);
		return new ModelAndView("redirect:/admin/customers/page", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords", ""));
		sessionService.set("String", kwords);
		if (StringUtils.hasText(kwords)) {
			Pageable pageable = PageRequest.of(p.orElse(0), 5);
			Page<Customer> page = customerService.searchActiveCustomers(kwords, pageable);
			Customer custom = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("custom", custom);
			model.addAttribute("customers", page);
			model.addAttribute("keywords", kwords);
			model.addAttribute("customer", new Customer());
		} else {
			int currentPage = p.orElse(0);
			Page<Customer> page = customerService.findPaginatedActivated(currentPage, 5);
			Customer custom = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("custom", custom);
			model.addAttribute("customers", page);
			model.addAttribute("keywords", kwords);
			model.addAttribute("customer", new Customer());
		}

		return "/admin/customers";
	}

}
