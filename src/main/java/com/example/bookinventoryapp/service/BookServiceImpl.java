package com.example.bookinventoryapp.service;

import com.example.bookinventoryapp.dao.BookDAOUsingJPA;
import com.example.bookinventoryapp.exception.BookEntityAlreadyExistsException;
import com.example.bookinventoryapp.exception.BookEntityNotFoundException;
import com.example.bookinventoryapp.exception.BookPriceLimitException;
import com.example.bookinventoryapp.exception.BookQuantityConstraintException;
import com.example.bookinventoryapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAOUsingJPA dao;

    @Override
    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    @Override
    public Book getBookWithISBN(long ISBN) throws BookEntityNotFoundException {
        Optional<Book> bookOpt = dao.findById(ISBN);
        if(bookOpt.isEmpty()){
            throw new BookEntityNotFoundException("Book with given ISBN not present");
        }
        return bookOpt.get();
    }

    @Override
    public String deleteBookWithISBN(long ISBN) throws BookEntityNotFoundException {
        Optional<Book> bookOpt = dao.findById(ISBN);
        if(bookOpt.isEmpty()){
            throw new BookEntityNotFoundException("Book to delete with given ISBN is not present");
        }
        dao.deleteById(ISBN);
        return "Book entity deleted successfully";
    }

    @Override
    public String addBook(Book book) throws BookEntityAlreadyExistsException {
        Book book1 = dao.save(book);
        if( book1 == null){
            throw new BookEntityAlreadyExistsException("Book entity already exists");
        }
        return "Book entity added successfully to the inventory";
    }

    @Override
    public String updateBookWithISBN(long ISBN, Book book) throws BookPriceLimitException, BookQuantityConstraintException {
        if( book.getPrice() >= 1000.00 ){
            throw new BookPriceLimitException("Book MRP cannot be updated to more than 1000 rupees");
        }
        if( book.getQuantity() >= 500 ){
            throw new BookQuantityConstraintException("Quantity cannot exceed more than 500");
        }
        Book bookUpdated = dao.save(book);
        if( bookUpdated == null){
            throw new BookEntityAlreadyExistsException("Book entity already exists");
        }
        return "Book details updated successfully";
    }

}
