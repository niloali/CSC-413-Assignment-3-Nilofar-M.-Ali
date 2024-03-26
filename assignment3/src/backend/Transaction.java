//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int accountId;
    private String type;
    private double amount;
    private Timestamp timestamp;

    public Transaction() {
    }

    public Transaction(int accountId, String type, double amount, Timestamp timestamp) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

