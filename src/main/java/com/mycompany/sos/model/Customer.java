/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@link Customer} class
 * 
 * domain model object for representing a customer
 * 
 * @author colin
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	
	private Address address;
	private CustomerPaymentDetails customerPaymentDetails;
	
	private List<Order> orders = new ArrayList<>();
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public CustomerPaymentDetails getCustomerPaymentDetails() {
		return customerPaymentDetails;
	}
	
	public void setCustomerPaymentDetails(
			CustomerPaymentDetails customerPaymentDetails) {
		this.customerPaymentDetails = customerPaymentDetails;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", address=" + address + ", customerPaymentDetails=" + customerPaymentDetails
				+ ", orders=" + orders + "]";
	}
	
	
	
}
