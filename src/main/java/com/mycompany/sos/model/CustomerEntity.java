/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * {@link CustomerEntity} class
 * 
 * Customer entity
 * 
 * @author colin
 *
 */
@Entity
@Table(name = "customer")
public class CustomerEntity {

	private int customerId;
	
	@NotNull(message = "{error.null.firstname}")
	@NotBlank(message = "{error.blank.firstname}")
	@NotEmpty(message = "{error.empty.firstname}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.firstname}")
	private String firstName;
	
	@NotNull(message = "{error.null.lastname}")
	@NotBlank(message = "{error.blank.lastname}")
	@NotEmpty(message = "{error.empty.lastname}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.lastname}")
	private String lastName;
	
	@NotNull(message = "{error.null.dob}")
	@Past(message = "{error.past.dob}")
	private Date dateOfBirth;
	
	@NotNull(message = "{error.null.email}")
	@NotBlank(message = "{error.blank.email}")
	@NotEmpty(message = "{error.empty.email}")
	@Email(message = "{error.email}")
	private String email;

	// M : 1
	@Valid
	private AddressEntity address;
	
	// 1 : 1
	@Valid
	private CustomerPaymentDetailEntity customerPaymentDetail;
	
	// 1 : M
	private Set<OrderEntity> orders = new HashSet<OrderEntity>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "customer_firstname", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "customer_lastname", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customer_date_of_birth", nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "customer_email_address", nullable = false, columnDefinition = "TEXT")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "customer_address_id")
	public AddressEntity getAddress() {
		return address;
	}
	
	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = {CascadeType.ALL})
	public CustomerPaymentDetailEntity getCustomerPaymentDetail() {
		return customerPaymentDetail;
	}

	public void setCustomerPaymentDetail(CustomerPaymentDetailEntity customerPaymentDetail) {
		this.customerPaymentDetail = customerPaymentDetail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", address=" + address
				+ ", customerPaymentDetail=" + customerPaymentDetail
				+ ", orders=" + orders + "]";
	}

	
}
