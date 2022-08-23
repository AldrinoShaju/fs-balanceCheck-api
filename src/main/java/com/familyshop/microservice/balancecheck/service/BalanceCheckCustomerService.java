package com.familyshop.microservice.balancecheck.service;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.dto.CustomerDTO;

import java.util.List;

public interface BalanceCheckCustomerService {
    public Customer getUserPaymentDetails(String id);

    public void insertNewCustomer(Customer newCustomer);

    public List<CustomerDTO> fetchAllCustomers();

    public boolean deleteCustomerFromDB(String custId);

    public void updateCustomerDetails(String custId, Customer updateCustomer);
}
