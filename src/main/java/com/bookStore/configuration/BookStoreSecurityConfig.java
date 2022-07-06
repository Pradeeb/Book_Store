package com.bookStore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bookStore.service.ICustomerAddService;

@Configuration
@EnableWebSecurity
public class BookStoreSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ICustomerAddService customerService;
		
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setUserDetailsService(customerService);
	        auth.setPasswordEncoder(passwordEncoder());
	        return auth;
	    }

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/BookStore/adduser/**").permitAll()
		.antMatchers("/BookStore/rest/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("name")
		.passwordParameter("password")
		.loginProcessingUrl("/BookStore/login")
		.successForwardUrl("/BookStore/getProducts")
		.permitAll()
		.and()
		.logout()
        .permitAll();
			
	}
	

}
