package org.tookerski.webstore.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.repository.ProductRepository;

@Repository
public class ImplProductRepository implements ProductRepository {
	private List<Product> productList = new ArrayList<Product>();
	
	public ImplProductRepository(){
		Product product1 = new Product(1,new BigDecimal(6400),"iphone7");
		product1.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product1.setSummary("new Apple Phone!");
		product1.setContent("BuyBuyBuy!");
		product1.setBuyPrice(new BigDecimal(6400));
		product1.setBuy(true);
		product1.setSell(false);
		
		Product product2 = new Product(2,new BigDecimal(1400),"Note 7");
		product2.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product2.setSummary("new Sansum Phone!");
		product2.setContent("BuyBuyBuy!");
		
		Product product3 = new Product(3,new BigDecimal(3240),"Mate 7");
		product3.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product3.setSummary("new Huawei Phone!");
		product3.setContent("BuyBuyBuy!");
		product3.setBuyPrice(new BigDecimal(3200));
		product3.setBuy(false);
		product3.setSell(true);
		
		Product product4 = new Product(4,new BigDecimal(2130),"Mi 7");
		product4.setImage("private List<Product> listOfProducts = new ArrayList<Product>();");
		product4.setSummary("new Xiaomi Phone!");
		product4.setContent("BuyBuyBuy!");
		product4.setBuyPrice(new BigDecimal(3200));
		product4.setBuy(true);
		product4.setSell(true);
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
