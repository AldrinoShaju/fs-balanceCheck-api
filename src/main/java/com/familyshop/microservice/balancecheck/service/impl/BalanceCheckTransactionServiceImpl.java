package com.familyshop.microservice.balancecheck.service.impl;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;
import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.bean.UpdateTransactionRequest;
import com.familyshop.microservice.balancecheck.repository.BalanceCheckRepository;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import com.familyshop.microservice.balancecheck.service.BalanceCheckTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.familyshop.microservice.balancecheck.datatranslator.TransactionTransformer.transformTxntoDTO;
import static com.familyshop.microservice.balancecheck.util.BalanceCheckUtil.getCurrentTimeStamp;

@Service
public class BalanceCheckTransactionServiceImpl implements BalanceCheckTransactionService {

    @Autowired
    BalanceCheckRepository repository;

    @Autowired
    BalanceCheckCustomerService customerService;

    @Override
    public void insertPaymentDetails(String custId, TransactionRequest txnReq) {
        Customer currentCust = new Customer();

        try{
            currentCust = customerService.getUserPaymentDetails(custId);
        }catch (Exception e){
            throw e;
        }

        TransactionRequest txnDTO = transformTxntoDTO(txnReq);

        currentCust.getPaymentStatusList().add(txnDTO);


        int remainingAmount = currentCust.getTotalRemaining();
        currentCust.setTotalRemaining(remainingAmount + txnReq.getRemaining());

        if(currentCust.getTotalRemaining()!=0){
            currentCust.setAllPaid(false);
        }

        repository.save(currentCust);
    }


    @Override
    public void updatedExistingPaymentDetails(String custId, String txnId, UpdateTransactionRequest updateTxnReq) {

        Customer currentCust = new Customer();

        try{
            currentCust = customerService.getUserPaymentDetails(custId);
        }catch (Exception e){
            throw e;
        }

        if(null==currentCust.getPaymentStatusList()){
            return;
        }

        List<TransactionRequest> updatedList = currentCust.getPaymentStatusList();

        for(TransactionRequest txnDTO: updatedList){
            if(txnDTO.getId().equals(txnId)){
                txnDTO.setRemaining(txnDTO.getRemaining() - updateTxnReq.getPayedAmount());
                txnDTO.setDisableTxn(updateTxnReq.isDisableTxn());
                txnDTO.setNote(updateTxnReq.getNote());
                txnDTO.setLastUpdateTxnTimeStamp(getCurrentTimeStamp());
                if(txnDTO.getRemaining()==0){
                    txnDTO.setPaid(true);
                }
            }
        }

        currentCust.setPaymentStatusList(updatedList);

        int remainingAmount = currentCust.getTotalRemaining();
        currentCust.setTotalRemaining(remainingAmount - updateTxnReq.getPayedAmount());

        if(currentCust.getTotalRemaining() == 0){
            currentCust.setAllPaid(true);
        }

        repository.save(currentCust);
    }
}
