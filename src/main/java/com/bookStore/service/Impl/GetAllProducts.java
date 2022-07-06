package com.bookStore.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Products;
import com.bookStore.repository.IProductsRepo;
import com.bookStore.service.IGetProducts;

@Service
public class GetAllProducts implements IGetProducts {
	
	@Autowired
	IProductsRepo products;

	@Override
	   public List<Products> getAllProductsList() {
	
		List<Products> getAllProducts=products.findAll();
		return getAllProducts;
	}

	@Override
	public List<Products> getAllProductsListByCategory(String category) {
		 List<Products> categotyList=products.getProductByCategory(category);
		return categotyList;
	}

	@Override
	public List<Products> getAllProductsListByCriteria(Map<String,List<String>> Criteria) {
		
		List<Products> getAllProducts=new ArrayList<Products>();
		List<Products> getAllProducts1=new ArrayList<Products>();

		Set<String> criterias = Criteria.keySet();
		if(criterias.contains("category")) {
			if(criterias.contains("price")) {
		for(String brandName: Criteria.get("category")) {
			for(String brandPrice: Criteria.get("price")) {	
				
				getAllProducts=products.getProductByCriteria(brandName, brandPrice);
				getAllProducts1.addAll(getAllProducts);
				getAllProducts.remove(0);
			    }
  
			  }
			
		   }
	   }
		
		return getAllProducts1;
	}

	@Override
	public List<Products> getAllProductsListById(int id) {
		
		List<Products> getAllProducts=products.getProductByIdList(id);
		
		return getAllProducts;
	}
	
	
}
