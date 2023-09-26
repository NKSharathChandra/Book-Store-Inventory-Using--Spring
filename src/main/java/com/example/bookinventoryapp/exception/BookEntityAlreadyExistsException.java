package com.example.bookinventoryapp.exception;

public class BookEntityAlreadyExistsException extends RuntimeException {
    public BookEntityAlreadyExistsException(String exceptionMsg){
        super(exceptionMsg);
    }
}
