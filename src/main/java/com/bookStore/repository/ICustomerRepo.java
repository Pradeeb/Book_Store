package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.entity.Customers;


public interface ICustomerRepo extends JpaRepository<Customers, Integer> {
  Customers findByUsername(String username);
}
	