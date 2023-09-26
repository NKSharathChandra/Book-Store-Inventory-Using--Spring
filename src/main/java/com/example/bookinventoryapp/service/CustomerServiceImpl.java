package com.example.bookinventoryapp.service;

import com.example.bookinventoryapp.dao.CustomerDAO;
import com.example.bookinventoryapp.exception.CustomerAlreadyExistException;
import com.example.bookinventoryapp.exception.CustomerNotFoundException;
import com.example.bookinventoryapp.model.Customer;
import com.example.bookinventoryapp.model.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer validateCustomer(LoginCredentials loginCredentials) {
        Optional<Customer> customerOptional = customerDAO.findByCustomerEmailAndPassword(loginCredentials.getEmail(), loginCredentials.getPassword());
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found, Credentials are invalid");
        }
        return customerOptional.get();
    }

    @Override
    public String addCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customer.getCustomerEmail());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer Already Exist");
        }
        customerDAO.save(customer);
        return "Customer Registered Successfully";
    }
}
