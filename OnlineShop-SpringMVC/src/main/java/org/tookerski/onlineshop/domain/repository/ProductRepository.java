package org.tookerski.onlineshop.domain.repository;

import java.util.List;

import org.tookerski.onlineshop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
}
