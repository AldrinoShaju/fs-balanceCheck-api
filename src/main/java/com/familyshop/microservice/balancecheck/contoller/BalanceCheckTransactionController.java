package com.familyshop.microservice.balancecheck.contoller;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;
import com.familyshop.microservice.balancecheck.bean.UpdateTransactionRequest;
import com.familyshop.microservice.balancecheck.service.BalanceCheckTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class BalanceCheckTransactionController {

    @Autowired
    BalanceCheckTransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity addNewTransaction(@RequestParam("id") String id, @RequestBody TransactionRequest transactionRequest){
        try{
            transactionService.insertPaymentDetails(id, transactionRequest);
        }catch (Exception e){
            return new ResponseEntity("Transaction failed to Add, error occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity("Transaction Added", HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity editExisitingtTransaction(@RequestParam("id") String id,
                                                    @RequestParam("txnId") String txnId,
                                                    @RequestBody UpdateTransactionRequest updateTxn){

        try{
            transactionService.updatedExistingPaymentDetails(id, txnId, updateTxn);
        }catch (Exception e){
            return new ResponseEntity("Failed to update transaction, error occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity("Transaction Updated", HttpStatus.OK);
    }

}
