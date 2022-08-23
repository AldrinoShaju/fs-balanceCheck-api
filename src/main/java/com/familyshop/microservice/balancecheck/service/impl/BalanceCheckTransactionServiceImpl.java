package com.familyshop.microservice.balancecheck.service.impl;

import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.bean.PaymentStatus;
import com.familyshop.microservice.balancecheck.bean.TransactionRequest;
import com.familyshop.microservice.balancecheck.dto.CustomerDTO;
import com.familyshop.microservice.balancecheck.repository.BalanceCheckRepository;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import com.familyshop.microservice.balancecheck.service.BalanceCheckTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BalanceCheckTransactionServiceImpl implements BalanceCheckTransactionService {

    @Autowired
    BalanceCheckRepository repository;

    @Autowired
    BalanceCheckCustomerService customerService;

    @Override
    public void insertPaymentDetails(String id, TransactionRequest tranReq) {
        Optional<CustomerDTO> currentCustomer = repository.findById(id);

        if(null==currentCustomer.get().getPaymentStatusList()){
            currentCustomer.get().setPaymentStatusList(new ArrayList<PaymentStatus>());
        }

        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setAmount(Integer.valueOf(tranReq.getAmount()));
        paymentStatus.setId(tranReq.getId());
        paymentStatus.setPaid(tranReq.getPaid());
        paymentStatus.setRemaining(Integer.valueOf(tranReq.getRemaining()));

        currentCustomer.get().getPaymentStatusList().add(paymentStatus);

        repository.save(currentCustomer.get());
    }

    @Override
    public void updatedExistingPaymentDetails(String custID, String transID, TransactionRequest tranReq) {
        Optional<CustomerDTO> currentCustomer = repository.findById(custID);

        if(null==currentCustomer.get().getPaymentStatusList()){
            return;
        }

        List<PaymentStatus> updatedList = currentCustomer.get().getPaymentStatusList();

        updatedList = updatedList.stream().filter(item->!item.getId().equals(transID)).collect(Collectors.toList());

        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setAmount(Integer.valueOf(tranReq.getAmount()));
        paymentStatus.setId(transID);
        paymentStatus.setPaid(tranReq.getPaid());
        paymentStatus.setRemaining(Integer.valueOf(tranReq.getRemaining()));
        paymentStatus.setDisableTxn(tranReq.isDisableTxn());

        updatedList.add(paymentStatus);

        currentCustomer.get().setPaymentStatusList(updatedList);

        repository.save(currentCustomer.get());
    }
}
