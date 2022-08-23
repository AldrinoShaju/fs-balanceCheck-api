package com.familyshop.microservice.balancecheck.service.impl;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.datatranslator.CustomerTransformation;
import com.familyshop.microservice.balancecheck.dto.CustomerDTO;
import com.familyshop.microservice.balancecheck.repository.BalanceCheckRepository;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceCheckCustomerServiceImpl implements BalanceCheckCustomerService {

    @Autowired
    BalanceCheckRepository repository;

    public Customer getUserPaymentDetails(String id){
        Optional<CustomerDTO> customerDTO = repository.findById(id);
        if(customerDTO.isPresent()) {
            return CustomerTransformation.transformDTOtoCustomer(customerDTO.get());
        }
        return null;
    }

    public void insertNewCustomer(Customer newCustomer){
        CustomerDTO customerDTO = CustomerTransformation.transformCutomerToDTO(newCustomer);
        try{
            repository.save(customerDTO);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<CustomerDTO> fetchAllCustomers() {
        List<CustomerDTO> customerList = repository.findAll();

        return customerList;
    }

    public boolean deleteCustomerFromDB(String custId){

        try{
            repository.deleteById(custId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void updateCustomerDetails(String custId, Customer updateCustomer) {
        Optional<CustomerDTO> currentCustomer = repository.findById(custId);

        if(!currentCustomer.isPresent()){
            return;
        }

        currentCustomer.get().setName(updateCustomer.getName());
        currentCustomer.get().setPhoneNumber(updateCustomer.getPhoneNumber());

        repository.save(currentCustomer.get());
    }

}
