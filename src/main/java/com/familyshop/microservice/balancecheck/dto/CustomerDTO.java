package com.familyshop.microservice.balancecheck.dto;

import com.familyshop.microservice.balancecheck.bean.PaymentStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.List;

@Document("balanceCheck")
public class CustomerDTO {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private List<PaymentStatus> paymentStatusList;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String phoneNumber, List<PaymentStatus> paymentStatusList) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.paymentStatusList = paymentStatusList;
    }

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

    public List<PaymentStatus> getPaymentStatusList() {
        return paymentStatusList;
    }

    public void setPaymentStatusList(List<PaymentStatus> paymentStatusList) {
        this.paymentStatusList = paymentStatusList;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", paymentStatusList=" + paymentStatusList +
                '}';
    }
}
