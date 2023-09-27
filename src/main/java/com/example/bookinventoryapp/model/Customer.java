package com.example.bookinventoryapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    private String customerEmail;
    private String customerName;
    private String password;
    private long contactNo;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Book> bookList;

    public Customer() {
    }

    public Customer(String customerEmail, String customerName, String password, long contactNo, Account account, List<Book> bookList) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.password = password;
        this.contactNo = contactNo;
        this.account = account;
        this.bookList = bookList;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", contactNo=" + contactNo +
                ", account=" + account +
                ", bookList=" + bookList +
                '}';
    }
}
