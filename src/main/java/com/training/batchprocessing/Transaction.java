package com.training.batchprocessing;

import java.sql.Timestamp;

public class Transaction {
    private String transactionId;
    private Integer amount;
    private String timestamp;
    private String transactionType = null;

    public Transaction(){

    }

    public Transaction(String transactionId, Integer amount, String timestamp, String transactionType) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getTimestamp() {return timestamp;}

    public String getTransactionId() {return transactionId;}

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType(){return transactionType;}

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String toString() {
        return "transaction type: " + transactionType + ", amount: " + amount + ", transaction id:" + transactionId;
    }

}
