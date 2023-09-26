package com.example.bookinventoryapp.service;
import com.example.bookinventoryapp.exception.BookEntityAlreadyExistsException;
import com.example.bookinventoryapp.exception.BookEntityNotFoundException;
import com.example.bookinventoryapp.exception.BookPriceLimitException;
import com.example.bookinventoryapp.exception.BookQuantityConstraintException;
import com.example.bookinventoryapp.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookWithISBN(long ISBN) throws BookEntityNotFoundException;
    public String deleteBookWithISBN(long ISBN) throws BookEntityNotFoundException;
    public String addBook(Book book) throws BookEntityAlreadyExistsException;

    public String updateBookWithISBN(long ISBN,Book book) throws BookPriceLimitException, BookQuantityConstraintException;
}
