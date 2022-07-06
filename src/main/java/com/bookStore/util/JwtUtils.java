package com.bookStore.util;

import java.nio.charset.StandardCharsets;

import org.aspectj.weaver.StandardAnnotation;
import org.springframework.stereotype.Component;

import com.bookStore.entity.Customers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	private static String secret="This_is_key";
	public String genrateJwt() {
	//claims
		Claims claims=Jwts.claims().setIssuer(String.valueOf(""));
		
	//generate JWT token using claims
		
		//return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.ES512, secret).compact(); //we need add payload
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret.getBytes(StandardCharsets.UTF_8))
				.compact();  //with out pay load
		

		
	}

}
