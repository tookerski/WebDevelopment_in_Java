package org.tookerski.onlineshop.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.tookerski.onlineshop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(String productId);
	List<Product> getProductsByCategory(String category);
	//method for filter products by using matrix variables
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
