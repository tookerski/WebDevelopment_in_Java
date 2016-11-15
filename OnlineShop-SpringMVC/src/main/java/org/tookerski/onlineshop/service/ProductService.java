package org.tookerski.onlineshop.service;

import java.util.List;

import org.tookerski.onlineshop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(String productId);
}
