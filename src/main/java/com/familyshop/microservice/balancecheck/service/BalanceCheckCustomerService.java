package com.familyshop.microservice.balancecheck.service;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.bean.CustomerRequest;

import java.util.List;

public interface BalanceCheckCustomerService {
    public Customer getUserPaymentDetails(String id);

    public void insertNewCustomer(CustomerRequest newCustomer);

    public List<Customer> fetchAllCustomers();

    public void deleteCustomerFromDB(String custId);

    public void updateCustomerDetails(String custId, CustomerRequest updateCustomer);
}
