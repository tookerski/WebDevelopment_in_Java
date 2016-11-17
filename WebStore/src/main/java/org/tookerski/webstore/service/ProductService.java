package org.tookerski.webstore.service;

import java.util.List;

import org.tookerski.webstore.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductById(int id);
	void addProduct(Product product);
}
