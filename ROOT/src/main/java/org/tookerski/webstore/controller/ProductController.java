package org.tookerski.webstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.model.Result;
import org.tookerski.webstore.model.User;
import org.tookerski.webstore.service.ProductService;
import org.tookerski.webstore.service.impl.ProductServiceDBImpl;


@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductServiceDBImpl productServiceDBImpl) {
		this.productService = productServiceDBImpl;
	}
	
	@RequestMapping("/")
	public String doIndex(ModelMap map, HttpSession session) throws IOException {

		map.addAttribute("user", session.getAttribute("user"));
		map.addAttribute("productList", productService.getProductList());
		return "index";
	}

	@RequestMapping("/show")
	public String doShow(@RequestParam(value = "id", required = false) Integer id, ModelMap map, HttpSession session)
			throws IOException {
		
		map.addAttribute("product", productService.getProduct(id));
		map.addAttribute("user", session.getAttribute("user"));
		return "show";

	}

	@RequestMapping("/api/buy")
	@ResponseBody

	public Result doApiBuy(@RequestParam(value = "id", required = false) Integer id, ModelMap map, HttpSession session)
			throws IOException {

		Product product = null;
		int rowAffected = 0;
		Result rs = new Result();
		rs.setCode(400);
		rs.setMessage("Page not found!");
		rs.setResult(false);
		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 0 && id != null) {
			product = productService.getProduct(id);
			if (!product.getIsBuy()) {
				rowAffected = productService.buyProduct(id, user.getId(), product.getPrice(),
						System.currentTimeMillis());
				if (rowAffected == 1) {
					rs.setCode(200);
					rs.setResult(true);
				}
			}
		}
		return rs;

	}

	@RequestMapping("/account")
	public String doAccount(ModelMap map, HttpSession session) throws IOException {

		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 0) {
			map.addAttribute("buyList", productService.getBuyListOrderByBuytime());
			map.addAttribute("user", session.getAttribute("user"));
			return "account";
		} else {
			session.removeAttribute("user");
			return "login";
		}
	}

	@RequestMapping("/api/delete")
	@ResponseBody
	public Result doApiDelete(@RequestParam(value = "id", required = false) Integer id, ModelMap map,
			HttpSession session) throws IOException {

		Product product = null;
		int rowAffected = 0;
		Result rs = new Result();
		rs.setCode(400);
		rs.setMessage("Pages not found!");
		rs.setResult(false);
		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1 && id != null) {
			product = productService.getProduct(id);
			if (!product.getIsSell()) {
				rowAffected = productService.deleteProduct(id);
				if (rowAffected == 1) {
					map.addAttribute("user", user);
					map.addAttribute("productList", productService.getProductList());
					rs.setCode(200);
					rs.setResult(true);
				}
			}
		}
		return rs;
	}

	@RequestMapping("/edit")
	public String doEdit(@RequestParam(value = "id", required = false) Integer id, ModelMap map, HttpSession session)
			throws IOException {

		System.out.println("/edit id=" + id);
		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1 && id != null) {
			map.addAttribute("user", user);
			map.addAttribute("product", productService.getProduct(id));
			return "edit";
		} else {
			session.removeAttribute("user");
			return "login";
		}
	}

	@RequestMapping("/public")
	public String doPublic(HttpSession session) throws IOException {

		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1) {
			return "public";
		} else {
			session.removeAttribute("user");
			return "login";
		}
	}

	@RequestMapping("/publicSubmit")
	public String doPublicSubmit(Product product, ModelMap map, HttpSession session) throws IOException {

		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1) {

			productService.publicProduct(product);
			if (product.getId() != 0) {
				map.addAttribute("product", product);
			} else {
				map.remove("product");
			}
			return "publicSubmit";
		} else {
			session.removeAttribute("user");
			return "login";
		}
	}

	@RequestMapping("/editSubmit")
	public String doEditSubmitContent(Product product, ModelMap map, HttpSession session) throws IOException {


		User user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1) {

			int record = productService.editProduct(product);
			if (record != 0) {
				map.addAttribute("product", product);
			} else {
				map.remove("product");
			}
			return "editSubmit";
		} else {
			session.removeAttribute("user");
			return "login";
		}

	}
}
