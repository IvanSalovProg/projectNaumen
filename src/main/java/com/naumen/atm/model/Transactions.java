package com.naumen.atm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transactions {

    @Id
    @GeneratedValue
    private Long id;

    private int countNumber;

    private int transactionSum;

    private String  nameTransaction;

    public Transactions(Long id, int countNumber, int transactionSum, String nameTransaction) {
        this.id = id;
        this.countNumber = countNumber;
        this.transactionSum = transactionSum;
        this.nameTransaction = nameTransaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public int getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(int transactionSum) {
        this.transactionSum = transactionSum;
    }

    public String getNameTransaction() {
        return nameTransaction;
    }

    public void setNameTransaction(String nameTransaction) {
        this.nameTransaction = nameTransaction;
    }


}
