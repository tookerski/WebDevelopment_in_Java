package org.tookerski.webstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	/**
	 * Static list of users to simulate Database
	 */
	private static List<User> userList = new ArrayList<User>();

	//Initialize the list with some data for index screen
	static {
		userList.add(new User("Bill", "Gates"));
		userList.add(new User("Steve", "Jobs"));
		userList.add(new User("Larry", "Page"));
		userList.add(new User("Sergey", "Brin"));
		userList.add(new User("Larry", "Ellison"));
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Locale locale, Model model){
		Map<String, Object> root = new HashMap<>();
		List<Product> productList = productService.getAllProducts();
		root.put("productList", productList);
		return "index";
	}
	
	/**
	 * Saves the static list of users in model and renders it 
	 * via freemarker template.
	 * 
	 * @param model 
	 * @return The index view (FTL)
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("userList", userList);

		return "index";
	}

	/**
	 * Add a new user into static user lists and display the 
	 * same into FTL via redirect 
	 * 
	 * @param user
	 * @return Redirect to /index page to display user list
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") User user) {

		if (null != user && null != user.getFirstname()
				&& null != user.getLastname() && !user.getFirstname().isEmpty()
				&& !user.getLastname().isEmpty()) {

			synchronized (userList) {
				userList.add(user);
			}

		}

		return "redirect:/index";
	}
}
