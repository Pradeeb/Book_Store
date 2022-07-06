package com.bookStore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Customers;
import com.bookStore.repository.ICustomerRepo;
import com.bookStore.service.ICustomerAddService;

@Service
public class AddCustomers implements ICustomerAddService {
	
	@Autowired
	ICustomerRepo customerRepo;
	    
    public AddCustomers(ICustomerRepo customerRepo) {
        super();
        this.customerRepo = customerRepo;
    }
 
	@Override
	public void customerAdding() {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String password1="Valan@123";
		String password2="pradeeb@123";
		password1=encoder.encode(password1);
		password2=encoder.encode(password2);
		
		Customers newCustomer=new Customers(1,"Valan","valan",password1,"admin","chennai","0");
		customerRepo.save(newCustomer);
		Customers newCustomer1=new Customers(2,"pradeeb","pradeeb",password2,"user","chennai","0");
		customerRepo.save(newCustomer1);
		
	}
	
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customers  user=customerRepo.findByUsername(username);
		
		 if (user == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
		 return new MyUserDetails(user);
	    }

	@Override
	public Customers save(Customers registrationDto) {
		
		return null;
	}
	}


