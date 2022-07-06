package com.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookStore.entity.Products;


public interface IProductsRepo extends JpaRepository<Products, Integer> {
	
	    String getBookById=" SELECT * FROM `book_store`.`product` WHERE category=:GBBI";
	    @Query(value =getBookById,nativeQuery = true) 
	    public List<Products> getProductByCategory(@Param("GBBI") String category);
	    
	    String getProductByIdCategory=" SELECT * FROM `book_store`.`product` WHERE category=:a AND unit_price<=:b" ;
	    @Query(value =getProductByIdCategory,nativeQuery = true)
	    public List<Products> getProductByCriteria(@Param("a") String category,@Param("b") String price);
	    
	    String getProductById1=" SELECT * FROM `book_store`.`product` WHERE product_id=:a";
	    @Query(value =getProductById1,nativeQuery = true) 
	    public List<Products> getProductByIdList(@Param("a") int id);

}
