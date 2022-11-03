package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fName")
	private String firstName;
	
	@Column(name = "lName")
	private String lastName;
	
	@Column(name = "balance")
	private double accountBalance;
	
	@Column(name = "email")
	private String emailId;
	
	
	public Customer() {
		
	}
	
	
	public Customer(String firstName, String lastName, double accountBalance, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.emailId = emailId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}
