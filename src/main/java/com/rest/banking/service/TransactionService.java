package com.rest.banking.service;

import com.rest.banking.model.Account;
import com.rest.banking.model.Transaction;
import com.rest.banking.repository.AccountRepository;
import com.rest.banking.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository  accountRepository;

    @Transactional
    public Transaction doTransaction(Long transFrom, Long transTo, Double amount) {
        Account account1 = (accountRepository.findById(transFrom)).get();
        Account account2 = (accountRepository.findById(transTo)).get();

        account2.setBalance(account2.getBalance()+amount);
        account1.setBalance(account1.getBalance()-amount);

        accountRepository.save(account1);
        accountRepository.save(account2);

        Transaction transaction = new Transaction();
        transaction.setTransFrom(transFrom);
        transaction.setTransTo(transTo);
        transaction.setAmount(amount);

        transactionRepository.save(transaction);

        return transaction;
    }
}
