package com.example.bookinventoryapp.controller;

import com.example.bookinventoryapp.exception.BookEntityAlreadyExistsException;
import com.example.bookinventoryapp.exception.BookEntityNotFoundException;
import com.example.bookinventoryapp.exception.BookPriceLimitException;
import com.example.bookinventoryapp.exception.BookQuantityConstraintException;
import com.example.bookinventoryapp.model.Book;
import com.example.bookinventoryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/inventory")
public class BookController {

    @Autowired
    private BookService bookService;

    ResponseEntity<?> responseEntity;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        try{
            String statusMsg = bookService.addBook(book);
            responseEntity = new ResponseEntity<String>(statusMsg,HttpStatus.CREATED);
        }
        catch (BookEntityAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/ListBooks")
    public ResponseEntity<?> listBooks(){
        List<Book> bookList = bookService.getAllBooks();

        if( !bookList.isEmpty()){
            responseEntity = new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<String>("No books found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/Books/{ISBN}")
    public ResponseEntity<?> getBookWithISBN(@PathVariable long ISBN){
        try{
            Book bookWithISBN = bookService.getBookWithISBN(ISBN);
            responseEntity = new ResponseEntity<Book>(bookWithISBN,HttpStatus.FOUND);
        }
        catch (BookEntityNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/Books/{ISBN}")
    public ResponseEntity<?> deleteBookWithISBN(@PathVariable long ISBN){
        try{
            String msg = bookService.deleteBookWithISBN(ISBN);
            responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch (BookEntityNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PutMapping("/updateBook/{ISBN}")
    public ResponseEntity<?> updateBookDetails(@PathVariable long ISBN,@RequestBody Book book){
        try{
            String msg = bookService.updateBookWithISBN(ISBN,book);
            responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
        }
        catch (BookPriceLimitException | BookQuantityConstraintException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }

}
