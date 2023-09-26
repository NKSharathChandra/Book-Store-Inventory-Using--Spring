package com.example.bookinventoryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private String customerEmail;
    private String customerName;
    private String password;
    private long contactNo;

    public Customer() {
    }

    public Customer(String customerEmail, String customerName, String password, long contactNo) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.password = password;
        this.contactNo = contactNo;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }
}
