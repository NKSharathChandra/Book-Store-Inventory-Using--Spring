package com.example.bookinventoryapp.dao;

import com.example.bookinventoryapp.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CustomerDAO extends JpaRepository<Customer,String> {
    Optional<Customer> findByCustomerEmailAndPassword(String email, String password);
}
