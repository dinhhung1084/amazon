package edu.poly.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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

import edu.poly.constant.SessionAttr;
import edu.poly.domain.Customer;
import edu.poly.domain.Product;
import edu.poly.model.ProductDto;
import edu.poly.service.ProductService;
import edu.poly.service.SessionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	SessionService sessionService;

	@Autowired
	HttpSession session;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("page")
	public String index(Model model,
			@RequestParam("p") Optional<Integer> p) {
		int currentPage = p.orElse(0);
		Page<Product> page = productService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		model.addAttribute("products", page);
		model.addAttribute("product", new Product());
		return "admin/products";
	}

	@GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap model, @PathVariable("productId") Integer productId,
			@RequestParam("p") Optional<Integer> p) {
		Optional<Product> opt = productService.findById(productId);
		if (opt.isPresent()) {
			Product entity = opt.get();
			model.addAttribute("product", entity);
			int currentPage = p.orElse(0);
			Page<Product> page = productService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("products", page);
			return new ModelAndView("admin/products", model);
		}
		model.addAttribute("message", "Product is not existed");
		return new ModelAndView("forward:admin/products", model);
	}

	@GetMapping("delete/{productId}")
	public ModelAndView delete(ModelMap model, @PathVariable("productId") Integer productId,
			@RequestParam("p") Optional<Integer> p) {
		productService.setStockToFalse(productId);
		int currentPage = p.orElse(0);
		Page<Product> page = productService.findPaginatedActivated(currentPage, 5);
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		model.addAttribute("products", page);
		model.addAttribute("product", new Product());
		model.addAttribute("message", "Product is deleted");
		return new ModelAndView("admin/products", model); // return to file
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("product") Product product,
			BindingResult result, @RequestParam("p") Optional<Integer> p, ProductDto dto) {

		if (result.hasErrors()) {
			int currentPage = p.orElse(0);
			Page<Product> page = productService.findPaginatedActivated(currentPage, 5);
			model.addAttribute("products", page);
			return new ModelAndView("/admin/products", model);
		}

		MultipartFile imageFile = dto.getImgFile();
		if (imageFile != null && !imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			product.setImage(imageName);

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

		product.setStock(true);
		product.setCreateDate(new Date());
		Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
		model.addAttribute("customer", customer);
		productService.save(product);
		return new ModelAndView("redirect:/admin/products/page", model);

	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionService.get("keywords", ""));
		sessionService.set("String", kwords);
		if (StringUtils.hasText(kwords)) {
			Pageable pageable = PageRequest.of(p.orElse(0), 5);
			Page<Product> page = productService.searchActiveProducts(kwords, pageable);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("products", page);
			model.addAttribute("keywords", kwords);
			model.addAttribute("product", new Product());
		} else {
			int currentPage = p.orElse(0);
			Page<Product> page = productService.findPaginatedActivated(currentPage, 5);
			Customer customer = (Customer) session.getAttribute(SessionAttr.CURRENT_USER);
			model.addAttribute("customer", customer);
			model.addAttribute("products", page);
			model.addAttribute("keywords", kwords);
			model.addAttribute("product", new Product());
		}

		return "/admin/products";
	}

}
