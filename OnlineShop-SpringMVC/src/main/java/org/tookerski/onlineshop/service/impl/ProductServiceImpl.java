package org.tookerski.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tookerski.onlineshop.domain.Product;
import org.tookerski.onlineshop.domain.repository.ProductRepository;
import org.tookerski.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

}
