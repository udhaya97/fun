package com.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Order;

public interface OrderRepo extends CrudRepository<Order, Integer> {

	Order findByPrice(float price);

	void deleteByPrice(float price);

}
