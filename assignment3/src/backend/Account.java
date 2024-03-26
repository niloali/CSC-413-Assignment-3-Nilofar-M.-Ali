//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Date;

// Account class to manage customer accounts
public class Account {
    private int id;
    private int customerId;
    private String type;
    private double balance;
    private Date creationDate;

    // Default constructor
    public Account() {
    }

    // Parameterized constructor to initialize account details
    public Account(int customerId, String type, double balance, Date creationDate) {
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

