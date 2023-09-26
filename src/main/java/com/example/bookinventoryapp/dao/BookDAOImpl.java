package com.example.bookinventoryapp.dao;
import com.example.bookinventoryapp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAOImpl implements BookDAO {


    List<Book> bookList;

    public BookDAOImpl() {
        bookList =new ArrayList<>();
    }

    @Override
    public List<Book> getBooks() {

        return bookList;
    }

    @Override
    public Optional<Book> getBookWithISBN(long ISBN) {
        return bookList.stream().filter(book->book.getISBN() == ISBN).findAny();
    }

    @Override
    public boolean deleteBookWithISBN(long ISBN) {
        return bookList.removeIf(book -> book.getISBN() == ISBN);
    }

    @Override
    public boolean addBook(Book book) {
        Optional<Book> bookOpt = getBookWithISBN(book.getISBN());
        if(bookOpt.isEmpty()){
            bookList.add(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBookDetailsWithISBN(long ISBN,Book book) {
        Optional<Book> existingBookOpt = getBookWithISBN(ISBN);
        if( !existingBookOpt.isEmpty() ){
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setQuantity(book.getQuantity());
            existingBook.setLocation(book.getLocation());
            existingBook.setPrice(book.getPrice());
            return true;
        }
        return false;
    }
}
