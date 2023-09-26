package com.example.bookinventoryapp.exception;

public class BookEntityNotFoundException extends RuntimeException {
    public BookEntityNotFoundException(String exceptionMsg){
        super(exceptionMsg);
    }
}
