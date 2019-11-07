package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.model.Order;

@Service
public interface OrderService {
	
	void createOrder(Order order);
	List<Order> allOrders();
	Order findByPrice(float price);
	List<Order> showOrders(List<Order> order,String oType);
	void deleteOrder(float price);
	

}
