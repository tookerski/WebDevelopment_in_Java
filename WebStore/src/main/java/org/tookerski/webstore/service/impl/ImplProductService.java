package org.tookerski.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.repository.ProductRepository;
import org.tookerski.webstore.service.ProductService;

@Service
public class ImplProductService implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.getProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}
