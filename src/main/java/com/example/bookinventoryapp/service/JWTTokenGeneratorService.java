package com.example.bookinventoryapp.service;

import com.example.bookinventoryapp.model.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JWTTokenGeneratorService {
    @Value("${jwt.secret.key}")
    private String secretKey;

    public Map<String,String> generateToken(Customer customer){
        long expirationMillis = System.currentTimeMillis() + 600000;
        Date expirationDate = new Date(expirationMillis);
        String token = Jwts.builder()
                .setSubject(customer.getCustomerEmail())
                .setIssuer("Inventory App")
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return Map.of("token",token);
    }
}
