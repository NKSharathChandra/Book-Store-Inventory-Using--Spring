package com.example.bookinventoryapp.controller;

import com.example.bookinventoryapp.exception.CustomerAlreadyExistException;
import com.example.bookinventoryapp.exception.CustomerNotFoundException;
import com.example.bookinventoryapp.model.Customer;
import com.example.bookinventoryapp.model.LoginCredentials;
import com.example.bookinventoryapp.service.CustomerService;
import com.example.bookinventoryapp.service.JWTTokenGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JWTTokenGeneratorService generatorService;

    ResponseEntity<?> responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            String data = customerService.addCustomer(customer);
            responseEntity = new ResponseEntity<String>(data, HttpStatus.CREATED);
        } catch (CustomerAlreadyExistException obj) {
            responseEntity = new ResponseEntity<String>(obj.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity<?> validate(@RequestBody LoginCredentials loginCredentials){
        try{
            Customer customer = customerService.validateCustomer((LoginCredentials) loginCredentials);
            Map<String,String> tokenMap = generatorService.generateToken(customer);
            responseEntity = new ResponseEntity<>(tokenMap,HttpStatus.ACCEPTED);
        }
        catch (CustomerNotFoundException obj) {
            responseEntity = new ResponseEntity<String>(obj.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}

