package org.tookerski.webstore.repository;

import java.util.List;

import org.tookerski.webstore.model.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(int id);
	void addProduct(Product product);
}
