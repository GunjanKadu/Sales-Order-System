/**
 * 
 */
package com.mycompany.sos.service;

import java.util.List;

import com.mycompany.sos.model.Order;
import com.mycompany.sos.repository.entities.OrderEntity;

/**
 * OrderService interface
 * 
 * @author colin
 *
 */
public interface OrderService {

	boolean addOrder(OrderEntity order);
	
	List<Order> getOrders();
}
