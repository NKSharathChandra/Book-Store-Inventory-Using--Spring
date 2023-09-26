package com.example.bookinventoryapp.service;

import com.example.bookinventoryapp.model.Customer;
import com.example.bookinventoryapp.model.LoginCredentials;

public interface CustomerService {
    public String addCustomer(Customer customer);
    public Customer validateCustomer(LoginCredentials loginCredentials);
}
