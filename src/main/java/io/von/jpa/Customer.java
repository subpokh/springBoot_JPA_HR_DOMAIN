package io.von.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name="CUSTOMERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(name="FIRSTNAME", nullable = false)
	private String firstName;
	@Column(name="LASTNAME", nullable = false)
	private String lastName;
	@Column(name="ADDRESS", nullable = false)
	private String address;
	@Column(name="PHONE", nullable = false)
	private long phone;
	@Column(name="HIREDDATE", nullable = false)
	private Date hiredDate;
	
	public Customer() {
		super();
	}

	public Customer(int customerId, String firstName, String lastName, String address, long phone, Date hiredDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.hiredDate = hiredDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}	
	
}
