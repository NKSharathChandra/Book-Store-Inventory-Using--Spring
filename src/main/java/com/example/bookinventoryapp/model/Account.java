package com.example.bookinventoryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private long accountNo;
    private String bankName;
    private String IFSC;

    public Account() {
    }

    public Account(long accountNo, String bankName, String IFSC) {
        this.accountNo = accountNo;
        this.bankName = bankName;
        this.IFSC = IFSC;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", bankName='" + bankName + '\'' +
                ", IFSC='" + IFSC + '\'' +
                '}';
    }
}
