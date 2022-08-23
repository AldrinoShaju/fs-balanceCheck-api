package com.familyshop.microservice.balancecheck.bean;

import java.util.List;

public class Customer {

    private String name;
    private String phoneNumber;

    private List<PaymentStatus> paymentStatusList;

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

    public List<PaymentStatus> getPaymentStatusList() {
        return paymentStatusList;
    }

    public void setPaymentStatusList(List<PaymentStatus> paymentStatusList) {
        this.paymentStatusList = paymentStatusList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", paymentStatusList=" + paymentStatusList +
                '}';
    }
}
