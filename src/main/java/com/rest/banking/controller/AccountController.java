package com.rest.banking.controller;

import com.rest.banking.dto.AccountDTO;
import com.rest.banking.model.Account;
import com.rest.banking.service.AccountService;
import com.rest.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount/{id}")
    public ResponseEntity<Account> createAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        Account account = accountService.createAccount(id, accountDTO);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/updateAccount/{id}/{index}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        Account account = accountService.updateAccount(id, accountDTO);
        return ResponseEntity.ok(account);
    }
}
