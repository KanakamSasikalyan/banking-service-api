package com.rest.banking.service;

import com.rest.banking.dto.AccountDTO;
import com.rest.banking.model.Account;
import com.rest.banking.model.AccountType;
import com.rest.banking.model.Customer;
import com.rest.banking.repository.AccountRepository;
import com.rest.banking.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    CustomerRepository customerRepository;
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    AccountService accountService;

    Account account;
    AccountDTO accountDTO;

    @BeforeEach
    void setUp(){
        account = new Account();
        accountDTO = new AccountDTO();
        accountDTO.setAcctype(AccountType.SAVINGS);
        accountDTO.setBalance(10000000.000d);
        accountDTO.setCurrency("INR");
        accountDTO.setStatus("ACTIVE");

        account.setAcctype(AccountType.SAVINGS);
        account.setStatus("ACTIVE");
        account.setBalance(10000000.000d);
        account.setCurrency("INR");
    }

    @Test
    public void testCreateAccount(){
        when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Customer()));
        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);

        accountService.createAccount(Mockito.anyLong(), accountDTO);

        verify(customerRepository, times(1)).findById(Mockito.anyLong());
        verify(accountRepository, times(1)).save(Mockito.any(Account.class));

        assertEquals("INR", account.getCurrency());
        assertEquals(10000000.000d, account.getBalance());
        assertEquals("ACTIVE", account.getStatus());
        assertEquals(AccountType.SAVINGS, account.getAcctype());
    }

    @Test
    public void testUpdateAccount(){
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Account()));
        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);

        Account account1 = accountService.updateAccount(Mockito.anyLong(), accountDTO);
        verify(accountRepository, times(1)).findById(Mockito.anyLong());
        verify(accountRepository, times(1)).save(Mockito.any(Account.class));

        assertNotNull(account1);
    }

}
