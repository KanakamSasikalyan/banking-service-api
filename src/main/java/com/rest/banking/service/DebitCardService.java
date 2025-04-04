package com.rest.banking.service;

import com.rest.banking.dto.DebitCardDTO;
import com.rest.banking.model.Account;
import com.rest.banking.model.DebitCard;
import com.rest.banking.repository.AccountRepository;
import com.rest.banking.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DebitCardService {


    @Autowired
    DebitCardRepository debitCardRepository;

    @Autowired
    AccountRepository accountRepository;

    public DebitCard applyDebitCard(Long acc_id, DebitCardDTO debitCardDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(acc_id);
        Account account = optionalAccount.get();

        DebitCard debitCard = new DebitCard();

        debitCard.setCardNumber(debitCardDTO.getCardNumber());
        debitCard.setCardHolderName(debitCardDTO.getCardHolderName());
        debitCard.setExpiryDate(debitCardDTO.getExpiryDate());
        debitCard.setAccount(account);

        debitCardRepository.save(debitCard);

        return debitCard;
    }
}
