package com.main.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private int orderId;
	private float orderQuality;
	private int price;
	private String orderType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getOrderQuality() {
		return orderQuality;
	}

	public void setOrderQuality(float orderQuality) {
		this.orderQuality = orderQuality;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Order() {
		super();
	}

	public Order(int userId, int orderId, float orderQuality, int price, String orderType) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.orderQuality = orderQuality;
		this.price = price;
		this.orderType = orderType;
	}

	public static Comparator<Order> compOrder = new Comparator<Order>() {

		public int compare(Order o1, Order o2) {
			int price1 = o1.getPrice();
			int price2 = o2.getPrice();
			/*
			 * if(price1==price2) { return o1.getOrderQuality()+o2.getOrderQuality(); } else
			 */
			if(price1<price2)
			{
				return price1;
			}
			return price2;
		}
	};

}
