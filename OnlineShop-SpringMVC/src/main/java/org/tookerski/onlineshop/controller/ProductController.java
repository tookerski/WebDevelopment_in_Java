package org.tookerski.onlineshop.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tookerski.onlineshop.domain.Product;

@Controller
public class ProductController {
	
	@RequestMapping("/products")
	public String list(Model model){
		Product iphone = new Product("P1234","iPhone 6s",new BigDecimal(6400));
		iphone.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		model.addAttribute("product", iphone);
		return "products";
	}
}
