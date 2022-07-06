package com.bookStore.service;

import java.util.List;
import java.util.Map;

import com.bookStore.entity.Products;

public interface IGetProducts {

	public List<Products> getAllProductsList();
	public List<Products> getAllProductsListByCategory(String category);
	public List<Products> getAllProductsListByCriteria(Map<String,List<String>> Criteria);
	public List<Products> getAllProductsListById(int id);
}
