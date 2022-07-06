package com.bookStore.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bookStore.entity.Customers;

public interface ICustomerAddService extends UserDetailsService {

	void customerAdding();
	Customers save(Customers registrationDto);
}
