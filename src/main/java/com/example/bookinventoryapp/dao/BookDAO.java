package com.example.bookinventoryapp.dao;

import com.example.bookinventoryapp.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    public List<Book> getBooks();
    public Optional<Book> getBookWithISBN(long ISBN);
    public boolean deleteBookWithISBN(long ISBN);
    public boolean addBook(Book book);

    public boolean updateBookDetailsWithISBN(long ISBN,Book book);
}
