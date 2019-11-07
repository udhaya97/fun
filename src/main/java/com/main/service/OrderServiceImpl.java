package com.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.OrderRepo;
import com.main.model.Order;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo oRepo;
	
	@Override
	public void createOrder(Order order) {
		oRepo.save(order);
	}

	@Override
	public List<Order> allOrders() {
		List<Order> ls = (List<Order>) oRepo.findAll();
		return ls;
	}

	@Override
	public Order findByPrice(float price) {
		Order order = oRepo.findByPrice(price);
		return order;
	}

	@Override
	public List<Order> showOrders(List<Order> order,String oType) {
		List<Order> lOne = new ArrayList<>();
		List<Order> lTwo =new ArrayList<>();
		
		String s="SELL";
		for(Order o:order)
		{
			if(o.getOrderType().equalsIgnoreCase(s))
			{
				lOne.add(o);
			}else
			{
				lTwo.add(o);
			}
		}
		
		if(oType.equalsIgnoreCase(s))
		{
			Collections.sort(lOne,Order.compOrder);
			return lOne;
		}
		Collections.sort(lTwo,Order.compOrder.reversed());
		return lTwo;
	}

	@Override
	public void deleteOrder(float price) {
		oRepo.deleteByPrice(price);
		
	}

}
