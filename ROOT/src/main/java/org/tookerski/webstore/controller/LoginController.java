package org.tookerski.webstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tookerski.webstore.model.Result;
import org.tookerski.webstore.model.User;
import org.tookerski.webstore.service.LoginService;
import org.tookerski.webstore.service.ProductService;
import org.tookerski.webstore.service.impl.LoginServiceDBImpl;
import org.tookerski.webstore.service.impl.ProductServiceDBImpl;


@Controller
public class LoginController {

	private ProductService productService;

	private LoginService loginService;
	
	@Autowired
	public void setUserService(LoginServiceDBImpl loginServiceDBImpl) {
		this.loginService = loginServiceDBImpl;
	}

	@Autowired
	public void setProductService(ProductServiceDBImpl productServiceDBImpl) {
		this.productService = productServiceDBImpl;
	}
	
	@RequestMapping("/login")
	public String doLogin(HttpSession session) {
		System.out.println("login");
		session.removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("/api/login")
	@ResponseBody
	public Result doApiLogin(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password, HttpSession session, ModelMap map)
					throws IOException {

		User user = null;
		Result rs = new Result();
		
		//Check if no login history or direct to login page
		if (userName != null && password != null) {
			user = loginService.getUser(userName, password);
		} else {
			user = (User) session.getAttribute("user");
		}

		if (user != null) {
			session.setAttribute("user", user);
			map.addAttribute("productList", productService.getProductList());
			map.addAttribute("user", user);
			rs.setCode(200);
			rs.setResult(true);
		} else {
			session.removeAttribute("user");
			rs.setCode(400);
			rs.setMessage("User invalid!");
			rs.setResult(false);
		}
		return rs;

	}
	
	@RequestMapping("/error")
	public String doError(ModelMap map, HttpServletResponse res) {
		String errorMsg = null;
		if (res.getStatus() == 404)
			errorMsg = "Not Found!Please check your input!";
		else {
			errorMsg = "error!Please check your network!";
		}
		map.addAttribute("errorMsg", errorMsg);
		return "error";
	}
	
}
