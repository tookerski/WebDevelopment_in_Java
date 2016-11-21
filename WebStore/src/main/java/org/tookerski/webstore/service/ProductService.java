package org.tookerski.webstore.service;

import java.util.List;

import org.tookerski.webstore.model.Product;

public interface ProductService {

	public List<Product> getProductList();

	public Product getProduct(int id);

	public int buyProduct(int id, int personId, double price, long buyTime);

	public int deleteProduct(int id);

	public int publicProduct(Product product);

	public int editProduct(Product product);

	public List<Product>  getBuyListOrderByBuytime();
	
}
