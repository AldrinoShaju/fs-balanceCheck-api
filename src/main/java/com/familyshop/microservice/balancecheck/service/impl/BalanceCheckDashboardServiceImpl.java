package com.familyshop.microservice.balancecheck.service.impl;

import com.familyshop.microservice.balancecheck.bean.CustomerSummary;
import com.familyshop.microservice.balancecheck.bean.TopContributerList;
import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.repository.BalanceCheckRepository;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import com.familyshop.microservice.balancecheck.service.BalanceCheckDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceCheckDashboardServiceImpl implements BalanceCheckDashboardService {

    @Autowired
    BalanceCheckRepository repository;

    @Autowired
    BalanceCheckCustomerService customerService;

    @Override
    public List<Integer> getDashBoardDetails() {

        List<Customer> allCustomers = new ArrayList<>();
        try {
            allCustomers = customerService.fetchAllCustomers();
        }catch (Exception e){
            throw e;
        }

        int toPay = 0, toGet = 0;

        for(Customer cust: allCustomers){
            if(cust.getTotalRemaining()>0){
                toGet += cust.getTotalRemaining();
            } else if (cust.getTotalRemaining()<0) {
                toPay+=cust.getTotalRemaining();
            }
        }

        List<Integer> dashBoardData = new ArrayList<>();
        dashBoardData.add(toGet);
        dashBoardData.add(toPay);


       return dashBoardData;
    }

    @Override
    public TopContributerList getTopContributer() {
        List<Customer> allCustomers = new ArrayList<>();
        try {
            allCustomers = customerService.fetchAllCustomers();
        }catch (Exception e){
            throw e;
        }

        List<CustomerSummary> out = new ArrayList<>();
        List<CustomerSummary> in = new ArrayList<>();

        TopContributerList contributerList = new TopContributerList();

        for(Customer cust: allCustomers){
            if(cust.getTotalRemaining()>0){
                in.add(createCustomerSummaryObject(cust));
            }else if(cust.getTotalRemaining()<0){
                out.add(createCustomerSummaryObject(cust));
            }
        }

        contributerList.setIn(in);
        contributerList.setOut(out);
        return contributerList;
    }

    public CustomerSummary createCustomerSummaryObject(Customer cust){
        CustomerSummary customerSummary = new CustomerSummary();
        customerSummary.setName(cust.getName());
        customerSummary.setId(cust.getId());
        customerSummary.setAmount(cust.getTotalRemaining());

        return customerSummary;
    }
}
