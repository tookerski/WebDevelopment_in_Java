package org.tookerski.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tookerski.webstore.dao.ProductDao;
import org.tookerski.webstore.model.Product;
import org.tookerski.webstore.service.ProductService;

@Service
public class ProductServiceDBImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public List<Product> getProductList() {
		List<Product> productList = null;
		productList = productDao.getProductList();
		return productList;
	}

	@Override
	public Product getProduct(int id) {
		Product product = productDao.getProduct(id);
		return product;
	}

	@Override
	public int buyProduct(int id, int personId, double price, long buyTime) {
		return productDao.insertTrx(id, personId, price, buyTime);
	}

	@Override
	public int deleteProduct(int id) {
		int recordCount = 0;
		recordCount = productDao.deleteProduct(id);
		return recordCount;
	}

	@Override
	public int publicProduct(Product product) {
		int record = 0;
		record = productDao.insertProduct(product);
		return record;
	}

	@Override
	public int editProduct(Product product) {
		int record = 0;
		record = productDao.updateProduct(product);
		return record;
	}

	@Override
	public List<Product> getBuyListOrderByBuytime() {
		return productDao.getBuyListOrderByBuytime();
	}

}
