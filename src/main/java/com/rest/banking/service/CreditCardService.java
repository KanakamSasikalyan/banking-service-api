package com.rest.banking.service;

import com.rest.banking.dto.CreditCardDTO;
import com.rest.banking.model.Account;
import com.rest.banking.model.CreditCard;
import com.rest.banking.repository.AccountRepository;
import com.rest.banking.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    AccountRepository accountRepository;

    public CreditCard applyCreditCard(Long acc_id, CreditCardDTO creditCardDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(acc_id);
        Account account = optionalAccount.get();

        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(creditCardDTO.getCardNumber());
        creditCard.setCardHolderName(creditCardDTO.getCardHolderName());
        creditCard.setExpiryDate(creditCardDTO.getExpiryDate());
        creditCard.setAccount(account);

        creditCardRepository.save(creditCard);

        return creditCard;
    }
}
