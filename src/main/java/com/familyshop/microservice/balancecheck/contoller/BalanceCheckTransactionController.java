package com.familyshop.microservice.balancecheck.contoller;

import com.familyshop.microservice.balancecheck.bean.TransactionRequest;
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

    @PostMapping("/add_transaction")
    public ResponseEntity addNewTransaction(@RequestParam("id") String id, @RequestBody TransactionRequest transactionRequest){
        transactionService.insertPaymentDetails(id, transactionRequest);
        return new ResponseEntity("Transaction Added", HttpStatus.OK);
    }

}
