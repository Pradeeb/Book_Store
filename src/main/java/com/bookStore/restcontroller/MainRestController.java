package com.bookStore.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.EmailDetails;
import com.bookStore.entity.Products;
import com.bookStore.service.IGetProducts;
import com.bookStore.service.IaddProductSI;
import com.bookStore.service.IemailService;
import com.bookStore.util.JwtUtils;

@RestController
public class MainRestController {
	
	@Autowired
	private IGetProducts getProducts;
	
	@Autowired
	private IaddProductSI addNewProductSI;
	
	@Autowired private 
	IemailService emailService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping(value="/BookStore/rest/getProducts")
	public List<Products> list(ModelAndView MVC) {
		
		List<Products>listOfProduct=getProducts.getAllProductsList();
		
		System.out.println(jwtUtils.genrateJwt());
		
		return listOfProduct;
		
	}
	
	@PostMapping(value="/BookStore/rest/addProducts")
	public void addProduct(@RequestBody Products addProduct) {
		
	 addNewProductSI.addNewProductList(addProduct);
		
	}

	 // Sending a simple Email
    @PostMapping("/BookStore/rest/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status= emailService.sendSimpleMail(details);
 
        return status;
    }
    
    // Sending email with attachment
    @PostMapping("/BookStore/rest/sendMailWithFile")
    public String sendMailWithAttachment(
        @RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);
 
        return status;
    }
    
}
