package com.familyshop.microservice.balancecheck.datatranslator;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;

import static com.familyshop.microservice.balancecheck.util.BalanceCheckUtil.getCurrentTimeStamp;

public class TransactionTransformer {

    public static TransactionRequest transformTxntoDTO(TransactionRequest txnReq){
        TransactionRequest txnDTO = new TransactionRequest();
        txnDTO.setId(txnReq.getId());
        txnDTO.setTxnTimeStamp(getCurrentTimeStamp());
        txnDTO.setAmount(txnReq.getAmount());
        txnDTO.setPaid(false);
        txnDTO.setRemaining(txnReq.getRemaining());
        txnDTO.setDisableTxn(false);
        txnDTO.setNote(txnReq.getNote());
        txnDTO.setLastUpdateTxnTimeStamp(getCurrentTimeStamp());

        return txnDTO;
    }
}
