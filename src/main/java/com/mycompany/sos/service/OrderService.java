/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Order;

/**
 * {@link OrderService} interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	/**
	 * Adds a new order
	 * 
	 * @param order the new order to add
	 * @return true if successfully added false otherwise
	 */
	boolean addOrder(Order order);
	
	/**
	 * Gets a list of orders
	 * 
	 * @return list of orders
	 */
	List<Order> getOrders();
}
