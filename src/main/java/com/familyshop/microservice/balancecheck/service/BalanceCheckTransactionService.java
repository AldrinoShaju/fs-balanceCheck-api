package com.familyshop.microservice.balancecheck.service;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;

public interface BalanceCheckTransactionService {

    public void insertPaymentDetails(String id, TransactionRequest tranReq);
}
