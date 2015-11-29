/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service;

import com.mycompany.sos.model.Customer;
import com.mycompany.sos.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * {@link CustomerServiceImpl} class
 * 
 * implementation of the {@link CustomerService} interface
 * 
 * @author colin
 *
 */
@Service("customerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("Adding new customer to system: " + customer);
		return customerRepository.addCustomer(customer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getCustomers() {
		logger.info("Retrieving customers list");
		return customerRepository.getCustomers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerName(String customerName) {
		Customer customer = customerRepository.findCustomerByCustomerName(customerName);
		if(customer != null) {
			return customer;
		}
		throw new RuntimeException("Unknown Customer with name: " + customerName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByCustomerId(int customerId) {
		Customer customer = customerRepository.findCustomerByCustomerId(customerId);
		
		if(customer != null) {
			return customer;
		}
		throw new RuntimeException("Unknown Customer with id: " + customerId);
		
	}

}
