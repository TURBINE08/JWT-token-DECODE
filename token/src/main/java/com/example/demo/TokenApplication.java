package com.example.demo;

import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootApplication
public class TokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenApplication.class, args);
		String key = "NIT";
		String token = 
				Jwts.builder()
				.setId("45")			
				.setSubject("name")
				.signWith(SignatureAlgorithm.HS384, Base64.getEncoder().encode(key.getBytes()))
				.compact();
		System.err.println(token);
		
	
	
	Claims c = 
			Jwts.parser()
			.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
			.parseClaimsJws(token)
			.getBody();
	System.out.println(c.getId());
	System.out.println(c.getSubject());

;
	}

}
