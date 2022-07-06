package com.bookStore.controller;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Products;
import com.bookStore.repository.ICustomerRepo;
import com.bookStore.service.ICustomerAddService;
import com.bookStore.service.IaddProductSI;

 

@Controller
public class MainControl {
	
	@Autowired
	ICustomerRepo addUser;
	
	@Autowired 
	ICustomerAddService customerAdd;
	
	@Autowired
	IaddProductSI addProductSI;
	
	
//	@GetMapping("/")
//	 public ModelAndView welcome(ModelAndView model) {
//	   model.setViewName("redirect:/BookStore/getProducts");
//	return model;
//	}
	
//	@RequestMapping("/BookStore/addUser")
//	 public ModelAndView userAdding(ModelAndView model) {
//		
//		customerAdd.customerAdding();
//		
//	   model.addObject("greeting"," add user done...");
//	   model.addObject("tagline", "The one and only amazing webstore");
//	   model.setViewName("welcome");
//
//	return model;
//	}
//	
	@RequestMapping("/BookStore/addProducts")
	 public ModelAndView productAdding(ModelAndView model) {
		
		addProductSI.addProduct();
		
	   model.addObject("greeting"," add product  done...");
	   model.addObject("tagline", "The one and only amazing webstore");
	   model.setViewName("welcome");

	return model;
	}

	@RequestMapping(value = "/BookStore/addProduct", method = RequestMethod.GET)
	public ModelAndView getAddNewProductForm(ModelAndView MVC) {
	      Products newProduct = new Products();
	      MVC.addObject("newProduct", newProduct);
	      MVC.setViewName("newProduct");
	  return MVC;
	}
	
}
