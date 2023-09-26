package com.example.bookinventoryapp.exception;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String customerAlreadyExist) {
        super(customerAlreadyExist);
    }
}
