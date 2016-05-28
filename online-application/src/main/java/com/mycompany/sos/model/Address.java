/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * {@link Address} class
 *
 * Address entity
 *
 * @author colin
 */
@Entity
@Table(name = "address")
public class Address {

	private int addressId;

	@NotNull(message = "{error.null.houseFlatNo}")
	@Min(value = 1, message = "{error.min.houseFlatNo}")
	private int houseFlatNo;

	@NotNull(message = "{error.null.street}")
	@NotBlank(message = "{error.blank.street}")
	@NotEmpty(message = "{error.empty.street}")
	@Pattern(regexp = "[a-zA-Z ]*", message = "{error.invalid.street}")
	private String street;

	@NotNull(message = "{error.null.postcode}")
	@NotBlank(message = "{error.blank.postcode}")
	@NotEmpty(message = "{error.empty.postcode}")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "{error.invalid.postcode}")
	private String postCode;

	@NotNull(message = "{error.null.city}")
	@NotBlank(message = "{error.blank.city}")
	@NotEmpty(message = "{error.empty.city}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.city}")
	private String city;

	@NotNull(message = "{error.null.country}")
	@NotBlank(message = "{error.blank.country}")
	@NotEmpty(message = "{error.empty.country}")
	@Pattern(regexp = "[a-zA-Z]*", message = "{error.invalid.country}")
	private String country;

	// 1 : M
	private Set<Customer> customers = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "house_flat_no", nullable = false)
	public int getHouseFlatNo() {
		return houseFlatNo;
	}

	public void setHouseFlatNo(int houseFlatNo) {
		this.houseFlatNo = houseFlatNo;
	}

	@Column(name = "street", nullable = false, length = 255)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "postcode", nullable = false, length = 8)
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "city", nullable = false, length = 15)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", nullable = false, length = 20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return addressId == address.addressId &&
            houseFlatNo == address.houseFlatNo &&
            Objects.equals(street, address.street) &&
            Objects.equals(postCode, address.postCode) &&
            Objects.equals(city, address.city) &&
            Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, houseFlatNo, street, postCode, city, country);
    }

    @Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseFlatNo="
				+ houseFlatNo + ", street=" + street + ", postCode=" + postCode
				+ ", city=" + city + ", country=" + country + "]";
	}


}