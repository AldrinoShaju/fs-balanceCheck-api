package com.familyshop.microservice.balancecheck.datatranslator;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.bean.CustomerRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerTransformation {

    public static Customer transformCustomerToDTO(CustomerRequest newCustomer){
        Customer customer = new Customer();
        customer.setName(newCustomer.getName());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customer.setAllPaid(true);
        customer.setAccountCreateTimeStamp(getCurrentTimeStamp());
        customer.setTotalRemaining(0);
        customer.setPaymentStatusList(new ArrayList<>());

        return customer;
    }

    public static Customer transformDTOtoCustomer(Customer customer){
        Customer cust = new Customer();
        cust.setName(customer.getName());
        cust.setPhoneNumber(customer.getPhoneNumber());
        cust.setPaymentStatusList(customer.getPaymentStatusList());
        return cust;
    }

    private static String getCurrentTimeStamp(){
        ZonedDateTime date = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String text = date.format(formatter);
        return text;
    }

}
