package com.familyshop.microservice.balancecheck.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest {

    private String id;
    private String transactionDateTime;
    private String amount;

    @JsonProperty("isPaid")
    private boolean paid;
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
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
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
                ", isPaid=" + paid +
                ", remaining='" + remaining + '\'' +
                ", lastUpdateTimeStamp='" + lastUpdateTimeStamp + '\'' +
                '}';
    }
}
