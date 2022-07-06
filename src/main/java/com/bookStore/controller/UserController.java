package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Customers;
import com.bookStore.service.ICustomerAddService;

@Controller
public class UserController {
	
	@Autowired
	ICustomerAddService addUserService;
	
	@RequestMapping(value = "/BookStore/adduser", method = RequestMethod.GET)
	public ModelAndView getAddNewProductForm(ModelAndView MVC) {
	Customers newUser = new Customers();
	MVC.addObject("newUser", newUser);
	MVC.setViewName("newUserAdd");
	return MVC;
	}
	
	@RequestMapping(value = "/BookStore/adduser", method = RequestMethod.POST)
	public ModelAndView processAddNewProductForm(@ModelAttribute("newProduct") Customers newUser,ModelAndView MVC) {
		addUserService.customerAdding();
		MVC.setViewName("login");
	return MVC;
	}

}
