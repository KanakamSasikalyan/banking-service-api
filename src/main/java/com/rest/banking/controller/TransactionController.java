package com.rest.banking.controller;

import com.rest.banking.model.Transaction;
import com.rest.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/doTransaction/{transFrom}/{transTo}/{amount}")
    public ResponseEntity<Transaction> doTransaction(@PathVariable Long transFrom, @PathVariable Long transTo, @PathVariable Double amount){
        Transaction transaction = transactionService.doTransaction(transFrom, transTo, amount);
        return ResponseEntity.ok(transaction);
    }
}