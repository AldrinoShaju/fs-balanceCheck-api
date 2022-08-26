package com.familyshop.microservice.balancecheck.service;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;
import com.familyshop.microservice.balancecheck.bean.UpdateTransactionRequest;

public interface BalanceCheckTransactionService {

    public void insertPaymentDetails(String id, TransactionRequest tranReq);

    public void updatedExistingPaymentDetails(String custID, String transID, UpdateTransactionRequest tranReq);
}
