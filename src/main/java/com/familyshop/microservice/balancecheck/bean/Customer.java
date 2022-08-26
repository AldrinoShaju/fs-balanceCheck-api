package com.familyshop.microservice.balancecheck.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("balanceCheck")
public class Customer {

    @Id
    private String id;
    private String accountCreateTimeStamp;
    private String name;
    private String phoneNumber;
    private boolean allPaid;
    private int totalRemaining;
    private List<TransactionRequest> transactionRequestList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TransactionRequest> getPaymentStatusList() {
        return transactionRequestList;
    }

    public void setPaymentStatusList(List<TransactionRequest> transactionRequestList) {
        this.transactionRequestList = transactionRequestList;
    }

    public boolean isAllPaid() {
        return allPaid;
    }

    public void setAllPaid(boolean allPaid) {
        this.allPaid = allPaid;
    }

    public int getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(int totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public String getAccountCreateTimeStamp() {
        return accountCreateTimeStamp;
    }

    public void setAccountCreateTimeStamp(String accountCreateTimeStamp) {
        this.accountCreateTimeStamp = accountCreateTimeStamp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", accountCreateTimeStamp='" + accountCreateTimeStamp + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", allPaid=" + allPaid +
                ", totalRemaining=" + totalRemaining +
                ", paymentStatusList=" + transactionRequestList +
                '}';
    }


}
