package com.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Order;
import com.main.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService oServ;
	
	@RequestMapping("/register")
	public String saveOrder(@RequestBody Order order)
	{
		
		oServ.createOrder(order);
		return "Order Registered Successfully";
	}
	
	@RequestMapping("/allorder/{orderType}")
	public List<Order> getAllOrder(@PathVariable("ordertype") String ordType)
	{
		List<Order> lOrder = oServ.allOrders();
		List<Order> lisOrd=new ArrayList<>();
		
		
		 lisOrd =oServ.showOrders(lOrder,ordType);
		
		
		return lisOrd;
	}

}
