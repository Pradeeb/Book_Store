package com.bookStore.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;
    
    @Column(name = "category")
    private String category;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "no_Of_Orders_Made")
	private String noOfOrdersMade ; 
	
	public Customers() {
		 super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(String noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", category=" + category + ", address=" + address + ", noOfOrdersMade=" + noOfOrdersMade
				+ "]";
	}

	public Customers(int customerId, String name, String username, String password, String category, String address,
			String noOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
		this.address = address;
		this.noOfOrdersMade = noOfOrdersMade;
	}
	

}

