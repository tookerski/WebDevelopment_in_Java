package org.tookerski.onlineshop.service;

public interface OrderService {
	void processOrder(String productId,long quantity);
}
