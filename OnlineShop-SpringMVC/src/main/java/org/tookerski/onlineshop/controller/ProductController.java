package org.tookerski.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tookerski.onlineshop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
}
