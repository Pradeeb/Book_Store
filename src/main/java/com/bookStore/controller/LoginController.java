package com.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	
	@RequestMapping(value ="/BookStore/login" ,method =RequestMethod.POST )
    public ModelAndView loginerror(ModelAndView mvc) {
		mvc.setViewName("redirect:/BookStore/getProducts");
        return mvc;
    }

    
}