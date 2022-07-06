package com.bookStore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Products;
import com.bookStore.repository.IProductsRepo;
import com.bookStore.service.IaddProductSI;
 
@Service
public class AddProducts implements IaddProductSI{

	@Autowired
	IProductsRepo addProduct;
	
	@Override 
	public void addProduct() {

	}

	@Override
	public void addNewProductList(Products newProduct) {
		
		addProduct.save(newProduct);
		
	}
	

}
