package com.example.bookinventoryapp.dao;

import com.example.bookinventoryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAOUsingJPA extends JpaRepository<Book,Long> {
}
