package com.familyshop.microservice.balancecheck.bean;

public class TransactionRequest {

    private String id;
    private String transactionDateTime;
    private String amount;
    private boolean isPaid;
    private String remaining;
    private String lastUpdateTimeStamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(String lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "id='" + id + '\'' +
                ", transactionDateTime='" + transactionDateTime + '\'' +
                ", amount='" + amount + '\'' +
                ", isPaid=" + isPaid +
                ", remaining='" + remaining + '\'' +
                ", lastUpdateTimeStamp='" + lastUpdateTimeStamp + '\'' +
                '}';
    }
}
