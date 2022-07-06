package com.bookStore.controller;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Products;
import com.bookStore.service.IGetProducts;
import com.bookStore.service.IaddProductSI;

@Controller
public class ProductController {
	
	@Autowired
	private IGetProducts getProducts;
	
	@Autowired
	private IaddProductSI addNewProductSI;
	
	//get all product
	@RequestMapping("/BookStore/getProducts")
	public ModelAndView list(ModelAndView MVC) {
	
		List<Products>listOfProduct=getProducts.getAllProductsList();
		MVC.addObject("productList", listOfProduct);
		MVC.setViewName("products");
		
		return MVC;
		
	}
	
	//get product category list
	@RequestMapping("/BookStore/getProducts/{category}")
	public ModelAndView getProductsByCategory(ModelAndView MVC,@PathVariable("category") String productCategory) {
		
		List<Products>listOfProductByCategory=getProducts.getAllProductsListByCategory(productCategory);
		MVC.addObject("productList", listOfProductByCategory);
		MVC.setViewName("products");
		
	return MVC;
	}
	
	//get product ByCriteria list
	@RequestMapping("/BookStore/getProducts/filter/{ByCriteria}")
	public ModelAndView getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") 
	Map<String,List<String>> filterParams,ModelAndView MVC) {
		
		List<Products>listOfProductByCategory=getProducts.getAllProductsListByCriteria(filterParams);
		MVC.addObject("productList", listOfProductByCategory);
		MVC.setViewName("products");

	return MVC;
	}
	
	@RequestMapping("/BookStore/product")
	public ModelAndView getProductById(@RequestParam("id")int productId, ModelAndView MVC) {
		
		List<Products>listOfProductByCategory=getProducts.getAllProductsListById(productId);
		MVC.addObject("productList", listOfProductByCategory);
		MVC.setViewName("products");
	return MVC;
	}
	
	
	@RequestMapping(value = "/BookStore/add", method = RequestMethod.GET)
	public ModelAndView getAddNewProductForm(ModelAndView MVC) {
	Products newProduct = new Products();
	MVC.addObject("newProduct", newProduct);
	MVC.setViewName("newProduct");
	return MVC;
	}
	
	@RequestMapping(value = "/BookStore/add", method = RequestMethod.POST)
	public ModelAndView processAddNewProductForm(@ModelAttribute("newProduct") Products newProduct,ModelAndView MVC) {
		
		addNewProductSI.addNewProductList(newProduct);
		MVC.setViewName("redirect:/BookStore/getProducts");
	return MVC;
	}

}
