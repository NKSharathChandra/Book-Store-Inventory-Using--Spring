package com.example.bookinventoryapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    private int orderId;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Book> bookList;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Customer customer;

    public Order() {
    }

    public Order(int orderId, List<Book> bookList, Customer customer) {
        this.orderId = orderId;
        this.bookList = bookList;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", bookList=" + bookList +
                ", customer=" + customer +
                '}';
    }
}
