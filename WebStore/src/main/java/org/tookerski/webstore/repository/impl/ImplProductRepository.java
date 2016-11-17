package org.tookerski.webstore.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.repository.ProductRepository;

public class ImplProductRepository implements ProductRepository {
	private List<Product> productList = new ArrayList<Product>();
	
	public ImplProductRepository(){
		Product product1 = new Product(1,new BigDecimal(6400),"iphone7");
		product1.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product1.setScript("new Apple Phone!");
		product1.setContent("BuyBuyBuy!");
		
		Product product2 = new Product(2,new BigDecimal(1400),"Note 7");
		product1.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product1.setScript("new Sansum Phone!");
		product1.setContent("BuyBuyBuy!");
		
		Product product3 = new Product(3,new BigDecimal(3240),"Mate 7");
		product1.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product1.setScript("new Huawei Phone!");
		product1.setContent("BuyBuyBuy!");
		
		Product product4 = new Product(4,new BigDecimal(2130),"Mi 7");
		product1.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product1.setScript("new Xiaomi Phone!");
		product1.setContent("BuyBuyBuy!");
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		Product productById = null;
		for (Product product:productList){
			if(product!=null&&product.getId()!=0&&product.getId()==id){
				productById = product;
				break;
			}
		}
		if (productById == null){
			throw new IllegalArgumentException("No products found with the product id: "+id);
		}
		return productById;
	}

	@Override
	public void addProduct(Product product) {
		productList.add(product);
	}

}
