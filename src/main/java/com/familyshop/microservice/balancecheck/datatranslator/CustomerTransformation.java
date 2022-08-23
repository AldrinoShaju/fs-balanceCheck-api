package com.familyshop.microservice.balancecheck.datatranslator;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.dto.CustomerDTO;

public class CustomerTransformation {

    public static CustomerDTO transformCutomerToDTO(Customer newCustomer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(newCustomer.getName());
        customerDTO.setPhoneNumber(newCustomer.getPhoneNumber());

        return customerDTO;
    }

    public static Customer transformDTOtoCustomer(CustomerDTO customer){
        Customer cust = new Customer();
        cust.setName(customer.getName());
        cust.setPhoneNumber(customer.getPhoneNumber());
        cust.setPaymentStatusList(customer.getPaymentStatusList());
        return cust;
    }
}
