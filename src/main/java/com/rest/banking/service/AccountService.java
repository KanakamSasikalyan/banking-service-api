package com.rest.banking.service;

import com.rest.banking.dto.AccountDTO;
import com.rest.banking.model.Account;
import com.rest.banking.model.Customer;
import com.rest.banking.repository.AccountRepository;
import com.rest.banking.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Long id, AccountDTO accountDTO){
        Optional<Customer> customer = customerRepository.findById(id);
        Account account = new Account();
        account.setAcctype(accountDTO.getAcctype());
        account.setBalance(accountDTO.getBalance());
        account.setBranchcode(accountDTO.getBranchcode());
        account.setCurrency(accountDTO.getCurrency());
        account.setStatus(accountDTO.getStatus());
        account.setCustomer(customer.get());

        accountRepository.save(account);

        return account;
    }

    @Transactional
    public Account updateAccount(Long id, AccountDTO accountDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account account = optionalAccount.get();

        account.setAcctype(accountDTO.getAcctype());
        account.setStatus(accountDTO.getStatus());
        account.setBalance(accountDTO.getBalance());

        accountRepository.save(account);
        return account;
    }
}
