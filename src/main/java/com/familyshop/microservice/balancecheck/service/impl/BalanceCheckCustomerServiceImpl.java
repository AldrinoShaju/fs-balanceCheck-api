package com.familyshop.microservice.balancecheck.service.impl;

import com.familyshop.microservice.balancecheck.bean.CustomerRequest;
import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.repository.BalanceCheckRepository;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.familyshop.microservice.balancecheck.datatranslator.CustomerTransformation.transformCustomerToDTO;

@Service
public class BalanceCheckCustomerServiceImpl implements BalanceCheckCustomerService {

    @Autowired
    BalanceCheckRepository repository;

    public Customer getUserPaymentDetails(String custId){
        try {

            Optional<Customer> customerDTO = repository.findById(custId);

            if(customerDTO.isPresent()) {
                return customerDTO.get();
            }

            throw new RuntimeException("No Customer found for id: "+custId);

        }catch (Exception e){
            throw e;
        }
    }

    public void insertNewCustomer(CustomerRequest customer){
        Customer newCustomer = transformCustomerToDTO(customer);
        try{
            repository.save(newCustomer);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<Customer> fetchAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = repository.findAll();
        }catch (Exception e){
            throw e;
        }

        return customerList;
    }

    public void deleteCustomerFromDB(String custId){

        if(!repository.existsById(custId)){
            throw new RuntimeException("Customer does not exist with id "+custId);
        }

        try{
            repository.deleteById(custId);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public void updateCustomerDetails(String custId, CustomerRequest updateCustomer) {
        Customer currentCust = new Customer();
        try{
            currentCust = getUserPaymentDetails(custId);
        }catch (Exception e){
            throw e;
        }

        if(updateCustomer.getName()!=null){
            currentCust.setName(updateCustomer.getName());
        }

        if(updateCustomer.getPhoneNumber()!=null){
            currentCust.setPhoneNumber(updateCustomer.getPhoneNumber());
        }

        repository.save(currentCust);
    }

}
