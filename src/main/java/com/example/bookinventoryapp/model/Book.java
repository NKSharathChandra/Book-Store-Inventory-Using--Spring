package com.example.bookinventoryapp.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    private long ISBN;
    private String title;
    private String publisher;
    private int quantity;
    private double price;
    private String location;

//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
//    private Customer customer;

    public Book() {
    }

    public Book(long ISBN, String title, String publisher, int quantity, double price, String location) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.quantity = quantity;
        this.price = price;
        this.location = location;
//        this.customer = customer;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", location='" + location + '\'' +
//                ", customer=" + customer +
                '}';
    }
}
