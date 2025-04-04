package com.rest.banking.controller;

import com.rest.banking.dto.CreditCardDTO;
import com.rest.banking.model.CreditCard;
import com.rest.banking.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/applyCreditCard/{acc_id}")
    public ResponseEntity<CreditCard> applyCreditCard(@PathVariable Long acc_id,@RequestBody CreditCardDTO creditCardDTO){
        CreditCard applyCard = creditCardService.applyCreditCard(acc_id, creditCardDTO);
        return ResponseEntity.ok(applyCard);
    }

}
