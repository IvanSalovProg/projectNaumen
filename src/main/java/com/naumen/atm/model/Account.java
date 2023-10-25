package com.naumen.atm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {

    public Account( int countNumber, int countSum, String countName) {

        this.countNumber = countNumber;
        this.countSum = countSum;
        this.countName = countName;
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

    public int getCountSum() {
        return countSum;
    }

    public void setCountSum(int countSum) {
        this.countSum = countSum;
    }

    public String getCountName() {
        return countName;
    }

    public void setCountName(String countName) {
        this.countName = countName;
    }

    @Id
    @GeneratedValue
    private Long id;

    private int countNumber;

    private int countSum;

    private String countName;

public Account(){

}
    public String getName() {
        return "HistoryData";
    }
}
